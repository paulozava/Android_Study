package com.example.laumzav.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.laumzav.agenda.models.Jobs;

public class JobsDAO extends SQLiteOpenHelper {

    public JobsDAO(Context context) {
        super(context, "Jobs", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Jobs (id INTEGER PRIMARY KEY, jobName TEXT NOT NULL, jobDesc TEXT, priority REAL, isDeletable TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Jobs job){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("jobName", job.getName());
        data.put("jobDesc", job.getDesc());
        data.put("priority", job.getPriority());
        data.put("isDeletable", job.isDeletable());

        db.insert("Jobs", null, data);
        db.close();
    }
}
