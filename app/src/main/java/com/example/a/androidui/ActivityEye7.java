package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye7 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye7);   //眼角长斑的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain38);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye7.this, ActivityEye7_1.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain39);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye7.this, ActivityEyeResult23.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

