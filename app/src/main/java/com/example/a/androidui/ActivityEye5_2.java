package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye5_2 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye5_2);   //眼睛痒的二级目录2的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain32);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye5_2.this, ActivityEyeResult17.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain33);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye5_2.this, ActivityEyeResult17.class);
                startActivity(intent);
            }
        } );




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

