package com.example.asus.graduationproject.Tools;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.example.asus.graduationproject.DailyMod.StepCountService;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionUtil {
    private Activity context;
    public  PermissionUtil( Activity context){
        this.context=context;
    }
    public void gaintPermissions(String permissions){
        if (ContextCompat.checkSelfPermission(context, permissions) == PackageManager.PERMISSION_GRANTED) {//已有权限
            Intent intent=new Intent(context, StepCountService.class);
            context.startService(intent);
        } else {//申请权限
            ActivityCompat.requestPermissions(context,new String[]{ permissions}, 1);
        }
    }
}
