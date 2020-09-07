package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityStomach2 extends AppCompatActivity {
    private Button stomach1;
    private Button stomach2;
    private Button stomach3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_stomach2);   //肠胃部分的二级目录，是主要症状....

        stomach1 = (Button) this.findViewById(R.id.stomachpain7);  //打嗝
        stomach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach2.this, ActivityStomachResult5.class);
                startActivity(intent);
            }
        } );

        stomach2 = (Button) this.findViewById(R.id.stomachpain8);
        stomach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach2.this, ActivityStomach3.class);
                startActivity(intent);
            }
        } );

        stomach3 = (Button) this.findViewById(R.id.stomachpain9);
        stomach3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityStomach2.this, ActivityStomachResult10.class);
                startActivity(intent);
            }
        } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

