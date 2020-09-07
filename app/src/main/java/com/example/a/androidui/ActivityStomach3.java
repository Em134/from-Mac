package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityStomach3 extends AppCompatActivity {
    private Button stomach1;
    private Button stomach2;
    private Button stomach3;
    private Button stomach4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_stomach3);   //肠胃部分的二级目录，是主要症状....

        stomach1 = (Button) this.findViewById(R.id.stomachpain10);  //打嗝
        stomach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach3.this, ActivityStomachResult6.class);
                startActivity(intent);
            }
        } );

        stomach2 = (Button) this.findViewById(R.id.stomachpain11);
        stomach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach3.this, ActivityStomachResult7.class);
                startActivity(intent);
            }
        } );

        stomach3 = (Button) this.findViewById(R.id.stomachpain12);
        stomach3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach3.this, ActivityStomachResult8.class);
                startActivity(intent);
            }
        } );


        stomach4 = (Button) this.findViewById(R.id.stomachpain13);
        stomach4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach3.this, ActivityStomachResult9.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

