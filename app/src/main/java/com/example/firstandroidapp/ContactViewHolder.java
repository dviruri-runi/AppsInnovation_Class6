package com.example.firstandroidapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class ContactViewHolder extends RecyclerView.ViewHolder {

    public CardView Card;
    public ImageView Avatar;
    public TextView Name;
    public TextView Email;

    public ContactViewHolder(@NotNull View itemView) {
        super(itemView);
        Card = itemView.findViewById(R.id.card);
        Avatar = itemView.findViewById(R.id.avatar);
        Name = itemView.findViewById(R.id.name);
        Email = itemView.findViewById(R.id.email);

    }

}
