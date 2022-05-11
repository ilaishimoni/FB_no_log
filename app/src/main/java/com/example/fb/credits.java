package com.example.fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class credits extends AppCompatActivity {


    Intent gi;
    String name;
    String identifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        gi = getIntent();
        name = gi.getStringExtra("name");
        identifier = gi.getStringExtra("path");
    }

    public void back(View view) {
        gi = new Intent(this, LoggedIn.class);
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        startActivity(gi);
    }
}