package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote11 extends AppCompatActivity {
    private Button notecold1;
    private Button notecold2;
    private Button notecold3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note8);  //声嘶，咽疼，头疼头晕，乏力，消化不良。。。
         notecold1=(Button)this.findViewById(R.id.notepain17) ;
        notecold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote11.this, ActivityResult17.class); //鼻咽炎
                startActivity(intent);
            }
        });

        notecold2=(Button)this.findViewById(R.id.notepain18) ;
        notecold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote11.this, ActivityResult18.class);  //慢性咽炎
                startActivity(intent);
            }
        });

        notecold3=(Button)this.findViewById(R.id.notepain19) ;
        notecold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote11.this, ActivityResult13.class);//急性上颌窦炎
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

