package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye3_2 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye3_2);   //眼睑发红症状二级目录的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain22);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3_2.this, ActivityEyeResult9.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain23);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3_2.this, ActivityEyeResult9_0.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

