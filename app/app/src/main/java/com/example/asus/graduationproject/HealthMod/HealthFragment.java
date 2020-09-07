package com.example.asus.graduationproject.HealthMod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.graduationproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HealthFragment extends Fragment implements View.OnClickListener {
    //用于显示人体模型图
    private FragmentManager fm;
    private List<Fragment> fragments=new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        initView(view);
        return view;
    }
    private void initView(View view){
        Button body = view.findViewById(R.id.body);
        Button head = view.findViewById(R.id.head);
        Button hand_left = view.findViewById(R.id.hand_left);
        Button hand_right = view.findViewById(R.id.hand_right);
        Button legs = view.findViewById(R.id.legs);

        body.setOnClickListener(this);
        head.setOnClickListener(this);
        hand_left.setOnClickListener(this);
        hand_right.setOnClickListener(this);
        legs.setOnClickListener(this);

        fm= Objects.requireNonNull(getActivity()).getSupportFragmentManager();
    }


    @Override
    public void onClick(View v) {


            FragmentTransaction ft= fm.beginTransaction();
            Fragment fragment=new ExamFragment();
            Bundle bundle=new Bundle();

            int postion=v.getId();
            //判断所点击的部位，跳转ExamFragment
            switch (postion){
                case R.id.head:
                    bundle.putString("position","头部");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.container,fragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(),"头部",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.body:
                    bundle.putString("position","躯干");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.container,fragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(),"躯干",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.legs:
                case R.id.hand_left:
                case R.id.hand_right:
                    bundle.putString("position","四肢");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.container,fragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(),"四肢",Toast.LENGTH_SHORT).show();
                    break;

            }

    }


}
