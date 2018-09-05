package com.example.laumzav.agenda.helpers;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.laumzav.agenda.FormActivity;
import com.example.laumzav.agenda.R;
import com.example.laumzav.agenda.dao.JobsDAO;
import com.example.laumzav.agenda.models.Jobs;

public class FormHelper {
    private FormActivity activity;
    private Jobs job;

    public FormHelper(FormActivity activity){
        activity = activity;

        EditText nameField = (EditText) activity.findViewById(R.id.form_jobName);
        EditText descField = (EditText) activity.findViewById(R.id.form_jobDesc);
        RatingBar priority = (RatingBar) activity.findViewById(R.id.form_priority);
        CheckBox isDeletable = (CheckBox) activity.findViewById(R.id.form_deletableJob);

        job = new Jobs(nameField.getText().toString(),
                       descField.getText().toString(),
                       String.valueOf(isDeletable.isChecked()),
                       priority.getRating());
    }

    public void saveOnDB(){
        JobsDAO dao = new JobsDAO(activity);
        dao.insert(job);
        dao.close();
    }

    public Jobs getJob(){
        return job;
    }

    public String getJobName(){
        return job.getName();
    }


}
