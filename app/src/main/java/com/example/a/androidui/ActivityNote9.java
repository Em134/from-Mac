package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote9 extends AppCompatActivity {
    private Button notecold1;
    private Button notecold2;
    private Button notecold3;
    private Button notecold4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note6);   // 伴有局部疼痛和头痛....
         notecold1=(Button)this.findViewById(R.id.notepain10) ;
        notecold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote9.this, ActivityNote10.class);
                startActivity(intent);
            }
        });

        notecold2=(Button)this.findViewById(R.id.notepain11) ;
        notecold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote9.this, ActivityResult14.class);
                startActivity(intent);
            }
        });

        notecold3=(Button)this.findViewById(R.id.notepain12) ;
        notecold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote9.this, ActivityResult15.class);
                startActivity(intent);
            }
        });

        notecold4=(Button)this.findViewById(R.id.notepain13) ;
        notecold4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote9.this, ActivityResult16.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

