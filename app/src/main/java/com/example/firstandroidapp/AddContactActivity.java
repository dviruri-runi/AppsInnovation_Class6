package com.example.firstandroidapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.ContentValues;

import java.io.File;
import java.io.IOException;

public class AddContactActivity extends AppCompatActivity {

    ImageView addPhoto;
    int REQUEST_PERMISSIONS_CODE = 1;
    private ActivityResultLauncher<Uri> takePictureLauncher;
    private Uri CurrentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        takePictureLauncher = registerForActivityResult(new ActivityResultContracts.TakePicture(), result -> {
            if (result) {
                addPhoto.setImageURI(CurrentImage);
            }
        });
        addPhoto = findViewById(R.id.addPhoto);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_MEDIA_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AddContactActivity.this, new String[] {
                            Manifest.permission.CAMERA,
                            Manifest.permission.ACCESS_MEDIA_LOCATION
                    }, REQUEST_PERMISSIONS_CODE);
                } else {
                    captureImage();
                }
            }
        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.name);
                EditText email = findViewById(R.id.email);
                Contact c = new Contact(CurrentImage,name.getText().toString(),email.getText().toString());
                Intent i = new Intent();
                i.putExtra("contact",c);
                setResult(1,i);
                finish();
            }
        });
    }

    private Uri createImageUri() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }

    public void captureImage() {
        Uri imageUri = createImageUri();
        if (imageUri != null) {
            CurrentImage = imageUri;
            takePictureLauncher.launch(imageUri);
        }
    }

}