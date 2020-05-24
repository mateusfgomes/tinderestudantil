package com.example.tinderestudantil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String USER_DATABASE = "user_db";
    private static final String USER_TABLE = "user_table";
    private static final String CODE_COL = "code";
    private static final String NAME_COL = "name";
    private static final String USERNAME_COL = "username";
    private static final String PASSWORD_COL = "password";
    private static final String ADDRESS_COL = "address";

    public database(Context context) {
        super(context, USER_DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String COL_QUERY = "CREATE TABLE " + USER_TABLE + "(" +
                CODE_COL + " INTEGER PRIMARY KEY, " + NAME_COL + " TEXT," +
                USERNAME_COL + " TEXT, " + PASSWORD_COL + " TEXT, " + ADDRESS_COL +
                " TEXT)";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
