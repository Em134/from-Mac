package com.example.a.androidui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDoctorOnline extends AppCompatActivity {
    private Button map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_doctor_online);   //（辅助功能）地图界面，导航至附近的医院和诊所

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

