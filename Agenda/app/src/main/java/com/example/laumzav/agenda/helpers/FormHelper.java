package com.example.laumzav.agenda.helpers;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.laumzav.agenda.FormActivity;
import com.example.laumzav.agenda.R;
import com.example.laumzav.agenda.models.Jobs;

public class FormHelper {
    private EditText nameField;
    private EditText descField;
    private RatingBar priority;
    private CheckBox isDeletable;
    Jobs job;

    public FormHelper(FormActivity activity){
        nameField = (EditText) activity.findViewById(R.id.form_jobName);
        descField = (EditText) activity.findViewById(R.id.form_jobDesc);
        priority = (RatingBar) activity.findViewById(R.id.form_priority);
        isDeletable = (CheckBox) activity.findViewById(R.id.form_deletableJob);
        job = new Jobs(nameField.getText().toString(),
                descField.getText().toString(),
                isDeletable.getText().toString(),
                Float.toString(priority.getRating()));
    }





}
