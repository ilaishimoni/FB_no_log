package com.example.fb;

import static com.example.fb.FBref.refMeal;
import static com.example.fb.FBref.refOrder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class addshowmeal extends AppCompatActivity {

    Intent gi;

    EditText Aperitif;
    EditText MAIN_MEAL;
    EditText ADD_ON;
    EditText DESSERT;
    EditText DRINK;

    String Aperitif_st;
    String MAIN_MEAL_st;
    String ADD_ON_st;
    String DESSERT_st;
    String DRINK_st;

    String identifier;
    String name;
    meal Meal;
    String Companyst;

    order Order;
    // Instantiate a Date object
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshowmeal);

        Aperitif = (EditText) findViewById(R.id.Tax);
        MAIN_MEAL = (EditText) findViewById(R.id.Company);
        ADD_ON = (EditText) findViewById(R.id.Primary);
        DESSERT = (EditText) findViewById(R.id.Secondary);
        DRINK = (EditText) findViewById(R.id.Drink);

        gi = getIntent();
        name = gi.getStringExtra("name");
       identifier = gi.getStringExtra("path");
       Companyst = gi.getStringExtra("company");

    }

    public void meal(View view) {

        Aperitif_st = Aperitif.getText().toString();
        MAIN_MEAL_st = MAIN_MEAL.getText().toString();
        ADD_ON_st = ADD_ON.getText().toString();
        DESSERT_st = DESSERT.getText().toString();
        DRINK_st = DRINK.getText().toString();

        Meal=new meal(Aperitif_st, MAIN_MEAL_st, ADD_ON_st, DESSERT_st, DRINK_st, identifier);
        refMeal.child(identifier).setValue(Meal);


        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);

        String meal = Aperitif_st +" " + MAIN_MEAL_st+" "+ADD_ON_st+" "+DESSERT_st;
        

        Order = new order(date.toString(),hour,name,meal,Companyst);
        refOrder.child(identifier).setValue(Order);


        Aperitif.setText("");
        MAIN_MEAL.setText("");
        ADD_ON.setText("");
        DESSERT.setText("");
        DRINK.setText("");

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

    public void view(View view) {
        gi = new Intent(this, viewmeal.class);
        startActivity(gi);
    }

}