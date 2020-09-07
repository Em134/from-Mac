package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote12 extends AppCompatActivity {
    private Button notecold4;
    private Button notecold5;
    private Button notecold6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note9);  //呼吸伴有刺痛感。。。
         notecold4=(Button)this.findViewById(R.id.notepain20) ;
        notecold4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote12.this, ActivityResult19.class); //扁桃体炎
                startActivity(intent);
            }
        });

        notecold5=(Button)this.findViewById(R.id.notepain21) ;
        notecold5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote12.this, ActivityResult20.class);  //上火
                startActivity(intent);
            }
        });

        notecold6=(Button)this.findViewById(R.id.notepain22) ;
        notecold6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote12.this, ActivityResult21.class);//败血症
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

