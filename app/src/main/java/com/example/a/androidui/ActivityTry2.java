package com.example.a.androidui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTry2 extends AppCompatActivity {
    private Button ac2;
    //private TextView article2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try1);

        //TextView article2 = (TextView)this.findViewById(R.id.article1);
       // article2.setMovementMethod(ScrollingMovementMethod.getInstance());

    }



}
