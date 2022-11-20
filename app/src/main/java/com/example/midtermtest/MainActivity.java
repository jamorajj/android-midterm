package com.example.midtermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnItProgramme;
    private Button btnBusinessProgramme;
    private Button btnGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnItProgramme = findViewById(R.id.btnItProgramme);
        btnBusinessProgramme = findViewById(R.id.btnBusinessProgramme);
        btnGallery = findViewById(R.id.btnGallery);

        btnItProgramme.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProgrammeActivity.class);
            intent.putExtra("programme", "IT");
            startActivity(intent);
        });

        btnBusinessProgramme.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProgrammeActivity.class);
            intent.putExtra("programme", "Business");
            startActivity(intent);
        });

        btnGallery.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent);
        });
    }
}