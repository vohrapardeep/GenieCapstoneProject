package com.example.test.ui.ServiceProvider;

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
import android.widget.Toast;

import com.example.test.R;
import com.example.test.ui.checkout.Checkout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Three extends AppCompatActivity {

    TextView txtviewTitle;
    ImageView img1;
    Button btnCheckout;
    Spinner spinner_category,spinner_SP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        txtviewTitle = findViewById(R.id.txtviewTitle);
        img1 = findViewById(R.id.img1);
        btnCheckout = findViewById(R.id.btnCheckout);
        spinner_category = findViewById(R.id.spinner_category);
        spinner_SP = findViewById(R.id.spinner_SP);

        final List<String> categories_list2 = new ArrayList<String>();
        categories_list2.add("Choose Service");
        categories_list2.add("Haircut");
        categories_list2.add("Hair Color");
        categories_list2.add("Rebonding");
        categories_list2.add("Make over");
        categories_list2.add("Hair Spa");
        categories_list2.add("Facial & Bleach");
        categories_list2.add("Skin Cleansing");
        categories_list2.add("Nail Art");
        categories_list2.add("Manicure and/or Pedicure");
        categories_list2.add("Upper lips");
        categories_list2.add("Eyebrows Thread Shaping");
        categories_list2.add("Nail Extension");
        categories_list2.add("Eyelashe extension");

        final List<String> Beautician1 = new ArrayList<String>();
        Beautician1.add("Mariia Kostyshyn");
        Beautician1.add("Marldel bih");
        Beautician1.add("Folashade Akintotu");
        Beautician1.add("Malahi Bih");

        final List<String> Beautician2 = new ArrayList<String>();
        Beautician2.add("Qamargul Shawaliyan");
        Beautician2.add("Simret Woldermichael");
        Beautician2.add("Nenanel Berina");
        Beautician2.add("Nicole Reguelman");

        final List<String> Beautician3 = new ArrayList<String>();
        Beautician3.add("Mia Tenant");
        Beautician3.add("Ria");
        Beautician3.add("Harbegna");

        final List<String> Beautician4 = new ArrayList<String>();
        Beautician4.add("Efrem Gebroynas");
        Beautician4.add("Berekti Mirach");
        Beautician4.add("Betty Teklehnam");
        Beautician4.add("Tedros Asfaha");

        final List<String> Beautician5 = new ArrayList<String>();
        Beautician5.add("Efrem Gebroynas");
        Beautician5.add("Berekti Mirach");
        Beautician5.add("Betty Teklehnam");
        Beautician5.add("Tedros Asfaha");

        final List<String> Beautician6 = new ArrayList<String>();
        Beautician6.add("Efrem Gebroynas");
        Beautician6.add("Berekti Mirach");
        Beautician6.add("Betty Teklehnam");
        Beautician6.add("Tedros Asfaha");

        final List<String> Beautician7 = new ArrayList<String>();
        Beautician7.add("Efrem Gebroynas");
        Beautician7.add("Berekti Mirach");
        Beautician7.add("Betty Teklehnam");
        Beautician7.add("Tedros Asfaha");

        final List<String> Beautician8 = new ArrayList<String>();
        Beautician8.add("Efrem Gebroynas");
        Beautician8.add("Berekti Mirach");
        Beautician8.add("Betty Teklehnam");
        Beautician8.add("Tedros Asfaha");

        final List<String> Beautician9 = new ArrayList<String>();
        Beautician9.add("Efrem Gebroynas");
        Beautician9.add("Berekti Mirach");
        Beautician9.add("Betty Teklehnam");
        Beautician9.add("Tedros Asfaha");


        final List<String> Beautician10 = new ArrayList<String>();
        Beautician10.add("Efrem Gebroynas");
        Beautician10.add("Berekti Mirach");
        Beautician10.add("Betty Teklehnam");
        Beautician10.add("Tedros Asfaha");

        final List<String> Beautician11 = new ArrayList<String>();
        Beautician11.add("Efrem Gebroynas");
        Beautician11.add("Berekti Mirach");
        Beautician11.add("Betty Teklehnam");
        Beautician11.add("Tedros Asfaha");

        final List<String> Beautician12 = new ArrayList<String>();
        Beautician12.add("Efrem Gebroynas");
        Beautician12.add("Berekti Mirach");
        Beautician12.add("Betty Teklehnam");
        Beautician12.add("Tedros Asfaha");

        final List<String> Beautician13 = new ArrayList<String>();
        Beautician13.add("Efrem Gebroynas");
        Beautician13.add("Berekti Mirach");
        Beautician13.add("Betty Teklehnam");
        Beautician13.add("Tedros Asfaha");

        final List<String> Other = new ArrayList<String>();
        Other.add("Choose 'Get a Quote' From Sidebar !");

        final List<String> choose = new ArrayList<String>();
        choose.add("Choose Service Provider!");


        //Category Spinner
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categories_list2);
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
                    ArrayAdapter<String> adapterElec = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician1);
                    adapterElec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec);
                }
                if(position==2){
                    ArrayAdapter<String> adapterElec2 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician2);
                    adapterElec2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec2);
                }
                if(position==3){
                    ArrayAdapter<String> adapterElec3 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician3);
                    adapterElec3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec3);
                }
                if(position==4){
                    ArrayAdapter<String> adapterElec4 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician4);
                    adapterElec4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec4);
                }
                if(position==5){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician5);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==6){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician6);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==7){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician7);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==8){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician8);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==9){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician9);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==10){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician10);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==11){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician11);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==12){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician12);
                    adapterOther.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterOther);

                }if(position==13){
                    ArrayAdapter<String> adapterOther = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Beautician13);
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
        String title=bundle.getString("title3");
        int img= bundle.getInt("img3");

        //Passing values received to respective resources
        txtviewTitle.setText(title);
        img1.setImageResource(img);


        //checkout button click listener
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spin1 = spinner_category.getSelectedItem().toString();
                String spin2 = spinner_SP.getSelectedItem().toString();
                if(spin1.equals("Choose Service") || spin2.equals("Choose Service Provider!") || spin1.equals("Other"))
                {
                    Toast.makeText(Three.this, "Selection is must ! ", Toast.LENGTH_SHORT).show();
                }
                else{
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("ServiceThreeCategory");

                String category_selected = spinner_category.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(), Checkout.class);
                i.putExtra("service",category_selected);
                startActivity(i);
            }}
        });
    }
}
