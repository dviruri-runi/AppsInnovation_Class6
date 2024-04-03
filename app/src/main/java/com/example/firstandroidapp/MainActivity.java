package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        rv.setLayoutManager(layoutManager);

        ContactAdapter adapter = new ContactAdapter();
        rv.setAdapter(adapter);

        FloatingActionButton btn = findViewById(R.id.floatingActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(i);
                /*Contact c = new Contact(R.drawable.avatar4,"New Contact","newcontact@gmail.com");
                adapter.AddContact(c);*/
            }
        });

       /* Button btn = findViewById(R.id.button);
        btn.setText("Click Me!");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btn.setText("Button Clicked!");
                Toast.makeText(v.getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
            }
        }); */

    }
}