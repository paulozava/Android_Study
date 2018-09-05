package com.example.laumzav.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.laumzav.agenda.models.Jobs;

import java.util.ArrayList;
import java.util.List;

public class JobsDAO extends SQLiteOpenHelper {

    public JobsDAO(Context context) {
        super(context, "Jobs", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Jobs (id INTEGER PRIMARY KEY AUTOINCREMENT, jobName TEXT NOT NULL, jobDesc TEXT, priority REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Jobs";
        db.execSQL(sql);
        onCreate(db);
    }

    public void saveJob(Jobs job){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("jobName", job.getName());
        data.put("jobDesc", job.getDesc());
        data.put("priority", job.getPriority());

        db.insert("Jobs", null, data);
    }

    public List<Jobs> findJobs() {

        List<Jobs> jobsFound = new ArrayList<Jobs>();

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Jobs;";
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()){
            Jobs job = new Jobs(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("jobName")),
                    c.getString(c.getColumnIndex("jobDesc")),
                    c.getFloat(c.getColumnIndex("priority")));

            jobsFound.add(job);
        }
        c.close();
        return jobsFound;

    }
}
