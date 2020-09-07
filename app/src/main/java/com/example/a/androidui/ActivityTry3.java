package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTry3 extends AppCompatActivity {
    private Button note1;
    private Button eye1;
    private Button mouth1;
    private Button heart1;
    private Button stomach1;
    private Button ear1;
    //问诊总体分类，现阶段有鼻，眼，耳等六个部位
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_try3);
        note1 = (Button) this.findViewById(R.id.note);   //鼻子
        note1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityNote.class);
                startActivity(intent);
            }
        } );

        eye1 = (Button) this.findViewById(R.id.eye);          //眼睛
        eye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityEye.class);
                startActivity(intent);
            }
        } );

        mouth1 = (Button) this.findViewById(R.id.mouth);          //口腔
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityMouth.class);
                startActivity(intent);
            }
        } );

        heart1 = (Button) this.findViewById(R.id.heart);          //心脏
        heart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityHeart.class);
                startActivity(intent);
            }
        } );

        stomach1 = (Button) this.findViewById(R.id.stomach);          //肠胃
        stomach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityStomach.class);
                startActivity(intent);
            }
        } );

        ear1 = (Button) this.findViewById(R.id.ear);          //耳朵
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityTry3.this, ActivityEar.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




    }

