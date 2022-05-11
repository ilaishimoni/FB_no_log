package com.example.fb;

import static com.example.fb.FBref.refCompany;
import static com.example.fb.FBref.refMeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class editcompany extends AppCompatActivity {

    EditText Tax;
    EditText Company;
    EditText Primary;
    EditText Secondary;
    TextView idddd;

    Intent gi;
    String identifier;
    String name;
    String str;

    company comp;
    String value;

    int Taxint;
    int primaryint;
    int secondaryint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcompany);

        Tax = (EditText) findViewById(R.id.Tax);
        Company = (EditText) findViewById(R.id.Company);
        Primary = (EditText) findViewById(R.id.Primary);
        Secondary = (EditText) findViewById(R.id.Secondary);
        idddd = (TextView) findViewById(R.id.idddd);

        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        str = gi.getStringExtra("datatoshow");
        idddd.setText("id:             " + str);

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
            startActivity(gi);
        }
        if (st.equals("Main Screen")){
            gi = new Intent(this, LoggedIn.class);
            gi.putExtra("name", name);
            gi.putExtra("path", identifier);
            startActivity(gi);
        }

        return true;
    }

    public void update(View view) {

        value= Tax.getText().toString();
        Taxint =Integer.parseInt(value);

        String CompanyName = Company.getText().toString();

        value= Primary.getText().toString();
        primaryint =Integer.parseInt(value);

        value= Secondary.getText().toString();
        secondaryint =Integer.parseInt(value);

        comp=new company(Taxint,CompanyName,primaryint,secondaryint, str);
        refCompany.child(str).setValue(comp);

        Tax.setText("");
        Company.setText("");
        Primary.setText("");
        Secondary.setText("");

        gi = new Intent(this, viewcompany.class);
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        startActivity(gi);
    }
}