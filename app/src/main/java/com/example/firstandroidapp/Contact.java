package com.example.firstandroidapp;

import android.net.Uri;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String,String> getAsMap() {
        Map<String,String> map = new HashMap<>();
        map.put("ID",ID);
        map.put("Avatar",Avatar);
        map.put("Name", Name);
        map.put("Email",Email);
        return map;
    }

}
