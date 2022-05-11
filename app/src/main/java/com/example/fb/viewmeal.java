package com.example.fb;

import static com.example.fb.FBref.refMeal;
import static com.example.fb.FBref.refSign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewmeal extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent gi;
    ListView lv;
    String identifier;
    String name;
    String id;

    String Aperitif;
    String MainMeal;
    String AddOn;
    String Dessert;
    String Drink;

    ArrayAdapter adp;

    ArrayList<String> identifierList = new ArrayList<String>();
    ArrayList<meal> mealvalues = new ArrayList<meal>();
    ArrayList<String> ForIntent = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmeal);

        lv = (ListView) findViewById(R.id.lv);

        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        lv.setOnItemClickListener(this);

        ValueEventListener meallistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dS) {

                identifierList.clear();
                mealvalues.clear();

                for(DataSnapshot data : dS.getChildren()) {
                    id = (String) data.getKey();
                    ForIntent.add(id);

                    meal mealtemp = data.getValue(meal.class);
                    mealvalues.add(mealtemp);

                    Aperitif = mealtemp.getFirstMeal();
                    MainMeal = mealtemp.getMainMeal();
                    AddOn = mealtemp.getAddOn();
                    Dessert = mealtemp.getDessert();
                    Drink = mealtemp.getDessert();


                    identifierList.add(id + " " + Aperitif + " "+ MainMeal+ " "+AddOn+ " "+ Dessert+ " "+ Drink);

                }
                adp = new ArrayAdapter<String>(viewmeal.this, R.layout.support_simple_spinner_dropdown_item, identifierList);
                lv.setAdapter(adp);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        refMeal.addValueEventListener(meallistener);
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
            gi.putExtra("path", identifier);

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        gi = new Intent(this, editmeal.class);
        gi.putExtra("datatoshow", ForIntent.get(i));
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        startActivity(gi);

    }
}