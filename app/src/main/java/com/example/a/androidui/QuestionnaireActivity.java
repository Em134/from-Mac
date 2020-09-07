package com.example.a.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//问卷评估页面
public class QuestionnaireActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardquestionnaire);
    }

    public void oneOnClick(View v) {


        Intent intent = null;
        switch (v.getId()) {
            case R.id.buttonbody:
                intent = new Intent(QuestionnaireActivity.this, Activitybody.class);
                startActivity(intent);
                break;

            case R.id.buttonfeel:
                intent = new Intent(QuestionnaireActivity.this, Activityfeel.class);
                startActivity(intent);
                break;
        }
    }

}



