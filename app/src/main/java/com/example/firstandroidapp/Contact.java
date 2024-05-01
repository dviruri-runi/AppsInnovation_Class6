package com.example.firstandroidapp;

import android.net.Uri;

import java.io.Serializable;

public class Contact implements Serializable {

    public String Avatar;
    public String Name;
    public String Email;

    public Contact(Uri a, String n, String e) {
        Avatar = String.valueOf(a);
        Name = n;
        Email = e;
    }

}
