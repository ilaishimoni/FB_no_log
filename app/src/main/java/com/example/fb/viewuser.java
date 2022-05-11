package com.example.fb;


import static com.example.fb.FBref.refSign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class viewuser extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent gi;
    String name;
    String identifier;
    ListView lv;
    String id;

    String FirsstN;
    String FinalN;
    String CompanyN;
    String IdN;
    String phoneN;


    ArrayList<String> identifierList = new ArrayList<String>();
    ArrayList<sign> uservalues = new ArrayList<sign>();
    ArrayList<String> ForIntent = new ArrayList<String>();

    ArrayAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);

        lv = (ListView) findViewById(R.id.lv);
        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        lv.setOnItemClickListener(this);


        ValueEventListener userlistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dS) {

                identifierList.clear();
                uservalues.clear();

                for(DataSnapshot data : dS.getChildren()) {
                    id = (String) data.getKey();
                    ForIntent.add(id);

                    sign usertemp = data.getValue(sign.class);
                    uservalues.add(usertemp);

                    FirsstN = usertemp.getFinalName();
                    FinalN = usertemp.getFinalName();
                    CompanyN = usertemp.getCompanyName();
                    IdN = usertemp.getID();
                    phoneN = String.valueOf(usertemp.getPhoneNumber());


                    identifierList.add(id + " " + FirsstN + " "+ FinalN+ " "+CompanyN+ " "+ phoneN);

                }
                adp = new ArrayAdapter<String>(viewuser.this, R.layout.support_simple_spinner_dropdown_item, identifierList);
                lv.setAdapter(adp);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        refSign.addValueEventListener(userlistener);




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

    // position starts from 0
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        gi = new Intent(this, edituser.class);
        gi.putExtra("datatoshow", ForIntent.get(i));
        gi.putExtra("path", identifier);
        gi.putExtra("name", name);

        startActivity(gi);

    }
}