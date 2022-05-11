package com.example.fb;

import static com.example.fb.FBref.refSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class edituser extends AppCompatActivity {
    Intent gi;
    String str;
    TextView Idshow;

    EditText CardNumber;
    EditText FinalName;
    EditText FirstName;
    EditText CompanyName;
    EditText PhoneNumber;

    sign Sign;
    String value;

    int CardInt;
    int PhoneInt;
    Intent si;

    String identifier;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);

        Idshow = (TextView) findViewById(R.id.idshow);
        CardNumber = (EditText) findViewById(R.id.Aperitifnew);
        FinalName = (EditText) findViewById(R.id.Mainnew);
        FirstName = (EditText) findViewById(R.id.Addnew);
        CompanyName = (EditText) findViewById(R.id.dessertnew);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);



        gi = getIntent();
        identifier = gi.getStringExtra("path");
        name = gi.getStringExtra("name");
         str = gi.getStringExtra("datatoshow");
        Idshow.setText("id:             " + str);
    }

    public void update(View view) {
        String Finalstr = FinalName.getText().toString();
        String Firststr = FirstName.getText().toString();
        String Companystr = CompanyName.getText().toString();

        value= CardNumber.getText().toString();
        CardInt =Integer.parseInt(value);

        value = PhoneNumber.getText().toString();
        PhoneInt = Integer.parseInt(value);


        Sign=new sign(CardInt, Finalstr, Firststr, Companystr, str, PhoneInt);
        refSign.child(Sign.getID()).setValue(Sign);

        CardNumber.setText("");
        FinalName.setText("");
        FirstName.setText("");
        CompanyName.setText("");
        PhoneNumber.setText("");

        si = new Intent(this, viewuser.class);
        startActivity(si);

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
}