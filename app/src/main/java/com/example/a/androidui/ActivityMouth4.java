package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth4 extends AppCompatActivity {
    private Button mouth1;
    private Button mouth2;
    private Button mouth3;
    private Button mouth4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth4);   //口腔部分的二级目录，是主要症状....（二级目录）口苦

        mouth1 = (Button) this.findViewById(R.id.mouthpain19);
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth4.this, ActivityMouthResult11.class);
                startActivity(intent);
            }
        } );

        mouth2 = (Button) this.findViewById(R.id.mouthpain20);
        mouth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth4.this, ActivityMouthResult13.class);
                startActivity(intent);
            }
        } );


        mouth3 = (Button) this.findViewById(R.id.mouthpain21);
        mouth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth4.this, ActivityMouthResult6.class);
                startActivity(intent);
            }
        } );


        mouth4 = (Button) this.findViewById(R.id.mouthpain22);
        mouth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth4.this, ActivityMouthResult12.class);
                startActivity(intent);
            }
        } );


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

