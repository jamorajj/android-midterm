package com.example.midtermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProgrammeActivity extends AppCompatActivity {

    private String programme;
    private TextView tvProgrammeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        programme = getIntent().getStringExtra("programme");
        tvProgrammeTitle = findViewById(R.id.tvProgrammeTitle);

        tvProgrammeTitle.setText(programme + " Programme");

        // create a arraylist of the type NumbersView
        final ArrayList<ProgrammeView> programmeArrayList = new ArrayList<ProgrammeView>();

        if(programme.equals("IT")){
            programmeArrayList.add(new ProgrammeView("Soft703", "Mobile Apps Development", "15"));
            programmeArrayList.add(new ProgrammeView("Soft806", "CI/CD", "15"));
            programmeArrayList.add(new ProgrammeView("Soft606", "Object Oriented Prog.", "10"));
        } else {
            programmeArrayList.add(new ProgrammeView("Bus105", "Business Communication", "15"));
            programmeArrayList.add(new ProgrammeView("Bus205", "HRM", "10"));
            programmeArrayList.add(new ProgrammeView("Bus206", "Marketing Management", "15"));
        }


        ListViewAdapter programmeArrayAdapter = new ListViewAdapter(this, programmeArrayList);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView numbersListView = findViewById(R.id.listView);

        // set the numbersViewAdapter for ListView
        numbersListView.setAdapter(programmeArrayAdapter);
    }
}