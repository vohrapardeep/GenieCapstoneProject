package com.example.test.ui.Feedback;


import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Feedback extends AppCompatActivity {

    EditText edName,edEmail,edFeedback;
    Spinner spinner,spinner2;
    RatingBar ratingBar;
    Button btnSubmit;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edFeedback = findViewById(R.id.edFeedback);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);


        final List<String> ServicesList = new ArrayList<String>();
        ServicesList.add("Choose Service");
        ServicesList.add("Electrician");
        ServicesList.add("Plumber");
        ServicesList.add("Beautician");
        ServicesList.add("Health Instructor");
        ServicesList.add("Construction Worker");

        final List<String> ServiceList1 = new ArrayList<String>();
        ServiceList1.add("Saul Garcia");
        ServiceList1.add("Shraddha Dandial");
        ServiceList1.add("Joe Melton");
        ServiceList1.add("Mehmood G.");
        ServiceList1.add("John Jurcic");
        ServiceList1.add("JP Morris");
        ServiceList1.add("Tony Morreal");
        ServiceList1.add("Arnold Drung");
        ServiceList1.add("Bryan Bue");
        ServiceList1.add("Ashely Doyle");
        ServiceList1.add("Andrea Blue");
        ServiceList1.add("Sailolalpela");
        ServiceList1.add("Rey Sabillaga");
        ServiceList1.add("Viacheslav Kostyshyn");
        ServiceList1.add("Moses NoSanizitizer");

        final List<String> ServiceList2 = new ArrayList<String>();
        ServiceList2.add("Temesgen Kifl");
        ServiceList2.add("Solomon Bereket");
        ServiceList2.add("Robert Mackenzie");
        ServiceList2.add("Mordu Araya");
        ServiceList2.add("Obang Omot");
        ServiceList2.add("Leon Orayou");
        ServiceList2.add("Okech Ojawto");
        ServiceList2.add("Peter Nyang");
        ServiceList2.add("James March");
        ServiceList2.add("Christopher Jagganarine");
        ServiceList2.add("Harbegna");
        ServiceList2.add("Efrem Gebroynas");
        ServiceList2.add("Berekti Mirach");
        ServiceList2.add("Betty Teklehnam");
        ServiceList2.add("Tedros Asfaha");

        final List<String> ServiceList3 = new ArrayList<String>();
        ServiceList3.add("Mariia Kostyshyn");
        ServiceList3.add("Marldel bih");
        ServiceList3.add("Folashade Akintotu");
        ServiceList3.add("Malahi Bih");
        ServiceList3.add("Qamargul Shawaliyan");
        ServiceList3.add("Simret Woldermichael");
        ServiceList3.add("Nenanel Berina");
        ServiceList3.add("Nicole Reguelman");
        ServiceList3.add("Mia Tenant");
        ServiceList3.add("Ria");
        ServiceList3.add("Harbegna");
        ServiceList3.add("Efrem Gebroynas");
        ServiceList3.add("Berekti Mirach");
        ServiceList3.add("Betty Teklehnam");
        ServiceList3.add("Tedros Asfaha");

        final List<String> ServiceList4 = new ArrayList<String>();
        ServiceList4.add("tin Cue");
        ServiceList4.add("Marry jae");
        ServiceList4.add("Harad joe");
        ServiceList4.add("Jonel Berina");
        ServiceList4.add("Nenanel Berina");




        final List<String> choose = new ArrayList<String>();
        choose.add("Choose Service Provider!");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ServicesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elec_service = spinner.getSelectedItem().toString();

                if(position==0){
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, choose);
                    adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter0);

                }

                if(position==1){
                    ArrayAdapter<String> adapterElec = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, ServiceList1);
                    adapterElec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterElec);
                }
                if(position==2){
                    ArrayAdapter<String> adapterElec2 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, ServiceList2);
                    adapterElec2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterElec2);
                }
                if(position==3){
                    ArrayAdapter<String> adapterElec3 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, ServiceList3);
                    adapterElec3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterElec3);
                }
                if(position==4){
                    ArrayAdapter<String> adapterElec4 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, ServiceList4);
                    adapterElec4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterElec4);
                }
//                if(position==5){
//                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Other);
//                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinner2.setAdapter(adapterOther);
//
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Feedback");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                String feedback = edFeedback.getText().toString();
                Float rating = ratingBar.getRating();
                String spinner_cat = spinner.getSelectedItem().toString();
                String provider_name = spinner2.getSelectedItem().toString();

                if(isNullOrBlank(name)){
                    edName.setError("Name Required!");
                }
                if(isNullOrBlank(email)){
                    edEmail.setError("Email Required!");
                }
                if(isNullOrBlank(feedback)){
                    edFeedback.setError("Feedback Required!");
                }
                if(!emailPatterncheck(email)){
                    edEmail.setError("Email Invalid!");
                }
                if(isNullOrBlank(spinner_cat)){
                    Toast.makeText(Feedback.this, "Category Required!", Toast.LENGTH_SHORT).show();
                }
                if(isNullOrBlank(provider_name)){
                    Toast.makeText(Feedback.this, "Servicer Provider required!", Toast.LENGTH_SHORT).show();
                }
                if(ratingBar.getRating()==0){
                    Toast.makeText(Feedback.this, "Rating Required!", Toast.LENGTH_SHORT).show();
                }
                else{

                    FeedbackHelper feedbackHelper = new FeedbackHelper(name, email, feedback, spinner_cat, provider_name,rating);
                    databaseReference.push().setValue(feedbackHelper);
                    Toast.makeText(Feedback.this, "Feedback Submitted!, Thanks.", Toast.LENGTH_SHORT).show();
                }
             }
        });


    }

    boolean isNullOrBlank(String s) {
        return (s == null || s.trim().equals(""));
    }

    private boolean emailPatterncheck(String email) {
        if (email == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}