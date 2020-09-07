package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEar extends AppCompatActivity {
    private Button ear1;
    private Button ear2;
    private Button ear3;
    private Button ear4;
    private Button ear5;
    private Button ear6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear);   //耳朵部分的一级目录，是主要症状....（一级目录）

        ear1 = (Button) this.findViewById(R.id.earpain1);  //耳鸣响应
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar1.class);
                startActivity(intent);
            }
        } );

        ear2 = (Button) this.findViewById(R.id.earpain2);      //耳痛响应
        ear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar2.class);
                startActivity(intent);
            }
        } );


        ear3 = (Button) this.findViewById(R.id.earpain3);//一级目录c选项//耳内闭塞感
        ear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar3.class);
                startActivity(intent);
            }
        } );

        ear4 = (Button) this.findViewById(R.id.earpain4);         //一级目录D选项  //耳廓痛
        ear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar4.class);
                startActivity(intent);
            }
        } );
        ear5 = (Button) this.findViewById(R.id.earpain5);         //一级目录E选项     //耳屎多
        ear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar5.class);
                startActivity(intent);
            }
        } );

        ear6 = (Button) this.findViewById(R.id.earpain6);         //一级目录F选项   //耳溢液
        ear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar.this, ActivityEar6.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

