package com.example.test.ui.checkout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.ui.ServiceOne.ServiceOneHelper;
import com.example.test.ui.Services.PayPalConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int PAYPAL_REQCODE=12;

    private static PayPalConfiguration payPalConfiguration = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(PayPalConfig.PAYPAL_CLIENT_ID);


    EditText editTextName, editTextNumber,editTextEmail,editTextDate;
    Spinner spinner;
    Button btnFinal;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent= new Intent(getApplicationContext(),PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        startService(intent);

        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDate = findViewById(R.id.editTextDate);
        btnFinal = findViewById(R.id.btnFinal);



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

        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Booking");

                final String name = editTextName.getText().toString();
                final String number = editTextNumber.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String date = editTextDate.getText().toString();

                if(isNullOrBlank(name)){
                    editTextName.setError("Name Required !");
                }
                if(isNullOrBlank(email)){
                    editTextEmail.setError("Email Required !");
                }
                if(isNullOrBlank(number)){
                    editTextNumber.setError("Phone number Required !");
                }
                if(isNullOrBlank(date)){
                    editTextDate.setError("Booking Date Required !");
                }
                if(!emailPatterncheck(email)){
                    editTextEmail.setError("Invalid Email, Retry!");
                }


                else{

                    Bundle bundle = getIntent().getExtras();
                    String service=bundle.getString("service");
                    paypal();
                    CheckouHelper checkouHelper = new CheckouHelper(name,number,email,date,service);
                    databaseReference.child(number).setValue(checkouHelper);

                }





            }

            private void paypal() {
                PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(100),"USD","Genie",PayPalPayment.PAYMENT_INTENT_SALE);

                Intent intent= new Intent(getApplicationContext(), PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,payPalConfiguration);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);

                startActivityForResult(intent,PAYPAL_REQCODE);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==PAYPAL_REQCODE){

                if(resultCode== Activity.RESULT_OK){
                    Toast.makeText(getApplicationContext(),"payment successful",Toast.LENGTH_LONG);
                }
                else{Toast.makeText(getApplicationContext(),"payment declined",Toast.LENGTH_LONG);}
            }

    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(getApplicationContext(),PayPalService.class));
        super.onDestroy();
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
