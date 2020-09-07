package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySprain1 extends AppCompatActivity {
    private Button sprain1;
    private Button sprain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_sprain1);
        sprain1 = (Button) this.findViewById(R.id.sprain1);   //腰部
        sprain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySprain1.this, ActivitySprainresult1.class);
                startActivity(intent);
            }
        } );

        sprain2 = (Button) this.findViewById(R.id.sprain2);          //腕部
        sprain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySprain1.this, ActivitySprainresult2.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

