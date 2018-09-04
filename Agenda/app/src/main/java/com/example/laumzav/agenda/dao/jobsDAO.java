package com.example.laumzav.agenda.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class jobsDAO extends SQLiteOpenHelper {

    public jobsDAO(Context context) {
        super(context, "Jobs", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Jobs (id INTEGER PRIMARY KEY, jobName TEXT NOT NULL, jobDesc TEXT, priority REAL, isDeletable TEXT);";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
