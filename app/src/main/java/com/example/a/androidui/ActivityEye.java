package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye extends AppCompatActivity {
    private Button eye1;
    private Button eye2;
    private Button eye3;
    private Button eye4;
    private Button eye5;
    private Button eye6;
    private Button eye7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye);   //眼睛部分的一级目录，是主要症状....（一级目录）

        eye1 = (Button) this.findViewById(R.id.eyepain1);
        eye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye1.class);
                startActivity(intent);
            }
        } );

        eye2 = (Button) this.findViewById(R.id.eyepain2);
        eye2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye2.class);
                startActivity(intent);
            }
        } );


        eye3 = (Button) this.findViewById(R.id.eyepain3);//一级目录c选项
        eye3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye3.class);
                startActivity(intent);
            }
        } );

        eye4 = (Button) this.findViewById(R.id.eyepain4);         //一级目录D选项  //眼屎多对应转跳
        eye4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye4.class);
                startActivity(intent);
            }
        } );
        eye5 = (Button) this.findViewById(R.id.eyepain5);         //一级目录E选项     //眼睛痒
        eye5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye5.class);
                startActivity(intent);
            }
        } );

        eye6 = (Button) this.findViewById(R.id.eyepain6);         //一级目录F选项   //眼白发黄
        eye6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye6.class);
                startActivity(intent);
            }
        } );

        eye7 = (Button) this.findViewById(R.id.eyepain7);         //一级目录G选项
        eye7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye.this, ActivityEye7.class);
                startActivity(intent);
            }
        } );

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

