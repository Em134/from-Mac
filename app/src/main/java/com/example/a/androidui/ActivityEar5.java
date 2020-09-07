package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEar5 extends AppCompatActivity {
    private Button ear1;
    private Button ear2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear5);   //耳廓痛部分的二级目录，是主要症状....（二级目录）

        ear1 = (Button) this.findViewById(R.id.earpain21);
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar5.this, ActivityEarResult13.class);
                startActivity(intent);
            }
        } );

        ear2 = (Button) this.findViewById(R.id.earpain22);
        ear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar5.this, ActivityEarResult14.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

