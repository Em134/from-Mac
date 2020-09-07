package com.example.asus.graduationproject.DailyMod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.JavaBean.SportData;
import com.example.asus.graduationproject.R;
import com.example.asus.graduationproject.SQLite.DBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddRecordActivity extends AppCompatActivity {
    //添加记录
    ImageView imageView;
    LinearLayout type;//种类
    LinearLayout sportTime;//持续时间
    LinearLayout sportDate;//运动日期
    LinearLayout startTime;//运动时间
    List<String> typeList=new ArrayList<>();


    TextView typeText;
    TextView sportTimeText;
    TextView sportDateText;
    TextView startTimeText;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        initData();
        initViewPicker();
    }
    public void initViewPicker(){
        typeText=findViewById(R.id.typeText);
        sportTimeText=findViewById(R.id.sportTimeText);
        sportDateText=findViewById(R.id.sportDateText);
        startTimeText=findViewById(R.id.startTimeText);
        imageView=findViewById(R.id.image);
        type=findViewById(R.id.type);
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionsPickerView pickerView=new OptionsPickerBuilder(AddRecordActivity.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        typeText.setText(typeList.get(options1));
                        switch (typeList.get(options1)){
                            case "户外跑步":
                                imageView.setImageResource(R.drawable.run);
                                break;
                            case "户外骑行":
                                imageView.setImageResource(R.drawable.ride);
                                break;
                            case "泳池游泳":
                                imageView.setImageResource(R.drawable.swim);
                                break;
                            case "打篮球":
                                imageView.setImageResource(R.drawable.basketball);
                                break;
                            default:break;
                        }
                    }
                }).build();
                pickerView.setPicker(typeList);
                pickerView.show();
            }
        });


        sportTime=findViewById(R.id.sportTime);
        sportTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(0,0,0,0,0,0);
                TimePickerView pvTime = new TimePickerBuilder(AddRecordActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {

                        String dateString = formatter.format(date);
                        sportTimeText.setText(dateString);
                        Toast.makeText(AddRecordActivity.this,dateString, Toast.LENGTH_SHORT).show();
                    }
                }).setType(new boolean[]{false, false,false, true, true, true}).setDate(selectedDate).isCyclic(true).build();
                pvTime.show();
            }
        });


        sportDate=findViewById(R.id.sportDate);
        sportDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerView pvTime = new TimePickerBuilder(AddRecordActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(date);
                        sportDateText.setText(dateString);
                    }
                }).isCyclic(true).build();
                pvTime.show();
            }
        });

        startTime=findViewById(R.id.startTime);
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerView pvTime = new TimePickerBuilder(AddRecordActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                        String dateString = formatter.format(date);
                        startTimeText.setText(dateString);
                    }
                }).setType(new boolean[]{false, false,false, true, true, false}).build();
                pvTime.show();
            }
        });
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportData sportData=new SportData();
                sportData.setUserName(GlobalUitl.accoutName);
                sportData.setType(typeText.getText().toString());
                sportData.setSportTime(sportTimeText.getText().toString());
                sportData.setSportDate(sportDateText.getText().toString());
                sportData.setStartTime(startTimeText.getText().toString());
                SQLiteDatabase sqLiteDatabase=new DBHelper(AddRecordActivity.this,"Graducation.db",null,1).getReadableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("userName",GlobalUitl.accoutName);
                contentValues.put("type",typeText.getText().toString());
                contentValues.put("sportDate",sportDateText.getText().toString());
                contentValues.put("sportTime",sportTimeText.getText().toString());
                contentValues.put("startTime",startTimeText.getText().toString());
                sqLiteDatabase.insert("sport_data",null,contentValues);
                sqLiteDatabase.close();
                finish();
            }
        });

    }
    private void initData(){
        typeList.add("户外跑步");
        typeList.add("户外骑行");
        typeList.add("泳池游泳");
        typeList.add("打篮球");
    }
}
