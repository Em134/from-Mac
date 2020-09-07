package com.example.asus.graduationproject.MyView;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.asus.graduationproject.R;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class PwdLayout extends ConstraintLayout {//带可见眼睛的自定义密码框
    ImageView hide;
    EditText editText;
    boolean isHide=true;//是否隐藏密码
    public PwdLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.pwd_et_1,this);
        hide=(ImageView) findViewById(R.id.imageView);
        editText=findViewById(R.id.pwd);

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHide=!isHide;
                if(isHide){
                    hide.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.show));
                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    hide.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.hide));
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                editText.setSelection(editText.getText().length());

            }
        });
    }
}
