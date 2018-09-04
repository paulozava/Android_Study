package com.example.laumzav.agenda;

import android.content.ClipData;
import android.support.v4.widget.PopupMenuCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.laumzav.agenda.helpers.FormHelper;

public class FormActivity extends AppCompatActivity {

    private FormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        helper = new FormHelper(this);

//        Button saveButton = (Button) findViewById(R.id.form_saveButton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FormActivity.this, "Saved", Toast.LENGTH_LONG).show();
////                Save in a data bank
//                finish();
//            }
//        });

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
                Toast.makeText(FormActivity.this, "Job " + helper.getJobName() + " saved", Toast.LENGTH_LONG).show();
                break;
            case R.id.form_discart_button:
                Toast.makeText(FormActivity.this, "Discarted", Toast.LENGTH_LONG).show();
                break;
        }
        finish();
        return true;
    }

}
