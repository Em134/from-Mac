package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote4 extends AppCompatActivity {
    private Button cold4;
    private Button cold5;
    private Button cold6;
    private Button cold7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note3);
        cold4 = (Button) this.findViewById(R.id.notepain1);
        cold4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote4.this, ActivityResult4.class);
                startActivity(intent);
            }
        });

        cold5 = (Button) this.findViewById(R.id.notepain2);
        cold5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote4.this, ActivityResult5.class);
                startActivity(intent);
            }
        });

        cold6 = (Button) this.findViewById(R.id.notepain3);
        cold6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote4.this, ActivityResult6.class);
                startActivity(intent);
            }
        });
        cold7 = (Button) this.findViewById(R.id.notepain4);
        cold7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote4.this, ActivityResult7.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

