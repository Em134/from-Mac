package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye3 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;
    private Button eye10;
    private Button eye11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye3);   //眼睑发红的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain16);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3.this, ActivityEye3_1.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain17);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3.this, ActivityEyeResult10.class);
                startActivity(intent);
            }
        } );


        eye10 = (Button) this.findViewById(R.id.eyepain18);
        eye10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3.this, ActivityEyeResult11.class);
                startActivity(intent);
            }
        } );

        eye11 = (Button) this.findViewById(R.id.eyepain19);
        eye11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye3.this, ActivityEyeResult12.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

