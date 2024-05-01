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

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    List<Contact> Contacts;

    public ContactAdapter() {
        super();
        Contacts = new ArrayList<>();
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
        holder.Avatar.setImageURI(Uri.parse(contact.Avatar));
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
