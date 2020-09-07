package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityStomach1 extends AppCompatActivity {
    private Button stomach1;
    private Button stomach2;
    private Button stomach3;
    private Button stomach4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_stomach1);   //肠胃部分的二级目录，是主要症状....

        stomach1 = (Button) this.findViewById(R.id.stomachpain3);  //打嗝
        stomach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach1.this, ActivityStomachResult1.class);
                startActivity(intent);
            }
        } );

        stomach2 = (Button) this.findViewById(R.id.stomachpain4);      //神经性厌食
        stomach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach1.this, ActivityStomachResult2.class);
                startActivity(intent);
            }
        } );

        stomach3 = (Button) this.findViewById(R.id.stomachpain5);      //神经性厌食
        stomach3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach1.this, ActivityStomachResult3.class);
                startActivity(intent);
            }
        } );

        stomach4 = (Button) this.findViewById(R.id.stomachpain6);      //神经性厌食
        stomach4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach1.this, ActivityStomachResult4.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

