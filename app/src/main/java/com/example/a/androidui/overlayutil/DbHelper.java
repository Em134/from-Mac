package com.example.a.androidui.overlayutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String CREATE_READHISTORY="create table ReadHistory("+"id integer primary key autoincrement,"+"read text)";//阅读历史
    public static final String CREATE_CUREHISTORY="create table CureHistory("+"id integer primary key autoincrement,"+"cure text)";//诊断历史
    private Context mContext;
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_READHISTORY);
        db.execSQL(CREATE_CUREHISTORY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists ReadHistory");
//        db.execSQL("drop table if exists CureHistory");
//        onCreate(db);

    }
}
