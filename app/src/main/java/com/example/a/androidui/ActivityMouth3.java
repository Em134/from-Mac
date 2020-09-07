package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth3 extends AppCompatActivity {
    private Button mouth1;
    private Button mouth2;
    private Button mouth3;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth3);   //口腔部分的二级目录，是主要症状....（二级目录）

        mouth1 = (Button) this.findViewById(R.id.mouthpain16);
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth3.this, ActivityMouthResult8.class);
                startActivity(intent);
            }
        } );

        mouth2 = (Button) this.findViewById(R.id.mouthpain17);
        mouth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth3.this, ActivityMouthResult9.class);
                startActivity(intent);
            }
        } );


        mouth3 = (Button) this.findViewById(R.id.mouthpain18);
        mouth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth3.this, ActivityMouthResult10.class);
                startActivity(intent);
            }
        } );




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

