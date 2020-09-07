package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote extends AppCompatActivity {
    private Button note2;
    private Button note3;
    private Button note4;
    private Button note5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note);   //初期鼻子干涩且伴有咽痒或者灼烧感....（一级目录）
        note2 = (Button) this.findViewById(R.id.notehot1);
        note2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote.this, ActivityNote2.class);
                startActivity(intent);
            }
        } );

        note3 = (Button) this.findViewById(R.id.notehot2);
        note3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote.this, ActivityNote9.class);
                startActivity(intent);
            }
        } );


        note4 = (Button) this.findViewById(R.id.notehot3);//一级目录c选项
        note4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote.this, ActivityNote11.class);
                startActivity(intent);
            }
        } );

        note5 = (Button) this.findViewById(R.id.notehot4);         //一级目录D选项
        note5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote.this, ActivityNote12.class);
                startActivity(intent);
            }
        } );
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

