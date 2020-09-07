package com.example.asus.graduationproject.PersonMod.QuickHelpMod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.util.Log;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.asus.graduationproject.Tools.GlobalUitl;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public  class QuickHelpReceiver extends BroadcastReceiver {
    private static final String TAG="QuickHelpReceiver" ;
    private static int  defaultCount=3;//默认3次
    private Context context;
    private  int count=defaultCount;
    private static long lastTime;

    private String name;
    private String content;
    private String address=null;

    LocationClient locationClient;
    public  synchronized  void onReceive(Context context, Intent intent) {
        this.context=context;
        SharedPreferences sharedPreferences=context.getSharedPreferences(GlobalUitl.accoutName,MODE_PRIVATE);
        defaultCount=sharedPreferences.getInt("helpCount",3);
        long curtime = System.currentTimeMillis();
        //1秒内连续点击算一次有效点击
        final long  interval = 1000;
        long delt= curtime-lastTime;
        lastTime = curtime;
        if (delt<interval) {
            Log.d("QuickHelpReceiver", "还有"+count+"次");
            count--;

                if(count==0){
                    Log.d("QuickHelpReceiver", "发送求助信息");
           /*     Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(3000);*/
                    getLoaction();
                    //count=defaultCount;

            }
        }else{
            count=defaultCount;//否则次数清零
        }
    }



    private synchronized void getLoaction(){
        locationClient=new LocationClient(context.getApplicationContext()   );
        MyLocationListener myListener = new MyLocationListener();
        locationClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedLocationPoiList(true);
        option.setIsNeedAddress(true);
    //可选，是否需要地址信息，默认为不需要，即参数为false
    //如果开发者需要获得当前点的地址信息，此处必须为true
        option.setIsNeedLocationDescribe(true);
        option.setNeedNewVersionRgc(true);
        option.setScanSpan(500);
    //可选，设置是否需要最新版本的地址信息。默认需要，即参数为true
        /*option.setAddrType("all");*/
        option.setCoorType("bd09ll");

        locationClient.setLocOption(option);

        locationClient.start();

    }

    public class  MyLocationListener extends BDAbstractLocationListener {
        @Override
        public synchronized void onReceiveLocation(BDLocation location){
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            String locationDescribe = location.getLocationDescribe();
            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            int errorCode = location.getLocType();
            Log.d(TAG,errorCode+"");
            String addrStr = location.getAddrStr();
            StringBuilder stringBuilde=new StringBuilder();
            stringBuilde.append("当前所在位置为：").append(addrStr).append(locationDescribe).append("(经度：").append(longitude).append(",纬度：").append(latitude)
            .append(")");
            address=stringBuilde.toString();
            //发送短信
            SharedPreferences sharedPreferences=context.getSharedPreferences(GlobalUitl.accoutName,MODE_PRIVATE);
            name=sharedPreferences.getString("helpPerson","");
            content=sharedPreferences.getString("helpContent","");
            Log.d(TAG,"联系人："+name+"\n+联系内容："+content+"当前位置"+address);

            SmsManager smsManager=SmsManager.getDefault();
            ArrayList<String> list = smsManager.divideMessage(content+address);
           /* for(int i=0;i<list.size();i++){
                smsManager.sendTextMessage(name,null,list.get(i),null,null);
            }*/
            smsManager.sendMultipartTextMessage(name,null,list,null,null);
            locationClient.stop();
    }}

}
