package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye3_1 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye3_1);   //眼睑发红子目录的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain20);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3_1.this, ActivityEye3_2.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain21);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3_1.this, ActivityEyeResult9_0.class);
                startActivity(intent);
            }
        } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

