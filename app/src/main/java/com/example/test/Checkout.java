package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Checkout extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper db;
    EditText editTextName, editTextNumber,editTextEmail,editTextDate;
    RadioGroup radioGroup;
//    RadioButton radioButton,radioButton2;
    Spinner spinner;
    Button btnFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDate = findViewById(R.id.editTextDate);
        btnFinal = findViewById(R.id.btnFinal);


         radioGroup = findViewById(R.id.radioGroup);
         radioGroup.clearCheck();

         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @SuppressLint("ResourceType")
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 RadioButton rb = (RadioButton) group.findViewById(checkedId);

                 if(null!= rb && checkedId > -1){
                     Toast.makeText(Checkout.this, rb.getText(), Toast.LENGTH_SHORT).show();
                 }
             }
         });

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String>  time = new ArrayList<String>();
        time.add("9:00 am");
        time.add("10:00 am");
        time.add("11:00 am");
        time.add("12:00 pm");
        time.add("1:00 pm");
        time.add("2:00 pm");
        time.add("3:00 pm");
        time.add("4:00 pm");
        time.add("5:00 pm");
        time.add("6:00 pm");
        time.add("7:00 pm");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,time);

        spinner.setAdapter(dataAdapter);
        final String name = editTextName.getText().toString();
        final String number = editTextNumber.getText().toString();
        final String email = editTextEmail.getText().toString();
        final String date = editTextDate.getText().toString();
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendEmail();
                Intent i = new Intent(getApplicationContext(),End.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("number",number);
                i.putExtra("date",date);
                startActivity(i);
            }
        });

    }

    protected  void sendEmail(){
        Log.i("email sent","");
        Toast.makeText(getApplicationContext(),"Booking Successful",Toast.LENGTH_LONG).show();
        String[] TO = {""};
        String[] CC = {""};


        String to=editTextEmail.getText().toString();
        String date = editTextDate.getText().toString();

        String m= "Your booking has been confirmed on"+ date ;
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        i.putExtra(Intent.EXTRA_SUBJECT,"Booking:Rock Paper Scissor");
        i.putExtra(Intent.EXTRA_TEXT,m);
        try {
            startActivity(i.createChooser(i,"Sending Email"));
        }catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(Checkout.this, "There are no email clients installed", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(this, "selected"+ item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
