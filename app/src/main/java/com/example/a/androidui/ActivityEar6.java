package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEar6 extends AppCompatActivity {
    private Button ear1;
    private Button ear2;
    private Button ear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_ear6);   //耳廓痛部分的二级目录，是主要症状....（二级目录）

        ear1 = (Button) this.findViewById(R.id.earpain23);
        ear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar6.this, ActivityEarResult15.class);
                startActivity(intent);
            }
        } );

        ear2 = (Button) this.findViewById(R.id.earpain24);
        ear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar6.this, ActivityEarResult16.class);
                startActivity(intent);
            }
        } );

        ear3 = (Button) this.findViewById(R.id.earpain25);
        ear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEar6.this, ActivityEarResult17.class);
                startActivity(intent);
            }
        } );
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

