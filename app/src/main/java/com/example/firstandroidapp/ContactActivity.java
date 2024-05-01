package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Bundle bundle = getIntent().getExtras();
        Contact contact = (Contact) bundle.getSerializable("contact");


        TextView Name = findViewById(R.id.name);
        TextView Email = findViewById(R.id.email);
        ImageView Avatar = findViewById(R.id.avatar);

        Avatar.setImageURI(Uri.parse(contact.Avatar));
        Name.setText(contact.Name);
        Email.setText(contact.Email);

    }
}