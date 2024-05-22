package com.example.firstandroidapp;

import android.net.Uri;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.sql.Time;

public class Contact implements Serializable {

    public String ID;
    public String Avatar;
    public String Name;
    public String Email;

    public Contact(String a, String n, String e) {
        Avatar = a;
        Name = n;
        Email = e;
        ID = String.valueOf(System.currentTimeMillis());
    }

    public Contact(String a, String n, String e, String i) {
        Avatar = a;
        Name = n;
        Email = e;
        ID = i;
    }

}
