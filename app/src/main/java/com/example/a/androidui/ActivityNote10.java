package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote10 extends AppCompatActivity {
    private Button notecold1;
    private Button notecold2;
    private Button notecold3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note7);  //疼痛部位是前额，内眦以及面颊部。。。
         notecold1=(Button)this.findViewById(R.id.notepain14) ;
        notecold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote10.this, ActivityResult11.class); //前鼻窦炎
                startActivity(intent);
            }
        });

        notecold2=(Button)this.findViewById(R.id.notepain15) ;
        notecold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote10.this, ActivityResult12.class);  //后组鼻窦炎
                startActivity(intent);
            }
        });

        notecold3=(Button)this.findViewById(R.id.notepain16) ;
        notecold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote10.this, ActivityResult13.class);//急性上颌窦炎
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

