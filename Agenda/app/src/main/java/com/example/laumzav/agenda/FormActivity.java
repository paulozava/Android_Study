package com.example.laumzav.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.laumzav.agenda.helpers.ToastHelper;
import com.example.laumzav.agenda.helpers.FormHelper;

public class FormActivity extends AppCompatActivity {

    private ToastHelper toastHelper = new ToastHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.form_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.form_save_button:
                FormHelper helper = new FormHelper(this);
                helper.saveOnDB();
                toastHelper.makeMessage(FormActivity.this, "Job " + helper.getJobName() + " saved");
                break;
            case R.id.form_discart_button:
                toastHelper.makeMessage(FormActivity.this, "Discarded");
                break;
        }
        finish();
        return true;
    }

}
