package com.example.fb;

import static com.example.fb.FBref.refMeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class editmeal extends AppCompatActivity {

    EditText Aperitifnew;
    EditText Mainnew;
    EditText Addnew;
    EditText dessertnew;
    EditText Drinkedt;
    TextView Idshow;

    Intent gi;
    String identifier;
    String name;
    String str;

    meal Meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editmeal);

        Aperitifnew = (EditText) findViewById(R.id.Aperitifnew);
        Mainnew = (EditText) findViewById(R.id.Mainnew);
        Addnew = (EditText) findViewById(R.id.Addnew);
        dessertnew = (EditText) findViewById(R.id.dessertnew);
        Idshow = (TextView) findViewById(R.id.idshow);
        Drinkedt = (EditText) findViewById(R.id.Drinkedt);


        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        str = gi.getStringExtra("datatoshow");
        Idshow.setText("id:             " + str);



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

        String apt = Aperitifnew.getText().toString();
        String main = Mainnew.getText().toString();
        String add = Addnew.getText().toString();
        String des = dessertnew.getText().toString();
        String drink = Drinkedt.getText().toString();

        Meal=new meal(apt,main,add,des,drink,str);
        refMeal.child(str).setValue(Meal);

        Aperitifnew.setText("");
        Mainnew.setText("");
        Addnew.setText("");
        dessertnew.setText("");
        Drinkedt.setText("");
        Idshow.setText("");
    }
    public void back(View view) {
        gi = new Intent(this, viewmeal.class);
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        startActivity(gi);

    }
}