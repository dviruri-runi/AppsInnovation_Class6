package com.example.firstandroidapp;

import java.io.Serializable;

public class Contact implements Serializable {

    public int Avatar;
    public String Name;
    public String Email;

    public Contact(int a, String n, String e) {
        Avatar = a;
        Name = n;
        Email = e;
    }

}
