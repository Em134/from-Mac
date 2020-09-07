package com.example.asus.graduationproject.DailyMod;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.R;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepCountService extends Service implements SensorEventListener {
    private static final String TAG="StepCountService";
    private static final String ID="channel_2";
    private static final String NAME="前台服务2";

    String name;//用户名
    String date;//今天日期
    private boolean hasRecord=false;
    private int hasStepCount=0;
    private int previousStepCount=0;
    public static int step;

    SensorManager manager;
    Sensor mStepCount;
    Sensor mStepDetector;
    NotificationManager notificationManager;
    public StepCountService() {

    }

    @Override
    public IBinder onBind(Intent intent) {


        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate(){
        super.onCreate ();
        Log.d (TAG,"onCreate");

        SharedPreferences islogin=getSharedPreferences("login",MODE_PRIVATE);
        name=islogin.getString("account","");

        final SharedPreferences getStep=getSharedPreferences(name,MODE_PRIVATE);
        date=getStep.getString("today","");
        if(date.equals(GlobalUitl.getToday())){
            step=getStep.getInt("todayStep",0);

        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendStep(getStep.getInt("todayStep",0),GlobalUitl.getToday());//发送到服务器
                }
            }).start();
            step=0;
        }
        Log.d(TAG,step+"");
        if(Build.VERSION.SDK_INT>=26){
            initView();
            setForeground();
        }

    }
    @Override
    public void onDestroy(){
        super.onDestroy ();
        SharedPreferences.Editor editor=getSharedPreferences(name,MODE_PRIVATE).edit();
        editor.putInt("todayStep",step);
        editor.putString("today", GlobalUitl.getToday());
        editor.apply();
        Log.d (TAG,"Service onDestroy");
    }


    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand (intent,flags,startId);
    }
    private void initView() {
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //单次有效计步
        mStepCount = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //系统计步累加值
        mStepDetector=manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        manager.registerListener(this, mStepCount, SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_GAME);
    }
    @TargetApi(26)
    private void setForeground(){
        notificationManager=(NotificationManager)getSystemService (NOTIFICATION_SERVICE);
        NotificationChannel channel=new NotificationChannel (ID,NAME,NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel (channel);

        Notification notification=new Notification.Builder (this,ID)
                .setContentTitle ("今日运动步数:"+step+"步")
                .setSmallIcon (R.mipmap.ic_launcher)
                .setLargeIcon (BitmapFactory.decodeResource (getResources (),R.mipmap.ic_launcher))
                .build ();
        startForeground (2,notification);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            //获取当前传感器返回的临时步数
            int tempStep = (int) event.values[0];
            //首次如果没有获取手机系统中已有的步数则获取一次系统中APP还未开始记步的步数
            if (!hasRecord) {
                hasRecord = true;
                hasStepCount = tempStep;
            } else {
                //获取APP打开到现在的总步数=本次系统回调的总步数-APP打开之前已有的步数
                int thisStepCount = tempStep - hasStepCount;
                //本次有效步数=（APP打开后所记录的总步数-上一次APP打开后所记录的总步数）
                int thisStep = thisStepCount - previousStepCount;
                //总步数=现有的步数+本次有效步数
                step += (thisStep);
                //记录最后一次APP打开到现在的总步数
                previousStepCount = thisStepCount;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    Notification notification=new Notification.Builder (this,ID)
                            .setContentTitle ("今日运动步数："+ step+"步")
                            .setSmallIcon (R.mipmap.ic_launcher)
                            .setLargeIcon (BitmapFactory.decodeResource (getResources (),R.mipmap.ic_launcher))
                            .build ();
                    notificationManager.notify(2,notification);
                }
            }
            SharedPreferences.Editor editor=getSharedPreferences(name,MODE_PRIVATE).edit();
            editor.putInt("todayStep",step);
            editor.putString("today", date);
            editor.apply();
            Log.d (TAG,"Service onDestroy");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void sendStep(int step,String date){
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(5, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        Request.Builder builder=new Request.Builder();
        Map<Object,Object> map=new HashMap<>();
        map.put("user_name",name);
        map.put("date",date);
        map.put("step",step);
        String gson=new Gson().toJson(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson);
        Log.d(TAG,gson);
        final Request request = builder.url(GlobalUitl.BaseURL + "queryExamItemName").post(requestBody).build();
        final Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Looper.prepare();
                Toast.makeText(StepCountService.this,"网络故障，请稍后再尝试连接！",Toast.LENGTH_SHORT).show();
                Log.d(TAG,"连接失败");
                Looper.loop();
            }


            @Override
            public void onResponse(Response response) throws IOException {
                Log.d(TAG,"连接成功");
            }
        });
    }

}
