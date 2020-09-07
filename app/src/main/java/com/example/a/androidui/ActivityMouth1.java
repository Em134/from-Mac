package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth1 extends AppCompatActivity {
    private Button mouth1;
    private Button mouth2;
    private Button mouth3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth1);   //口腔部分的二级目录，是主要症状....（二级目录）

        mouth1 = (Button) this.findViewById(R.id.mouthpain9);
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth1.this, ActivityMouthResult1.class);
                startActivity(intent);
            }
        } );

        mouth2 = (Button) this.findViewById(R.id.mouthpain10);
        mouth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth1.this, ActivityMouthResult2.class);
                startActivity(intent);
            }
        } );


        mouth3 = (Button) this.findViewById(R.id.mouthpain11);
        mouth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth1.this, ActivityMouthResult3.class);
                startActivity(intent);
            }
        } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

