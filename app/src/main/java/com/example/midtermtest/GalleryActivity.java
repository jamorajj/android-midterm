package com.example.midtermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private Button btnPrevious;
    private Button btnAdd;
    private Button btnNext;
    private ImageView galleryImage;
    private int currentImage = 0;
    private ArrayList<Uri> imageArrayList;
    private boolean hasAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        btnPrevious = findViewById(R.id.btnPrevious);
        btnAdd = findViewById(R.id.btnAdd);
        btnNext = findViewById(R.id.btnNext);
        galleryImage = findViewById(R.id.galleryImage);
        imageArrayList = new ArrayList<Uri>();

        btnAdd.setOnClickListener(view -> {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(i, "Select Image"), 200);
        });

        btnNext.setOnClickListener(view -> {
            if(currentImage != imageArrayList.size() - 1 && hasAdded){
                currentImage++;
                galleryImage.setImageURI(imageArrayList.get(currentImage));
            }
        });

        btnPrevious.setOnClickListener(view -> {
            if(currentImage != 0 && hasAdded){
                currentImage--;
                galleryImage.setImageURI(imageArrayList.get(currentImage));
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 200) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    hasAdded = true;
                    galleryImage.setImageURI(selectedImageUri);
                    imageArrayList.add(selectedImageUri);
                    currentImage = imageArrayList.size() - 1;
                }
            }
        }
    }
}