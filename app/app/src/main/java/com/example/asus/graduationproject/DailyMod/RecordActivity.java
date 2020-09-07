package com.example.asus.graduationproject.DailyMod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.JavaBean.SportData;
import com.example.asus.graduationproject.R;
import com.example.asus.graduationproject.SQLite.DBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity {
    //运动记录模块
    private BottomNavigationViewEx bnve;
    RecyclerView recyclerView;
    private static final String Tag="RecordActivity";
    SQLiteDatabase sqLiteDatabase;
    List<SportData> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        initView();
    }
    @Override
    protected void onResume() {
        DBHelper dbHelper=new DBHelper(this,"Graducation.db",null,1);
        sqLiteDatabase =dbHelper.getReadableDatabase();
        initData();
        recyclerView.setAdapter(new RecordAdapter(this,data));
        super.onResume();
    }
    protected void onPause() {
        sqLiteDatabase.close();
        data.clear();
        super.onPause();
    }
    private void initView() {
        bnve=findViewById(R.id.bnve);
        bnve.enableItemShiftingMode(false);
        bnve.enableShiftingMode(false);
        bnve.enableAnimation(false);
        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //private int previousPosition = -1;


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.i_add:
                        Intent intent=new Intent(RecordActivity.this,AddRecordActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.i_Statistics:
                        break;
                }
                /*if(previousPosition != position) {
                    viewPager.setCurrentItem(position, false);
                    previousPosition = position;
                }*/

                return true;
            }
        });
        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    public void initData(){

        Cursor cursor=sqLiteDatabase.rawQuery("select * from sport_data where userName=? order by sportDate desc,startTime desc",new String[]{GlobalUitl.accoutName});
        while(cursor.moveToNext()){
            SportData sportData=new SportData();
            sportData.setType(cursor.getString(cursor.getColumnIndex("type")));
            sportData.setSportTime(cursor.getString(cursor.getColumnIndex("sportTime")));
            sportData.setSportDate(cursor.getString(cursor.getColumnIndex("sportDate")));
            sportData.setStartTime(cursor.getString(cursor.getColumnIndex("startTime")));
            data.add(sportData);
        }
        Log.d(Tag,data.size()+"");
        cursor.close();
    }
}
