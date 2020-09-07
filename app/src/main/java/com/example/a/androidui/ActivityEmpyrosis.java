package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEmpyrosis extends AppCompatActivity {
    private Button empyrosis1;
    private Button empyrosis2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu_empyrosis);

        empyrosis1 = (Button) this.findViewById(R.id.empyrosis1);          //深度
        empyrosis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEmpyrosis.this, ActivityEmpyrosisResult1.class);
                startActivity(intent);
            }
        } );

        empyrosis2 = (Button) this.findViewById(R.id.empyrosis2);          //轻度
        empyrosis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityEmpyrosis.this, ActivityEmpyrosisResult2.class);
                startActivity(intent);
            }
        } );


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

