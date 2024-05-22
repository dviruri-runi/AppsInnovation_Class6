package com.example.firstandroidapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        handleData(data);
                    }
                }
        );

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        rv.setLayoutManager(layoutManager);

        adapter = new ContactAdapter();
        rv.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new SwipeToDeleteCallback(adapter));
        helper.attachToRecyclerView(rv);

        FloatingActionButton btn = findViewById(R.id.floatingActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //throw new RuntimeException("Test Crash!");
                Intent i = new Intent(MainActivity.this,AddContactActivity.class);
                activityResultLauncher.launch(i);

                //startActivity(i);

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

    private void handleData(Intent data) {
        //Bundle b = data.getExtras();
        //Contact contact = (Contact)b.getSerializable("contact");
        //adapter.AddContact(contact);
    }
}