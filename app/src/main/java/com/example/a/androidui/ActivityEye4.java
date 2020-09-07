package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye4 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye4);   //眼屎多的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain24);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye4.this, ActivityEyeResult13.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain25);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye4.this, ActivityEyeResult14.class);
                startActivity(intent);
            }
        } );






    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

