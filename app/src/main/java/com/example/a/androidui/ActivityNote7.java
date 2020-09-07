package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote7 extends AppCompatActivity {
    private Button notecold1;
    private Button notecold2;
    private Button notecold3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note4_2);
         notecold1=(Button)this.findViewById(R.id.noteyes) ;
        notecold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote7.this, ActivityNote8.class);
                startActivity(intent);
            }
        });

        notecold2=(Button)this.findViewById(R.id.noteno) ;
        notecold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote7.this, ActivityNote4.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

