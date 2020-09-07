package com.example.a.androidui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a.androidui.overlayutil.DbHelper;
import com.example.a.androidui.overlayutil.History;

import java.util.ArrayList;
import java.util.List;


//诊断历史界面
public class HistoryActivity extends AppCompatActivity {
    private ListView Lv;
    List<History> historyList;
    private Button love;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardhistory);
//        love=findViewById(R.id.addlove);
//        final DbHelper dbHelper=new DbHelper(this,".db",null,2);
//        love.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db1=dbHelper.getWritableDatabase();
//                ContentValues values=new ContentValues();
//                values.put("cure","搏动性耳鸣");
//                db1.insert("CureHistory",null,values);
//                values.clear();
//            }
//        });

        historyList=new ArrayList<History>();
        DbHelper oh=new DbHelper(this,"History.db",null,2);
        SQLiteDatabase db=oh.getWritableDatabase();

        Cursor cursor=db.query("CureHistory",null, null, null, null, null,null);
        while(cursor.moveToNext())
        {
            //循环取出每个person的值
            String _id=cursor.getString(cursor.getColumnIndex("id"));
            String history=cursor.getString(cursor.getColumnIndex("cure"));

            History p=new History(_id,history);
            historyList.add(p);//将值加入到集合中
        }
        Lv=(ListView) findViewById(R.id.list_history);
        //将数据显示到屏幕
        Lv.setAdapter(new MyAdapter());}

        class MyAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return historyList.size();
            }

            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {
                History p=historyList.get(arg0);

                //ListView优化
                View view=null;
                if(arg1==null)//这里是ListView的优化，有了这就话话后，我们就可以把用过了的存入缓存，避免浪费资源
                {
                    view=View.inflate(HistoryActivity.this, R.layout.creat_history, null);
                }
                else
                {
                    view=arg1;
                }

                TextView tv_name=(TextView) view.findViewById(R.id.tv_name);
                tv_name.setText(p.get_id());

                TextView tv_history=(TextView) view.findViewById(R.id.tv_history);
                tv_history.setText(p.getHistory());

                return view;
            }

        }





    }


