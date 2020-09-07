package com.example.asus.graduationproject.PersonMod.QuickHelpMod;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.example.asus.graduationproject.R;

public class QuickHelpService extends Service {
    private static final String TAG="MyService";
    private static final String ID="channel_1";
    private static final String NAME="前台服务";

    QuickHelpReceiver quickHelpReceiver ;

    public QuickHelpService() {

    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate(){
        super.onCreate ();
        Log.d (TAG,"onCreate");
        if(Build.VERSION.SDK_INT>=26){
            setForeground();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy ();
        Log.d (TAG,"onDestroy");
        if(quickHelpReceiver!=null){
            unregisterReceiver(quickHelpReceiver);
        }
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d(TAG,"onStartCommand");
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.intent.action.SCREEN_ON");
        mIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        if(quickHelpReceiver==null){
            quickHelpReceiver= new QuickHelpReceiver();
            registerReceiver(quickHelpReceiver,mIntentFilter);
        }
        return super.onStartCommand (intent,flags,startId);
    }

    @TargetApi(26)
    private void setForeground(){
        NotificationManager manager=(NotificationManager)getSystemService (NOTIFICATION_SERVICE);
        NotificationChannel channel=new NotificationChannel (ID,NAME,NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel (channel);
        Notification notification=new Notification.Builder (this,ID)
                .setContentTitle ("紧急求救开启中")
                .setSmallIcon (R.mipmap.ic_launcher)
                .setLargeIcon (BitmapFactory.decodeResource (getResources (),R.mipmap.ic_launcher))
                .build ();
        startForeground (1,notification);
    }

}
