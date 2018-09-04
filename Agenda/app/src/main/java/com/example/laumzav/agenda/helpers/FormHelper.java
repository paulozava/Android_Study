package com.example.laumzav.agenda.helpers;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.laumzav.agenda.FormActivity;
import com.example.laumzav.agenda.R;

public class FormHelper {
    private EditText nameField;
    private EditText descField;
    private RatingBar priority;
    private CheckBox isDeletable;

    public FormHelper(FormActivity activity){
        EditText nameField = (EditText) activity.findViewById(R.id.form_jobName);
        EditText descField = (EditText) activity.findViewById(R.id.form_jobDesc);
        RatingBar priority = (RatingBar) activity.findViewById(R.id.form_priority);
        CheckBox isDeletable = (CheckBox) activity.findViewById(R.id.form_deletableJob);
    }



}
