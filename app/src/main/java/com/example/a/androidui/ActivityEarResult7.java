package com.example.a.androidui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a.androidui.overlayutil.DbHelper;

public class ActivityEarResult7 extends AppCompatActivity {
    private Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear_result7); //风热邪毒聤耳
        back1 = (Button) this.findViewById(R.id.coldback1);
        final DbHelper dbHelper=new DbHelper(this,"History.db",null,2);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("cure","风热邪毒聤耳");
                db.insert("CureHistory",null,values);
                values.clear();

                Intent intent = null;
                intent = new Intent(ActivityEarResult7.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

