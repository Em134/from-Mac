package com.example.a.androidui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySign extends AppCompatActivity {
    private Button map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign);   //关联注册界面

       // map = (Button) this.findViewById(R.id.map_go);
       /// map.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
              //  Intent intent = null;
             //   intent = new Intent(ActivityDoctorOnline.this, ActivityEarResult1.class);
               // startActivity(intent);
           // }
     //   } );





    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    }

