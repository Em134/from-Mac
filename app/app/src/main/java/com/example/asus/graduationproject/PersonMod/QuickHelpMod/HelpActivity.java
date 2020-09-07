package com.example.asus.graduationproject.PersonMod.QuickHelpMod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.R;

public class HelpActivity extends AppCompatActivity {
    private static String TAG="HelpActivity" ;
    EditText person;
    EditText content;
    EditText count;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initView();
    }
    private void initView(){
        SharedPreferences sharedPreferences=getSharedPreferences(GlobalUitl.accoutName,MODE_PRIVATE);
        String helpPerson=sharedPreferences.getString("helpPerson","");
        int helpCount=sharedPreferences.getInt("helpCount",3);
        final String helpContent=sharedPreferences.getString("helpContent","");
        person=findViewById(R.id.et_phone);
        person.setText(helpPerson);
        content=findViewById(R.id.et_content);
        content.setText(helpContent);
        count=findViewById(R.id.et_count);
        count.setText(helpCount+"");
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor account=getSharedPreferences(GlobalUitl.accoutName,MODE_PRIVATE).edit();
                account.putString("helpPerson",person.getText().toString());
                account.putInt("helpCount", Integer.parseInt(count.getText().toString()));

                account.putString("helpContent",content.getText().toString());
                account.apply();
                Toast.makeText(HelpActivity.this,"提交成功！", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
