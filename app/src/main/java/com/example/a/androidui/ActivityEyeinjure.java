package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEyeinjure extends AppCompatActivity {
    private Button eyeinjure1;
    private Button eyeinjure2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_eyeinjure);
        eyeinjure1 = (Button) this.findViewById(R.id.eyeinjure1);   //溅入
        eyeinjure1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEyeinjure.this, ActivityEyeinjureResult1.class);
                startActivity(intent);
            }
        } );

        eyeinjure2 = (Button) this.findViewById(R.id.eyeinjure2);          //挫伤
        eyeinjure2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEyeinjure.this, ActivityEyeinjureResult2.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

