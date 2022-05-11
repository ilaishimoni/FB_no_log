package com.example.fb;

import static com.example.fb.FBref.refCompany;
import static com.example.fb.FBref.refSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class addshowcompany extends AppCompatActivity {
    Intent gi;

    EditText Tax;
    EditText CompanyName;
    EditText PrimaryPhone;
    EditText SecondaryPhone;

    int Taxint;
    String Companyst;
    int Primaryint;
    int Secondaryint;

    company Company;
    String value;
    String name;
    String identifier;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshowcompany);

        Tax = (EditText) findViewById(R.id.Tax);
        CompanyName = (EditText) findViewById(R.id.Company);
        PrimaryPhone = (EditText) findViewById(R.id.Primary);
        SecondaryPhone = (EditText) findViewById(R.id.Secondary);

        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");


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

    public void company(View view) {
        value= Tax.getText().toString();
        Taxint =Integer.parseInt(value);


        Companyst = CompanyName.getText().toString();

        value= PrimaryPhone.getText().toString();
        Primaryint =Integer.parseInt(value);

        value= SecondaryPhone.getText().toString();
        Secondaryint =Integer.parseInt(value);

        Company=new company(Taxint, Companyst, Primaryint, Secondaryint, identifier);
        refCompany.child(Company.getId()).setValue(Company);

        Tax.setText("");
        CompanyName.setText("");
        PrimaryPhone.setText("");
        SecondaryPhone.setText("");
    }

    public void view(View view) {
        gi = new Intent(this, viewcompany.class);
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        gi.putExtra("company", Companyst);
        startActivity(gi);
    }
}