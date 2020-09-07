package com.example.a.androidui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a.androidui.overlayutil.DbHelper;

public class ActivityEmpyrosisResult2 extends AppCompatActivity {
    private Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_empyrosis_result2); //轻度
        back1 = (Button) this.findViewById(R.id.coldback1);

        final DbHelper dbHelper=new DbHelper(this,"History.db",null,2);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("cure","轻度烧伤");
                db.insert("CureHistory",null,values);
                values.clear();

                Intent intent = null;
                intent = new Intent(ActivityEmpyrosisResult2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}

