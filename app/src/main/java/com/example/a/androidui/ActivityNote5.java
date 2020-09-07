package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote5 extends AppCompatActivity {
    private Button notepain1;
    private Button notepain2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note4);
         notepain1=(Button)this.findViewById(R.id.noteyes1) ;
        notepain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote5.this, ActivityNote6.class);
                startActivity(intent);
            }
        });

        notepain2=(Button)this.findViewById(R.id.noteno1) ;
        notepain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote5.this, ActivityResult7.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

