package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEar2 extends AppCompatActivity {
    private Button ear1;
    private Button ear2;
    private Button ear3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear2);   //耳痛部分的二级目录，是主要症状....（二级目录）

        ear1 = (Button) this.findViewById(R.id.earpain11);
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar2.this, ActivityEarResult5.class);
                startActivity(intent);
            }
        } );

        ear2 = (Button) this.findViewById(R.id.earpain12);
        ear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar2.this, ActivityEarResult6.class);
                startActivity(intent);
            }
        } );


        ear3 = (Button) this.findViewById(R.id.earpain13);
        ear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar2.this, ActivityEar2_1.class);
                startActivity(intent);
            }
        } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

