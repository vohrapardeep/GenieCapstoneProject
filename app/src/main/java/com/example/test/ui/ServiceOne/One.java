package com.example.test.ui.ServiceOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.ui.checkout.Checkout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class One extends AppCompatActivity {

    TextView txtviewTitle,txtviewPrice;
    ImageView img1;
    Button btnCheckout;
    Spinner spinner_category,spinner_SP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        txtviewTitle = findViewById(R.id.txtviewTitle);
        img1 = findViewById(R.id.img1);
        btnCheckout = findViewById(R.id.btnCheckout);
        spinner_category = findViewById(R.id.spinner_category);
        spinner_SP = findViewById(R.id.spinner_SP);

        final List<String> categories_list = new ArrayList<String>();
        categories_list.add("Choose Service");
        categories_list.add("New Appliance Installation");
        categories_list.add("Underground Wiring");
        categories_list.add("Electrical Appliance's Repair");
        categories_list.add("Short Circuit Repair");
        categories_list.add("Other");

        final List<String> Electrician1 = new ArrayList<String>();
        Electrician1.add("John Jurcic");
        Electrician1.add("JP Morris");
        Electrician1.add("Tony Morreal");
        Electrician1.add("Arnold Drung");

        final List<String> Electrician2 = new ArrayList<String>();
        Electrician2.add("Saul Garcia");
        Electrician2.add("Shraddha Dandial");
        Electrician2.add("Joe Melton");
        Electrician2.add("Mehmood G.");

        final List<String> Electrician3 = new ArrayList<String>();
        Electrician3.add("Bryan Bue");
        Electrician3.add("Ashely Doyle");
        Electrician3.add("Andrea Blue");

        final List<String> Electrician4 = new ArrayList<String>();
        Electrician4.add("Sailolalpela");
        Electrician4.add("Rey Sabillaga");
        Electrician4.add("Viacheslav Kostyshyn");
        Electrician4.add("Moses NoSanizitizer");

        final List<String> Other = new ArrayList<String>();
        Other.add("Choose 'Get a Quote' From Sidebar !");

        final List<String> choose = new ArrayList<String>();
        choose.add("Choose Service Provider!");


        //Category Spinner
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categories_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapter);

       spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String elec_service = spinner_category.getSelectedItem().toString();

               if(position==0){
                   ArrayAdapter<String> adapterchoose = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, choose);
                   adapterchoose.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterchoose);

               }

               if(position==1){
                   ArrayAdapter<String> adapterElec = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Electrician1);
                   adapterElec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterElec);
               }
               if(position==2){
                   ArrayAdapter<String> adapterElec2 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Electrician2);
                   adapterElec2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterElec2);
               }
               if(position==3){
                   ArrayAdapter<String> adapterElec3 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Electrician3);
                   adapterElec3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterElec3);
               }
               if(position==4){
                   ArrayAdapter<String> adapterElec4 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Electrician4);
                   adapterElec4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterElec4);
               }
               if(position==5){
                   ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Other);
                   adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_SP.setAdapter(adapterOther);

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        //getting Intent to get passed data
        Bundle bundle = getIntent().getExtras();
        String title=bundle.getString("title1");
        int img= bundle.getInt("img1");

        //Passing values received to respective resources
        txtviewTitle.setText(title);
        img1.setImageResource(img);


        //checkout button click listener
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("ServiceOneCategory");

                String category_selected = spinner_category.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(), Checkout.class);
                i.putExtra("service",category_selected);
                startActivity(i);
            }
        });
    }
}
