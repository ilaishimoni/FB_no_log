package com.example.fb;

import static com.example.fb.FBref.refMeal;
import static com.example.fb.FBref.refOrder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showorders extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Intent gi;
    String identifier;
    String name;

    ArrayAdapter adp;
    ListView lv;
    String id;

    String Date;
    int Hour;
    String Worker;
    String Meal;
    String DeliveringCompany;

    ArrayList<String> identifierList = new ArrayList<String>();
    ArrayList<order> orders = new ArrayList<order>();
    ArrayList<String> ForIntent = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showorders);

        lv = (ListView) findViewById(R.id.lv);

        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        lv.setOnItemClickListener(this);

        ValueEventListener orderlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dS) {

                identifierList.clear();
                orders.clear();

                for(DataSnapshot data : dS.getChildren()) {
                    id = (String) data.getKey();
                    ForIntent.add(id);

                    order orderstemp = data.getValue(order.class);
                    orders.add(orderstemp);

                    Date = orderstemp.getDate();
                    Hour = orderstemp.getHour();
                    Worker = orderstemp.getWorker();
                    Meal = orderstemp.getMeal();
                    DeliveringCompany = orderstemp.getDeliveringCompany();


                    identifierList.add(Date + " "+ Hour+ " "+Worker+ " "+ Meal+ " "+ DeliveringCompany);

                }
                adp = new ArrayAdapter<String>(showorders.this, R.layout.support_simple_spinner_dropdown_item, identifierList);
                lv.setAdapter(adp);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        refMeal.addValueEventListener(orderlistener);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}