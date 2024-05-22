package com.example.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Contact> Contacts;

    public ContactAdapter() {
        super();
        Contacts = new ArrayList<>();
        db.collection("Contacts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Contact c = new Contact(document.get("Avatar").toString(),document.get("Name").toString(),document.get("Email").toString(),document.get("ID").toString());
                                Contacts.add(c);
                            }
                            notifyDataSetChanged();
                        }
                    }
                });
    }

    public void AddContact(Contact c) {
        Contacts.add(c);
        notifyDataSetChanged();
    }

    public void DeleteContact(int pos) {
        Contacts.remove(pos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = Contacts.get(position);
        //holder.Avatar.setImageURI(Uri.parse(contact.Avatar));
        Glide.with(holder.Avatar).load(contact.Avatar).into(holder.Avatar);
        holder.Name.setText(contact.Name);
        holder.Email.setText(contact.Email);
        holder.Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ContactActivity.class);
                intent.putExtra("contact",contact);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) v.getContext(),
                        holder.Card,
                        "cardTransition"
                );
                v.getContext().startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Contacts.size();
    }
}
