package com.example.a.androidui;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class ActivityTakePhoto extends AppCompatActivity {
    public static final int TAKE_PHOTO = 1;
    private ImageView picture;
    private Uri imaeUri;

    private String img_src;
    private static final int ALBUM_REQUEST_CODE = 2;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    static String postUrl = "http://j23370k297.51mypc.cn:28217/analyze:predict";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkPermission();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takephoto_niubi);
        Button takephoto = findViewById(R.id.takephoto1111);
        picture = findViewById(R.id.imageout);


        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//                }//申请SD卡的读写权限

                File outputImage = new File(getExternalCacheDir(), "./test.jpg");//创建File对象，用于存放拍摄下的图片，后面的参数为图片名称
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    ActivityCompat.requestPermissions(ActivityTakePhoto.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                    imaeUri = FileProvider.getUriForFile(ActivityTakePhoto.this, "com.example.a.androidui.fileprovider", outputImage);
                    //Uri对象既imaeUri为图片的真实路径，

                } else {
                    imaeUri = Uri.fromFile(outputImage);

                }

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imaeUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });

        //从相册选取图片
        Button selectphoto=findViewById(R.id.slectphoto11111);
        selectphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPicFromAlbm();

            }
        });


        //上传图片的按钮
        Button updataphoto = findViewById(R.id.updataphoto11111);
        updataphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
                Bitmap bitmap2 = null;
                try {
                    bitmap2 = BitmapFactory.decodeStream(getContentResolver().openInputStream(imaeUri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                final String updatapicture = Bitmap2StrByBase64(bitmap2);

                System.out.println("---------------------------------" + updatapicture);



                Toast.makeText(ActivityTakePhoto.this, "上传了", Toast.LENGTH_SHORT).show();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {


                            JSONObject baseJson = new JSONObject();
                            JSONObject instanceJson = new JSONObject();
                            JSONObject postJson = new JSONObject();
                            baseJson.put("b64", updatapicture);
                            instanceJson.put("image_bytes", baseJson);
                            JSONArray jsonArray = new JSONArray();
                            jsonArray.put(instanceJson);
                            postJson.put("instances", jsonArray);
                            String postString = postJson.toString();

                            System.out.println("======="+postString);
                            OkHttpClient client = new OkHttpClient();
//                            CloseableHttpClient httpClient = HttpClients.createDefault();
                            HttpPost post = new HttpPost(postUrl);
                            post.setHeader("Content-Type","application/json;charset=utf-8");
                            post.addHeader("Authorization", "Basic YWRtaW46");
                            StringEntity postingString = new StringEntity(postString,"utf-8");
                            post.setEntity(postingString);
                            HttpResponse response=new DefaultHttpClient().execute(post);

//                            HttpResponse response = client.execute(post);

                            if(response.getStatusLine().getStatusCode()==200){
                                HttpEntity entity=response.getEntity();
                                String result= EntityUtils.toString(entity, "utf-8");
                                System.out.println("===== result : "+result);


                                if(result.equals("{\"predictions\":\"white\"}")){
                                    Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultWhite.class);//跳转到白色舌苔界面
                                    startActivity(intent);
                                }else if (result.equals("{\"predictions\":\"yellow\"}")){
                                    Intent intent=new Intent(ActivityTakePhoto.this,ActivityResultYellow.class);//跳转到黄色舌苔界面
                                    startActivity(intent);
                                }else if (result.equals("{\"predictions\":\"black\"}")){
                                    Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultBlack.class);//跳转到黑色舌苔界面
                                    startActivity(intent);
                                }else if (result.equals("{\"predictions\":\"red\"}")){
                                    Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultRed.class);//跳转到黑色舌苔界面
                                    startActivity(intent);
                                }else {
                                    Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultErro.class);//跳转识别错误界面
                                    startActivity(intent);
                                }

                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imaeUri));
                    picture.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case ALBUM_REQUEST_CODE:
                handleImageOnKitKat(data);
                String photoPath=getAumblePath(data);
                Bitmap bitmap3 = BitmapFactory.decodeFile(photoPath);
                updatapictureFromablen(bitmap3);

                break;

            default:
                break;
        }


    }



    String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    List<String> mPermissionList = new ArrayList<>();

    // private ImageView welcomeImg = null;
    private static final int PERMISSION_REQUEST = 1;
    // 检查权限

    private void checkPermission() {
        System.out.println("检查权限");
        mPermissionList.clear();
        //判断哪些权限未授予
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        /**
         * 判断是否为空
         */
        if (mPermissionList.isEmpty()) {//未授予的权限为空，表示都授予了

        } else {//请求权限方法
            String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
            ActivityCompat.requestPermissions(ActivityTakePhoto.this, permissions, PERMISSION_REQUEST);
        }
    }

    /**
     * 响应授权
     * 这里不管用户是否拒绝，都进入首页，不再重复申请权限
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST:

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    //将bitmap转化成base64

    /**
     * 通过Base32将Bitmap转换成Base64字符串
     *
     * @param bit
     * @return
     */
    public String Bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 100, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);
    }

    private String getImagePath(Uri uri,String selection){
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,selection,null,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));

            }
            cursor.close();
        }
        return path;
    }

    private void handleImageOnKitKat(Intent data){
        String imagePath=null;
        Uri uri=data.getData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(DocumentsContract.isDocumentUri(this,uri)){
                String docId=DocumentsContract.getDocumentId(uri);
                if("com.android.providers.media.document".equals(uri.getAuthority())){
                    String id=docId.split(":")[1];
                    String selection=MediaStore.Images.Media._ID+"="+id;
                    imagePath=getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
                }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                    Uri contentUri= ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                    imagePath=getImagePath(contentUri,null);

                }
            }else if("content".equalsIgnoreCase(uri.getScheme())){
                imagePath=getImagePath(uri,null);
            }else if("file".equalsIgnoreCase(uri.getScheme())){
                imagePath=uri.getPath();
            }
            displayImage(imagePath);
        }
    }


    private String getAumblePath(Intent data){
        String imagePath=null;
        Uri uri=data.getData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(DocumentsContract.isDocumentUri(this,uri)){
                String docId=DocumentsContract.getDocumentId(uri);
                if("com.android.providers.media.document".equals(uri.getAuthority())){
                    String id=docId.split(":")[1];
                    String selection=MediaStore.Images.Media._ID+"="+id;
                    imagePath=getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
                }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                    Uri contentUri= ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                    imagePath=getImagePath(contentUri,null);

                }
            }else if("content".equalsIgnoreCase(uri.getScheme())){
                imagePath=getImagePath(uri,null);
            }else if("file".equalsIgnoreCase(uri.getScheme())){
                imagePath=uri.getPath();
            }

        }
        return imagePath;

    }

    private void displayImage(String imagePath) {
        if(imagePath!=null){
            Bitmap bitmap2 = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap2);
        }else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatapictureFromablen(Bitmap bitmap){



        final String updatapicture2 = Bitmap2StrByBase64(bitmap);

        System.out.println("---------------------------------" + updatapicture2);



        Toast.makeText(ActivityTakePhoto.this, "上传了", Toast.LENGTH_SHORT).show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    JSONObject baseJson = new JSONObject();
                    JSONObject instanceJson = new JSONObject();
                    JSONObject postJson = new JSONObject();
                    baseJson.put("b64", updatapicture2);
                    instanceJson.put("image_bytes", baseJson);
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(instanceJson);
                    postJson.put("instances", jsonArray);
                    String postString = postJson.toString();

                    System.out.println("======="+postString);
                    OkHttpClient client = new OkHttpClient();
//                            CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpPost post = new HttpPost(postUrl);
                    post.setHeader("Content-Type","application/json;charset=utf-8");
                    post.addHeader("Authorization", "Basic YWRtaW46");
                    StringEntity postingString = new StringEntity(postString,"utf-8");
                    post.setEntity(postingString);
                    HttpResponse response=new DefaultHttpClient().execute(post);

//                            HttpResponse response = client.execute(post);

                    if(response.getStatusLine().getStatusCode()==200){
                        HttpEntity entity=response.getEntity();
                        String result= EntityUtils.toString(entity, "utf-8");
                        System.out.println("===== result : "+result);

                        if(result.equals("{\"predictions\":\"white\"}")){
                            Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultWhite.class);//跳转到白色舌苔界面
                            startActivity(intent);
                        }else if (result.equals("{\"predictions\":\"yellow\"}")){
                            Intent intent=new Intent(ActivityTakePhoto.this,ActivityResultYellow.class);//跳转到黄色舌苔界面
                            startActivity(intent);
                        }else if (result.equals("{\"predictions\":\"black\"}")){
                            Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultBlack.class);//跳转到黑色舌苔界面
                            startActivity(intent);
                        }else if (result.equals("{\"predictions\":\"red\"}")){
                            Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultRed.class);//跳转到黑色舌苔界面
                            startActivity(intent);
                        }else {
                            Intent intent=new Intent(ActivityTakePhoto.this, ActivityResultErro.class);//跳转识别错误界面
                            startActivity(intent);
                        }

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}



