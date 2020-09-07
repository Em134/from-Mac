package com.example.a.androidui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityTry4 extends AppCompatActivity {

    private ImageView picture;
    public static final int TAKE_PHOTO = 1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try4);       //舌诊界面

       Button abc2 = (Button) this.findViewById(R.id.photoshot);
        picture = (ImageView) findViewById(R.id.image_photo1);
        abc2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                        File outputImage=new File(getExternalCacheDir(),"output_image.jpg");

                        try {
                            if (outputImage.exists()) {
                                outputImage.delete();
                            }
                            outputImage.createNewFile();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                        if(Build.VERSION.SDK_INT >= 24){
                            imageUri= FileProvider.getUriForFile(ActivityTry4.this,"com.example.a.androidui.fileprovider",outputImage) ;
                        }
                        else{
                            imageUri=Uri.fromFile(outputImage);
                        }
                        //启动相机
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                        startActivityForResult(intent, TAKE_PHOTO);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

         switch (requestCode){
             case TAKE_PHOTO:
                 if(requestCode==RESULT_OK){
                     try{
                         Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                         picture.setImageBitmap(bitmap);
                     }
                     catch (FileNotFoundException e){
                         e.printStackTrace();
                     }
                 }
                 break;
                 default:
                     break;
         }

    }


}

