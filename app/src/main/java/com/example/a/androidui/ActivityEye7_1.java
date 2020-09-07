package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEye7_1 extends AppCompatActivity {
    private Button eye8;
    private Button eye9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_eye7_1);   //眼角长斑二级目录的症状分类

        eye8 = (Button) this.findViewById(R.id.eyepain40);
        eye8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye7_1.this, ActivityEyeResult22.class);
                startActivity(intent);
            }
        } );

        eye9 = (Button) this.findViewById(R.id.eyepain41);
        eye9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEye7_1.this, ActivityEyeResult23.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

