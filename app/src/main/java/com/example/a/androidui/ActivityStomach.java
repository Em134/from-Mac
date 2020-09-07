package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityStomach extends AppCompatActivity {
    private Button stomach1;
    private Button stomach2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_stomach);   //肠胃部分的一级目录，是主要症状....（一级目录）

        stomach1 = (Button) this.findViewById(R.id.stomachpain1);  //打嗝
        stomach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach.this, ActivityStomach1.class);
                startActivity(intent);
            }
        } );

        stomach2 = (Button) this.findViewById(R.id.stomachpain2);      //神经性厌食
        stomach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach.this, ActivityStomach2.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

