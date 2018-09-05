package com.example.laumzav.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laumzav.agenda.dao.JobsDAO;
import com.example.laumzav.agenda.models.Jobs;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    JobsDAO dao;
    ListView nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameList = findViewById(R.id.main_nameList);
        registerForContextMenu(nameList);
        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> nameList, View item, int position, long id) {
                Jobs jobs = (Jobs) nameList.getItemAtPosition(position);
                Intent openJobDesc = new Intent(ListActivity.this, JobDescActivity.class);
                openJobDesc.putExtra("jobs", jobs);
                startActivity(openJobDesc);
            }
        });

        Button fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity.this, FormActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadJobsList();
    }

    private void loadJobsList() {
        dao = new JobsDAO(this);
        List<Jobs> jobsList = dao.findJobs();
        dao.close();

        ArrayAdapter<Jobs> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobsList);
        nameList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem toDelete = menu.add("Delete");
        toDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Jobs job = (Jobs) nameList.getItemAtPosition(info.position);
                dao = new JobsDAO(ListActivity.this);
                dao.deleteJob(job);
                dao.close();
                Toast.makeText(ListActivity.this, job.getName() + " is deleted", Toast.LENGTH_SHORT).show();
                loadJobsList();
                return false;
            }
        });
    }
}
