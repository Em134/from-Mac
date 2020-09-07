package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth extends AppCompatActivity {
    private Button mouth1;
    private Button mouth2;
    private Button mouth3;
    private Button mouth4;
    private Button mouth5;
    private Button mouth6;
    private Button mouth7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth);   //口腔部分的一级目录，是主要症状....（一级目录）

        mouth1 = (Button) this.findViewById(R.id.mouthpain1);  //牙龈出血
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth1.class);
                startActivity(intent);
            }
        } );

        mouth2 = (Button) this.findViewById(R.id.mouthpain2);      //口干舌燥
        mouth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth2.class);
                startActivity(intent);
            }
        } );


        mouth3 = (Button) this.findViewById(R.id.mouthpain3);//牙疼
        mouth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth3.class);
                startActivity(intent);
            }
        } );

        mouth4 = (Button) this.findViewById(R.id.mouthpain4);         //D 口苦
        mouth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth4.class);
                startActivity(intent);
            }
        } );
        mouth5 = (Button) this.findViewById(R.id.mouthpain5);         //E 牙龈肿胀
        mouth5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth5.class);
                startActivity(intent);
            }
        } );

        mouth6 = (Button) this.findViewById(R.id.mouthpain6);         //F 牙齿遇冷热痛
        mouth6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth6.class);
                startActivity(intent);
            }
        } );

        mouth7 = (Button) this.findViewById(R.id.mouthpain7);         //G 口臭
        mouth7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth.this, ActivityMouth7.class);
                startActivity(intent);
            }
        } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

