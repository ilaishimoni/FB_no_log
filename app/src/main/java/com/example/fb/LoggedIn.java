package com.example.fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LoggedIn extends AppCompatActivity {
    Intent gi;
    TextView id;
    String identifier;
    String name;
    String Companyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        id = (TextView) findViewById(R.id.identifier);

        gi = getIntent();
        name = gi.getStringExtra("name");
        identifier = gi.getStringExtra("identifier");
        Companyst = gi.getStringExtra("company");



        id.setText( "   hello " + name);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.optionsmenu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("Credits")){
            gi = new Intent(this, credits.class);
            gi.putExtra("name", name);
            startActivity(gi);
        }
        if (st.equals("Main Screen")){
            gi = new Intent(this, LoggedIn.class);
            gi.putExtra("name", name);
            startActivity(gi);
        }

        return true;
    }

    public void meals(View view) {
        gi = new Intent(this, addshowmeal.class);
        gi.putExtra("path", identifier);
        gi.putExtra("name", name);
        gi.putExtra("company", Companyst);
        startActivity(gi);
    }

    public void company(View view) {
        gi = new Intent(this, addshowcompany.class);
        gi.putExtra("path", identifier);
        gi.putExtra("name", name);
        startActivity(gi);
    }

    public void users(View view) {
        gi = new Intent(this, viewuser.class);
        gi.putExtra("path", identifier);
        gi.putExtra("name", name);
        startActivity(gi);
    }

    public void show(View view) {
        gi = new Intent(this,showorders.class);
        gi.putExtra("path", identifier);
        gi.putExtra("name", name);
        startActivity(gi);
    }
}