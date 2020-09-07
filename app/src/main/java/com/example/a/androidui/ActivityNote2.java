package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote2 extends AppCompatActivity {
    private Button notecold1;
    private Button notecold2;
    private Button notecold3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note1);
         notecold1=(Button)this.findViewById(R.id.notehot5) ;
        notecold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote2.this, ActivityNote3.class);
                startActivity(intent);
            }
        });

        notecold2=(Button)this.findViewById(R.id.notehot6) ;
        notecold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote2.this, ActivityNote4.class);
                startActivity(intent);
            }
        });

        notecold3=(Button)this.findViewById(R.id.notehot7) ;
        notecold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote2.this, ActivityNote5.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

