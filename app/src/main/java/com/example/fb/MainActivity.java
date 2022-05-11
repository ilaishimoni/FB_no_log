package com.example.fb;

import static com.example.fb.FBref.refSign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    sign Sign;

    EditText CardNumber;
    EditText FinalName;
    EditText FirstName;
    EditText CompanyName;
    EditText ID;
    EditText PhoneNumber;

    int CardInt;
    String Finalstr;
    String Firststr;
    String Companystr;
    String IDstr;
    int PhoneInt;

    String value;

    AlertDialog.Builder adb;

    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardNumber = (EditText) findViewById(R.id.Aperitifnew);
        FinalName = (EditText) findViewById(R.id.Mainnew);
        FirstName = (EditText) findViewById(R.id.Addnew);
        CompanyName = (EditText) findViewById(R.id.dessertnew);
        ID = (EditText) findViewById(R.id.idshow);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);

    }


    public void signup(View view) {

        if(CardNumber.getText().toString().equals("") || FinalName.getText().toString().equals("") || FirstName.getText().toString().equals("") || CompanyName.getText().toString().equals("") || ID.getText().toString().equals("") || PhoneNumber.getText().toString().equals(""))
            Toast.makeText(this, "please fill all the lines", Toast.LENGTH_SHORT).show();
        else{
            value= CardNumber.getText().toString();
            CardInt =Integer.parseInt(value);

            Finalstr= FinalName.getText().toString();

            Firststr= FirstName.getText().toString();

            Companystr= CompanyName.getText().toString();

            IDstr = ID.getText().toString();

            value= PhoneNumber.getText().toString();
            PhoneInt =Integer.parseInt(value);

            Sign=new sign(CardInt, Finalstr, Firststr, Companystr, IDstr, PhoneInt);
            refSign.child(Sign.getID()).setValue(Sign);





            CardNumber.setText("");
            FinalName.setText("");
            FirstName.setText("");
            CompanyName.setText("");
            ID.setText("");
            PhoneNumber.setText("");

            si = new Intent(this, LoggedIn.class);
            si.putExtra("identifier", IDstr);
            si.putExtra("name", Firststr);
            startActivity(si);
        }
    }

    // sort and filter
    public void signin(View view) {
        adb = new AlertDialog.Builder((this));
        adb.setCancelable(false);
        adb.setTitle("Please enter your id in order to log in");
        final EditText et = new EditText(this);
        adb.setView(et);

        AlertDialog ad = adb.create();
        ad.show();
    }
}