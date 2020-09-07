package com.example.a.androidui;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.a.androidui.overlayutil.DbHelper;

public class MainActivity extends AppCompatActivity {


    private TextView tabDeal;
    private TextView tabpoi;
    private TextView tabUser;
    public TextView login1;
    public  TextView curehistory;
    public  TextView readhistory;
    public  TextView touchyangye;
    public  TextView genduowenzhang;
    public  TextView genduoshipin;
    public FrameLayout ly_container;
    private Fragment currentFragment = new Fragment();
    private FragmentManager manager;
    private FirstFragment f1;
    private NavigationFragment f2;
    private HumancenterFragment f3;
    private ImageButton imageView;
    private ImageButton imageView2;
    private GridView gv;
    public Button button12;
    public Button b3;
    public Button b4;
    public Button joker;
    public Button map1;
    public Button doctor_online;
    public Button ChatBot;
    //wct加的
    private TextView tabGuide;
    private JiuhuFragment f4;
    public Button b5;
    public Button b6;

    public ImageButton goweb1;
    public ImageButton goweb2;
    public ImageButton goweb3;
    public ImageButton goweb4;
    public ImageButton goweb5;
    public ImageButton goweb6;
    public DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_main_layout);


        dbHelper=new DbHelper(this,"History.db",null,2);



    }



    //UI组件初始化与事件绑定
    private void bindView() {

        tabDeal = (TextView) this.findViewById(R.id.txt_deal);
        tabpoi = (TextView) this.findViewById(R.id.txt_poi);
        tabUser = (TextView) this.findViewById(R.id.txt_user);
        curehistory=findViewById(R.id.zhenduanjilu);
        readhistory=findViewById(R.id.lishijilu);
        touchyangye=findViewById(R.id.yonghufangkui);
        genduowenzhang=findViewById(R.id.morewenzhang);
        genduoshipin=findViewById(R.id.moreAVI);
        //wct改
        tabGuide = (TextView) this.findViewById(R.id.txt_guide);

        ly_container = (FrameLayout) findViewById(R.id.fragment_container);
        login1 = this.findViewById(R.id.login_first);
        goweb1 = (ImageButton) this.findViewById(R.id.ig1);
        goweb2 = (ImageButton) this.findViewById(R.id.ig2);
        goweb3 = (ImageButton) this.findViewById(R.id.ig3);
        goweb4 = (ImageButton) this.findViewById(R.id.ig4);
        goweb5 = (ImageButton) this.findViewById(R.id.ig5);
        goweb6 = (ImageButton) this.findViewById(R.id.ig6);

        doctor_online = this.findViewById(R.id.online_doctor);//紧急求助的按钮
        map1 = this.findViewById(R.id.assistant);//就诊助手的按钮
        b3 = (Button) this.findViewById(R.id.button3);//问诊按钮
        b4 = (Button) this.findViewById(R.id.button4);//舌诊按钮
        joker = (Button) this.findViewById(R.id.joke);//开心一刻按钮
        joker.setOnClickListener((View.OnClickListener) this);
        login1.setOnClickListener((View.OnClickListener) this);
        goweb1.setOnClickListener((View.OnClickListener) this);
        goweb2.setOnClickListener((View.OnClickListener) this);
        goweb3.setOnClickListener((View.OnClickListener) this);
        goweb4.setOnClickListener((View.OnClickListener) this);
        goweb5.setOnClickListener((View.OnClickListener) this);
        goweb6.setOnClickListener((View.OnClickListener) this);
        curehistory.setOnClickListener((View.OnClickListener) this);//诊断记录
        readhistory.setOnClickListener((View.OnClickListener) this);//历史记录
        touchyangye.setOnClickListener((View.OnClickListener) this);//用户反馈
        genduowenzhang.setOnClickListener((View.OnClickListener) this);
        genduoshipin.setOnClickListener((View.OnClickListener) this);
        //wct改
        b5 = (Button) this.findViewById(R.id.sprain);//扭伤按钮
        b6 = (Button) this.findViewById(R.id.firstaid);//急救按钮

        doctor_online.setOnClickListener((View.OnClickListener) this);
        map1.setOnClickListener((View.OnClickListener) this);
        tabDeal.setOnClickListener((View.OnClickListener) this);
        tabUser.setOnClickListener((View.OnClickListener) this);
        tabpoi.setOnClickListener((View.OnClickListener) this);
        imageView.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        button12.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
        imageView2.setOnClickListener((View.OnClickListener) this);

        ChatBot.setOnClickListener((View.OnClickListener) this);
//wct改
        b5.setOnClickListener((View.OnClickListener) this);
        b6.setOnClickListener((View.OnClickListener) this);

    }

    //重置所有文本的选中状态
    public void selected() {
        tabpoi.setSelected(false);
        tabUser.setSelected(false);
        tabDeal.setSelected(false);
    }

    //隐藏所有的fragment文件
    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
 //wct改
        if (f4 != null) {
            transaction.hide(f4);
        }

    }



    //   show和hide
    private void showFragment(Fragment fragment) {

        if (currentFragment != fragment) {//  判断传入的fragment是不是当前的currentFragmentgit

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.hide(currentFragment);//  不是则隐藏

            currentFragment = fragment;  //  然后将传入的fragment赋值给currentFragment

            if (!fragment.isAdded()) { //  判断传入的fragment是否已经被add()过

                transaction.add(R.id.fragment_container, fragment).show(fragment).commit();

            } else {

                transaction.show(fragment).commit();

            }

        }

    }


    public void oneOnClick(View v) {


        Intent intent = null;
        switch (v.getId()) {
            case R.id.txt_deal:
                FirstFragment f1 = new FirstFragment();
                //transaction.add(R.id.fragment_container, f1);
                showFragment(f1);
                break;

            case R.id.txt_poi:
                NavigationFragment f2 = new NavigationFragment();
                //transaction.add(R.id.fragment_container, f2);
                showFragment(f2);
                break;

            case R.id.txt_user:
                HumancenterFragment f3 = new HumancenterFragment();
                // transaction.add(R.id.fragment_container, f3);
                showFragment(f3);
                break;
        //wct改
            case R.id.txt_guide:
                JiuhuFragment f4 = new JiuhuFragment();
                // transaction.add(R.id.fragment_container, f4);
                showFragment(f4);
                break;

            case R.id.button3:
                intent = new Intent(MainActivity.this, ActivityTry3.class);
                startActivity(intent);
                break;

            case R.id.button4:
                intent = new Intent(MainActivity.this, ActivityTakePhoto.class);
                startActivity(intent);
                break;

            case R.id.joke:
                intent = new Intent(MainActivity.this, ActivityHappy.class);
                startActivity(intent);
                break;

            case R.id.assistant:
                intent = new Intent(MainActivity.this, BaiduMap.class);
                startActivity(intent);
                break;

            case R.id.online_doctor:
                intent = new Intent(MainActivity.this, CallPhoneActivity.class);//新建一个界面来拨打电话
                startActivity(intent);
                break;

            case R.id.login_first:
                intent = new Intent(MainActivity.this, Login_try.class);//转跳没有问题
                startActivity(intent);
                break;

            case R.id.morewenzhang:
                intent = new Intent(MainActivity.this, FruitActivity.class);//转跳没有问题
                startActivity(intent);
                break;
            case R.id.moreAVI:
                intent = new Intent(MainActivity.this, AVIActivity.class);//转跳没有问题
                startActivity(intent);
                break;
            case R.id.ig1:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);
                intent = new Intent(MainActivity.this, ActivityWebView1.class);//转跳没有问题
                startActivity(intent);

                break;

            case R.id.zhenduanjilu:
                intent = new Intent(MainActivity.this, HistoryActivity.class);//转跳没有问题,诊断记录跳转
                startActivity(intent);

                break;

            case R.id.lishijilu:
                intent = new Intent(MainActivity.this, HistoryActivityRead.class);//转跳没有问题
                startActivity(intent);

                break;

            case R.id.ig2:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);

                intent = new Intent(MainActivity.this, ActivityWebView2.class);//转跳没有问题
                startActivity(intent);
                break;

            case R.id.ig3:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);
                intent = new Intent(MainActivity.this, ActivityWebView3.class);//转跳没有问题
                startActivity(intent);

                break;

            case R.id.ig4:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);
            case R.id.ig5:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);

                intent = new Intent(MainActivity.this, ActivityWebView5.class);//转跳没有问题
                startActivity(intent);
                break;
            case R.id.ig6:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);

                intent = new Intent(MainActivity.this, ActivityWebView4.class);//转跳没有问题
                startActivity(intent);
                break;

            case R.id.txt_xinglingliaoyu:
//                intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
//                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
//                startActivity(intent);

                intent = new Intent(MainActivity.this, ChatBot.class);//转跳没有问题
                startActivity(intent);
                break;
            //wct改
            case R.id.sprain:
                intent = new Intent(MainActivity.this, ActivitySprain1.class);
                startActivity(intent);
                break;

            case R.id.firstaid:
                intent = new Intent(MainActivity.this, ActivityFirstaid.class);
                startActivity(intent);
                break;
        }


    }


}


