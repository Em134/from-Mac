package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFirstaid extends AppCompatActivity {
    private Button siriasis;
    private Button prostration;
    private Button eyeinjure;
    private Button suan;
    private Button jian;
    private Button empyrosis;
    private Button electric;
    private Button cpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_firstaid);

        siriasis = (Button) this.findViewById(R.id.siriasis);  //中暑响应
        siriasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivitySiriasis.class);
                startActivity(intent);
            }
        } );

        prostration = (Button) this.findViewById(R.id.prostration);      //虚脱响应
        prostration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityProstrationResult.class);
                startActivity(intent);
            }
        } );


        eyeinjure = (Button) this.findViewById(R.id.eyeinjure);//眼部损伤响应
        eyeinjure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityEyeinjure.class);
                startActivity(intent);
            }
        } );

        suan = (Button) this.findViewById(R.id.suan);         //酸灼伤响应
        suan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivitySuan.class);
                startActivity(intent);
            }
        } );
        jian = (Button) this.findViewById(R.id.jian);         //误食烧碱响应
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityJianResult.class);
                startActivity(intent);
            }
        } );

        empyrosis = (Button) this.findViewById(R.id.empyrosis);         //烧伤响应
        empyrosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityEmpyrosis.class);
                startActivity(intent);
            }
        } );

        electric = (Button) this.findViewById(R.id.electric);         //触电响应
        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityElectric.class);
                startActivity(intent);
            }
        } );

        cpr = (Button) this.findViewById(R.id.cpr);         //cpr响应
        cpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityFirstaid.this, ActivityCpr.class);
                startActivity(intent);
            }
        } );



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}

