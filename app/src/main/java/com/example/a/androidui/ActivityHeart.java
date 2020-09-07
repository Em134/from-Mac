package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHeart extends AppCompatActivity {
    private Button heart1;
    private Button heart2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_heart);   //心脏部分的一级目录，是主要症状....（一级目录）

        heart1 = (Button) this.findViewById(R.id.heartpain1);  //打呼吸困难
        heart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityHeart.this, ActivityHeart1.class);
                startActivity(intent);
            }
        } );

        heart2 = (Button) this.findViewById(R.id.heartpain2);      //没有
        heart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityHeart.this, ActivityHeartResult4.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

