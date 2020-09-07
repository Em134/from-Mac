package com.example.a.androidui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a.androidui.overlayutil.DbHelper;

public class ActivitySuanResult3 extends AppCompatActivity {
    private Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_suan_result3); //呼吸道
        back1 = (Button) this.findViewById(R.id.coldback1);

        final DbHelper dbHelper=new DbHelper(this,"History.db",null,2);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("cure","呼吸道吸入腐蚀性酸");
                db.insert("CureHistory",null,values);
                values.clear();

                Intent intent = null;
                intent = new Intent(ActivitySuanResult3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}

