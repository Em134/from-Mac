package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySiriasis extends AppCompatActivity {
    private Button siriasis1;
    private Button siriasis2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_siriasis);
        siriasis1 = (Button) this.findViewById(R.id.siriasis1);   //中暑
        siriasis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySiriasis.this, ActivitySiriasisResult1.class);
                startActivity(intent);
            }
        } );

        siriasis2 = (Button) this.findViewById(R.id.siriasis2);          //热衰竭
        siriasis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySiriasis.this, ActivitySiriasisResult2.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

