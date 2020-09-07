package com.example.asus.graduationproject.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.asus.graduationproject.R;



public class RegisterEditview extends  androidx.appcompat.widget.AppCompatEditText{
    //注册界面的输入框，可以根据输入框的类型，正则匹配判断是否输入正确
    String phone_regex="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";//手机
    String name_regex="^[A-Za-z0-9]{4,10}$";//用户名由4~10位数字和字母组成
    String pwd_regex="^[a-zA-Z0-9]{6,16}$";//密码由6~16位数字和字母组合

    private String type;


    public RegisterEditview(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.bg_edittext_normal);

        this.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(isOK()){
                        setBackgroundResource(R.drawable.bg_edittext_normal);
                    }else{
                        setBackgroundResource(R.drawable.bg_edittext_wrong);
                    }
                }
            }
        });

    }



    public boolean isOK(){//判断输入是否合法
        if((type.equals("phone")&&getText().toString().matches(phone_regex))||
                (type.equals("name")&&getText().toString().matches(name_regex))||
                (type.equals("pwd")&&getText().toString().matches(pwd_regex)))
            return true;
        return false;
    }

    public void setType(String type) {
        this.type = type;
    }


}
