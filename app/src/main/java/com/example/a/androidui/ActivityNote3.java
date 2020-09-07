package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNote3 extends AppCompatActivity {
    private Button cold1;
    private Button cold2;
    private Button cold3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_note2);
        cold1 = (Button) this.findViewById(R.id.notecold1);
        cold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote3.this, ActivityResult1.class);
                startActivity(intent);
            }
        });

        cold2 = (Button) this.findViewById(R.id.notecold2);
        cold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote3.this, ActivityResult2.class);
                startActivity(intent);
            }
        });

        cold3 = (Button) this.findViewById(R.id.notecold3);
        cold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityNote3.this, ActivityResult3.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

