package com.example.fb;

import static com.example.fb.FBref.refCompany;
import static com.example.fb.FBref.refMeal;

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

public class viewcompany extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Intent gi;
    ListView lv;

    String identifier;
    String name;

    int Tax;
    String CompName;
    int primary;
    int Secondary;
    String id;
    String Companyst;

    ArrayAdapter adp;

    ArrayList<String> identifierList = new ArrayList<String>();
    ArrayList<company> companyvalues = new ArrayList<company>();
    ArrayList<String> ForIntent = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcompany);

        lv = (ListView) findViewById(R.id.lv);

        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
        Companyst = gi.getStringExtra("company");

        lv.setOnItemClickListener(this);

        ValueEventListener companylistener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dS) {

                identifierList.clear();
                companyvalues.clear();

                for(DataSnapshot data : dS.getChildren()) {
                    id = (String) data.getKey();
                    ForIntent.add(id);

                    company companytemp = data.getValue(company.class);
                    companyvalues.add(companytemp);

                    Tax = companytemp.getTaxNumber();
                    CompName = companytemp.getCompanyName();
                    primary = companytemp.getPrimaryPhone();
                    Secondary = companytemp.getSecondaryPhone();

                    identifierList.add(id + " " + Tax + " "+ CompName+ " "+primary+ " "+ Secondary);

                }
                adp = new ArrayAdapter<String>(viewcompany.this, R.layout.support_simple_spinner_dropdown_item, identifierList);
                lv.setAdapter(adp);



            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        refCompany.addValueEventListener(companylistener);
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
            gi.putExtra("company", Companyst);
            startActivity(gi);
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        gi = new Intent(this, editcompany.class);
        gi.putExtra("datatoshow", ForIntent.get(i));
        gi.putExtra("name", name);
        gi.putExtra("path", identifier);
        startActivity(gi);


    }
}