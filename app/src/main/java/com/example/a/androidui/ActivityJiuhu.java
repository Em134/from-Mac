package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityJiuhu extends AppCompatActivity {
    private Button sprain;
    private Button firstaid;
    //救护总体分类，现阶段有急救和扭伤
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jiuhu);
        sprain = (Button) this.findViewById(R.id.sprain);   //扭伤
        sprain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityJiuhu.this, ActivitySprain1.class);
                startActivity(intent);
            }
        } );

        firstaid = (Button) this.findViewById(R.id.firstaid);          //急救
        firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityJiuhu.this, ActivitySprain1.class);
                startActivity(intent);
            }
        } );

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}

