package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEar1 extends AppCompatActivity {
    private Button ear1;
    private Button ear2;
    private Button ear3;
    private Button ear4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear1);   //耳鸣部分的二级目录，是主要症状....（一级目录）

        ear1 = (Button) this.findViewById(R.id.earpain7);
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar1.this, ActivityEarResult1.class);
                startActivity(intent);
            }
        } );

        ear2 = (Button) this.findViewById(R.id.earpain8);
        ear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar1.this, ActivityEarResult2.class);
                startActivity(intent);
            }
        } );


        ear3 = (Button) this.findViewById(R.id.earpain9);
        ear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar1.this, ActivityEarResult3.class);
                startActivity(intent);
            }
        } );

        ear4 = (Button) this.findViewById(R.id.earpain10);
        ear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar1.this, ActivityEarResult4.class);
                startActivity(intent);
            }
        } );




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

