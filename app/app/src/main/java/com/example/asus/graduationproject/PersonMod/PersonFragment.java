package com.example.asus.graduationproject.PersonMod;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.graduationproject.LoginMod.LoginActivity;
import com.example.asus.graduationproject.PersonMod.QuickHelpMod.HelpActivity;
import com.example.asus.graduationproject.R;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import static android.content.Context.MODE_PRIVATE;

public class PersonFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.fragment_person, rootKey);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        initView();

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    private void initView(){
        Preference account=findPreference("account");
        SharedPreferences islogin=getActivity().getSharedPreferences("login",MODE_PRIVATE);
        String name=islogin.getString("account","未登录");
        account.setSummary(name);
        Preference phone=findPreference("phone");
        String number=islogin.getString("phone","未登录");
        phone.setSummary(number);
        account.setSummary(name);
        Preference cancel = findPreference("cancel");
        assert cancel != null;
        cancel.setOnPreferenceClickListener(this);
        Preference help = findPreference("help");
        assert help != null;
        help.setOnPreferenceClickListener(this);
        Preference update = findPreference("update");
        assert update != null;
        update.setOnPreferenceClickListener(this);
        Preference advise = findPreference("advise");
        assert advise != null;
        advise.setOnPreferenceClickListener(this);
        Preference about_us = findPreference("about_us");
        assert about_us != null;
        about_us.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key=preference.getKey();
        switch (key){
            case "cancel":
                AlertDialog.Builder normalDialog =
                        new AlertDialog.Builder(getContext());
                normalDialog.setTitle("是否注销");
                normalDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor islogin= getActivity().getSharedPreferences("login", MODE_PRIVATE).edit();
                                islogin.putBoolean("state",false);
                                islogin.apply();
                                Intent intent=new Intent(getActivity(), LoginActivity.class);
                                getActivity().finish();
                                startActivity(intent);
                            }
                        });
                normalDialog.setNegativeButton("关闭",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                            }
                        });
                // 显示
                normalDialog.show();
                break;
            case "help":
                Intent intent1=new Intent(getActivity(), HelpActivity.class);
                startActivity(intent1);
                break;
            case "update":
                Toast.makeText(getContext(),"已是最新版！",Toast.LENGTH_SHORT).show();
                break;
            case "advise":
                Intent intent2=new Intent(getActivity(), AdviseActivity.class);
                startActivity(intent2);
                break;
            case "about_us":
                Toast.makeText(getContext(),"这是一款个人的毕设软件，仅用于学习参考",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
