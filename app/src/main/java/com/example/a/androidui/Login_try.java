package com.example.a.androidui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login_try extends AppCompatActivity {

    private TextView tv_main_title;//标题
    private TextView tv_back;
    private TextView tv_register;
    private TextView tv_find_psw;
    private Button btn_login;//登录按钮
    private String userName, psw, spPsw;//获取的用户名，密码，加密密码
    private EditText et_user_name, et_psw;//编辑框

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login1);

        tv_main_title = findViewById(R.id.tv_main_title);
        tv_main_title.setText("登录");
        tv_back = findViewById(R.id.tv_back);
        //从activity_login.xml中获取的
        tv_find_psw = this.findViewById(R.id.tv_find_psw);
        btn_login =this.findViewById(R.id.btn_login);
        et_user_name = this.findViewById(R.id.et_user_name);
        et_psw =this.findViewById(R.id.et_psw);
        //返回键的点击事件

        tv_back.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //登录界面销毁
                Login_try.this.finish();
            }

        });
        tv_register = (TextView) this.findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(Login_try.this, Sign_try.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //开始登录，获取用户名和密码 getText().toString().trim();
                userName = et_user_name.getText().toString().trim();
                psw = et_psw.getText().toString().trim();
                //对当前用户输入的密码进行MD5加密再进行比对判断, MD5Utils.md5( ); psw 进行加密判断是否一致
                String md5Psw = MD5Utils.md5(psw);
                // md5Psw ; spPsw 为 根据从SharedPreferences中用户名读取密码
                // 定义方法 readPsw为了读取用户名，得到密码
                spPsw = readPsw(userName);
                // TextUtils.isEmpty
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(Login_try.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(Login_try.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                    // md5Psw.equals(); 判断，输入的密码加密后，是否与保存在SharedPreferences中一致
                } else if (md5Psw.equals(spPsw)) {
                    //一致登录成功
                    Toast.makeText(Login_try.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //保存登录状态，在界面保存登录的用户名 定义个方法 saveLoginStatus boolean 状态 , userName 用户名;
                    saveLoginStatus(true, userName);
                    //登录成功后关闭此页面进入主页
                    Intent data = new Intent();
                    //datad.putExtra( ); name , value ;
                    data.putExtra("isLogin", true);
                    //RESULT_OK为Activity系统常量，状态码为-1
                    // 表示此页面下的内容操作成功将data返回到上一页面，如果是用back返回过去的则不存在用setResult传递data值
                    setResult(RESULT_OK, data);
                    //销毁登录界面
                    Login_try.this.finish();
                    //跳转到主界面，登录成功的状态传递到 MainActivity 中
                    startActivity(new Intent(Login_try.this, MainActivity.class));
                    return;

                } else if ((spPsw != null && !TextUtils.isEmpty(spPsw) && !md5Psw.equals(spPsw))) {
                    Toast.makeText(Login_try.this, "输入的用户名和密码不一致", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Toast.makeText(Login_try.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
    //获取界面控件

    /**
     * 从SharedPreferences中根据用户名读取密码
     */

    private String readPsw(String userName) {

        //getSharedPreferences("loginInfo",MODE_PRIVATE);
        //"loginInfo",mode_private; MODE_PRIVATE表示可以继续写入
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        //sp.getString() userName, "";
        return sp.getString(userName, "");
    }

    /**
     * 保存登录状态和登录用户名到SharedPreferences中
     */

    private void saveLoginStatus(boolean status, String userName) {
        //saveLoginStatus(true, userName);
        //loginInfo表示文件名  SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取编辑器
        SharedPreferences.Editor editor = sp.edit();
        //存入boolean类型的登录状态
        editor.putBoolean("isLogin", status);
        //存入登录状态时的用户名
        editor.putString("loginUserName", userName);
        //提交修改
        editor.commit();
    }

    /**
     * 注册成功的数据返回至此
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data        数据
     */

    @Override

    //显示数据， onActivityResult

    //startActivityForResult(intent, 1); 从注册界面中获取数据

    //int requestCode , int resultCode , Intent data

    // LoginActivity -> startActivityForResult -> onActivityResult();

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {

            //是获取注册界面回传过来的用户名

            // getExtra().getString("***");

            String userName = data.getStringExtra("userName");

            if (!TextUtils.isEmpty(userName)) {

                //设置用户名到 et_user_name 控件

                et_user_name.setText(userName);

                //et_user_name控件的setSelection()方法来设置光标位置

                et_user_name.setSelection(userName.length());

            }

        }

    }

}




