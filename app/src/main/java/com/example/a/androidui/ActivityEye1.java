package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye1 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;
    private Button eye10;
    private Button eye11;
    private Button eye12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye1);   //眼睑浮肿的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain8);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye1.this, ActivityEyeResult1.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain9);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye1.this, ActivityEyeResult2.class);
                startActivity(intent);
            }
        } );


        eye10 = (Button) this.findViewById(R.id.eyepain10);
        eye10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye1.this, ActivityEyeResult3.class);
                startActivity(intent);
            }
        } );

        eye11 = (Button) this.findViewById(R.id.eyepain11);
        eye11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye1.this, ActivityEyeResult4.class);
                startActivity(intent);
            }
        } );
        eye12 = (Button) this.findViewById(R.id.eyepain12);
        eye12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye1.this, ActivityEyeResult5.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

