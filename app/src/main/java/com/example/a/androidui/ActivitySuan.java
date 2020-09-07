package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySuan extends AppCompatActivity {
    private Button suan1;
    private Button suan2;
    private Button suan3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_suan);
        suan1 = (Button) this.findViewById(R.id.suan1);   //接触
        suan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySuan.this, ActivitySuanResult1.class);
                startActivity(intent);
            }
        } );

        suan2 = (Button) this.findViewById(R.id.suan2);          //口服
        suan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySuan.this, ActivitySuanResult2.class);
                startActivity(intent);
            }
        } );

        suan3 = (Button) this.findViewById(R.id.suan3);          //呼吸道
        suan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivitySuan.this, ActivitySuanResult3.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

