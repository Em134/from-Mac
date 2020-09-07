package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMouth7 extends AppCompatActivity {
    private Button mouth1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wenzhen_mouth7);   //口腔部分的二级目录，是主要症状....（二级目录）口臭

        mouth1 = (Button) this.findViewById(R.id.mouthpain30);
        mouth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(ActivityMouth7.this, ActivityMouth7_1.class);
                startActivity(intent);
            }
        } );






    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

