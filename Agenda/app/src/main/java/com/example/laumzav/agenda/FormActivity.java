package com.example.laumzav.agenda;

import android.support.v4.widget.PopupMenuCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button saveButton = (Button) findViewById(R.id.form_saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
