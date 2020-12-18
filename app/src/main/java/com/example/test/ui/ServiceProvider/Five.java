package com.example.test.ui.ServiceProvider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
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

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Five extends AppCompatActivity {

    TextView txtviewTitle;
    ImageView img1;
    Button btnCheckout;
    Spinner spinner_category,spinner_SP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        txtviewTitle = findViewById(R.id.txtviewTitle);
        img1 = findViewById(R.id.img1);
        btnCheckout = findViewById(R.id.btnCheckout);
        spinner_category = findViewById(R.id.spinner_category);
        spinner_SP = findViewById(R.id.spinner_SP);

        final List<String> categories_list2 = new ArrayList<String>();
        categories_list2.add("Choose Service");
        categories_list2.add("Leakage Repair");
        categories_list2.add("New Faucet Installation");
        categories_list2.add("New Washroom Setup");
        categories_list2.add("Kitchen Basin Sink Repair");
        categories_list2.add("Other");

        final List<String> Plumber1 = new ArrayList<String>();
        Plumber1.add("Temesgen Kifl");
        Plumber1.add("Solomon Bereket");
        Plumber1.add("Robert Mackenzie");
        Plumber1.add("Mordu Araya");

        final List<String> Plumber2 = new ArrayList<String>();
        Plumber2.add("Obang Omot");
        Plumber2.add("Leon Orayou");
        Plumber2.add("Okech Ojawto");
        Plumber2.add("Peter Nyang");

        final List<String> Plumber3 = new ArrayList<String>();
        Plumber3.add("James March");
        Plumber3.add("Christopher Jagganarine");
        Plumber3.add("Harbegna");

        final List<String> Plumber4 = new ArrayList<String>();
        Plumber4.add("Efrem Gebroynas");
        Plumber4.add("Berekti Mirach");
        Plumber4.add("Betty Teklehnam");
        Plumber4.add("Tedros Asfaha");

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
                    ArrayAdapter<String> adapterElec = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Plumber1);
                    adapterElec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec);
                }
                if(position==2){
                    ArrayAdapter<String> adapterElec2 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Plumber2);
                    adapterElec2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec2);
                }
                if(position==3){
                    ArrayAdapter<String> adapterElec3 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Plumber3);
                    adapterElec3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_SP.setAdapter(adapterElec3);
                }
                if(position==4){
                    ArrayAdapter<String> adapterElec4 = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, Plumber4);
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
        String title=bundle.getString("title5");
        int img= bundle.getInt("img5");

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
                    Toast.makeText(Five.this, "Selection is must ! ", Toast.LENGTH_SHORT).show();
                }
                else{
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("ServiceFiveCategory");

                String category_selected = spinner_category.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(), Checkout.class);
                i.putExtra("service",category_selected);
                startActivity(i);



            }}
        });
    }
}
