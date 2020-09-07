package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth7_1 extends AppCompatActivity {
    private Button mouth1;
    private Button mouth2;
    private Button mouth3;
    private Button mouth4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth7_1);   //口腔部分的二级目录，是主要症状....（二级目录）牙齿遇冷热痛

        mouth1 = (Button) this.findViewById(R.id.mouthpain32);
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth7_1.this, ActivityMouthResult19.class);
                startActivity(intent);
            }
        } );

        mouth2 = (Button) this.findViewById(R.id.mouthpain33);
        mouth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth7_1.this, ActivityMouthResult20.class);
                startActivity(intent);
            }
        } );


        mouth3 = (Button) this.findViewById(R.id.mouthpain34);
        mouth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth7_1.this, ActivityMouthResult21.class);
                startActivity(intent);
            }
        } );

        mouth4 = (Button) this.findViewById(R.id.mouthpain35);
        mouth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth7_1.this, ActivityMouthResult22.class);
                startActivity(intent);
            }
        } );




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

