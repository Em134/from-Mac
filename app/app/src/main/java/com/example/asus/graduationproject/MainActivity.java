package com.example.asus.graduationproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.asus.graduationproject.DailyMod.DailyFragment;
import com.example.asus.graduationproject.DailyMod.StepCountService;
import com.example.asus.graduationproject.EvaluateMod.EvaluateFragment;
import com.example.asus.graduationproject.HealthMod.HealthFragment;
import com.example.asus.graduationproject.PersonMod.PersonFragment;
import com.example.asus.graduationproject.PersonMod.QuickHelpMod.QuickHelpService;
import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    //主界面


   //private VpAdapter adapter;
    private BottomNavigationViewEx bnve;
   // private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private List<Fragment> fragments;

    private static final String Tag="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        initData();
        initView();
        initEvent();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.container,fragments.get(0));
        ft.addToBackStack(null);
        ft.commit();
        gaintPermissions();
        Log.d(Tag, GlobalUitl.accoutName);

    }


    /**
     * create fragments
     */
    private void initData() {
        GlobalUitl.accoutName=getSharedPreferences("login",MODE_PRIVATE).getString("account","");
        fragments = new ArrayList<>(4);


        HealthFragment healthFragment = new HealthFragment();


        DailyFragment dailyFragment = new DailyFragment();



        EvaluateFragment shopFragment = new EvaluateFragment();


        // create friends fragment and add it
        PersonFragment personFragment = new PersonFragment();


        // add to fragments for adapter
        fragments.add(healthFragment);
        fragments.add(dailyFragment);
        fragments.add(shopFragment);
        fragments.add(personFragment);
    }


    /**
     * change BottomNavigationViewEx style
     */
    private void initView() {
        bnve=findViewById(R.id.bnve);
        floatingActionButton = findViewById(R.id.fab);
        //viewPager = findViewById(R.id.vp);
        bnve.enableItemShiftingMode(false);
        bnve.enableShiftingMode(false);
        bnve.enableAnimation(false);
    }


    private void initEvent() {

        final FragmentManager fm=getSupportFragmentManager();

        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //private int previousPosition = -1;


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction ft= fm.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.i_health:

                        ft.replace(R.id.container,fragments.get(0));
                        break;
                    case R.id.i_daily:
                        ft.replace(R.id.container,fragments.get(1));
                        break;
                    case R.id.i_evaluate:
                        ft.replace(R.id.container,fragments.get(2));
                        break;
                    case R.id.i_person:
                        ft.replace(R.id.container,fragments.get(3));
                        break;
                    case R.id.i_empty: {
                        return false;
                    }
                }
                ft.addToBackStack(null);
                ft.commit();
                /*if(previousPosition != position) {
                    viewPager.setCurrentItem(position, false);
                    previousPosition = position;
                }*/

                return true;
            }
        });


        // 漂浮按钮
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AskHelpAcivity.class);
                startActivity(intent);

            }
        });
    }
    public void gaintPermissions(){
       /* if (ContextCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED) {//已有权限
            Intent intent=new Intent(MainActivity.this,StepCountService.class);
            startService(intent);
        } else {//申请权限
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{ Manifest.permission.BODY_SENSORS}, 1);
        }*/
        String[] permissions = new String[]{Manifest.permission.BODY_SENSORS,
                Manifest.permission.SEND_SMS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
        };
        List<String>  mPermissionList = new ArrayList<>();
        /*mPermissionList.clear();//清空已经允许的没有通过的权限*/
        //逐个判断是否还有未通过的权限
        for (int i = 0;i<permissions.length;i++){
            if (ContextCompat.checkSelfPermission(this,permissions[i])!=
                    PackageManager.PERMISSION_GRANTED){
                mPermissionList.add(permissions[i]);//添加还未授予的权限到mPermissionList中
            }
        }
        //申请权限
        if (mPermissionList.size()>0){//有权限没有通过，需要申请
            ActivityCompat.requestPermissions(this,permissions,100);
        }

       /* PermissionUtil permissionUtil=new PermissionUtil(MainActivity.this);
        permissionUtil.gaintPermissions(Manifest.permission.BODY_SENSORS);
        permissionUtil.gaintPermissions(Manifest.permission.SEND_SMS);
        permissionUtil.gaintPermissions(Manifest.permission.ACCESS_FINE_LOCATION);
        permissionUtil.gaintPermissions(Manifest.permission.READ_PHONE_STATE);
        permissionUtil.gaintPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE);*/
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(Tag,"onResume");
        Intent start=new Intent (this, QuickHelpService.class);

        if(Build.VERSION.SDK_INT>=26){
            startForegroundService (start);
        }else{
            startService (start);
        }
        Intent start2=new Intent (this, StepCountService.class);

        if(Build.VERSION.SDK_INT>=26){
            startForegroundService (start2);
        }else{
            startService (start2);
        }
    }
}
