package com.example.a.androidui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHelpJoker extends AppCompatActivity {
    private Button ac2;
    //private TextView article2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_joke);

        //TextView article2 = (TextView)this.findViewById(R.id.article1);
       // article2.setMovementMethod(ScrollingMovementMethod.getInstance());

    }



}
