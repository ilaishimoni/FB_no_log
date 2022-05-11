package com.example.fb;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBref {

    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance();

    public static DatabaseReference refCompany=FBDB.getReference("company");
    public static DatabaseReference refMeal=FBDB.getReference("meal");
    public static DatabaseReference refSign=FBDB.getReference("sign");
    public static DatabaseReference refOrder=FBDB.getReference("order");


}

