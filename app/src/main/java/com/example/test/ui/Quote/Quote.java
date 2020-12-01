package com.example.test.ui.Quote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Quote extends Fragment implements AdapterView.OnItemSelectedListener {
    public Quote(){}

    String[] categories = {"Select Service Category", "Electrician", "Plumber", "Construction Worker", "Fitness Trainer"
    , "Beautician"};

    Spinner qspinner;

    EditText qname,qemail,qcategory,qdescwork,qexpence;
    Button send;

    FirebaseDatabase rootToDatabase;
    DatabaseReference reference;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.quote, container, false);

        qname=root.findViewById(R.id.qname);
        qemail=root.findViewById(R.id.qemail);
        qspinner = root.findViewById(R.id.qspinner);
        qdescwork=root.findViewById(R.id.qdescwork);
        qexpence=root.findViewById(R.id.qexpence);
        send=root.findViewById(R.id.send);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qspinner.setAdapter(adapter);
        qspinner.setOnItemSelectedListener(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootToDatabase= FirebaseDatabase.getInstance();
                reference= rootToDatabase.getReference("Quote");

                // GEt all values from form
                String name = qname.getText().toString();
                String email = qemail.getText().toString();
                String category = qspinner.getSelectedItem().toString();
                String description = qdescwork.getText().toString();
                String expense = qexpence.getText().toString();

                //  VALIDATIONS
            if(isNullOrBlank(name))
            {
                qname.setError("All Fields Required!");
            }
            if(isNullOrBlank(email))
            {
                qemail.setError("Email is neccessary");
            }
            if(isNullOrBlank(category))
            {
                qcategory.setError("Category is neccessary");
            }
            if(isNullOrBlank(description))
            {
                qdescwork.setError("Description is neccessary");
            }
            if(isNullOrBlank(expense))
            {
                qexpence.setError("Expense is neccessary");
            }
            if(!emailPatterncheck(email))
            {
                qemail.setError("Invalid Email ID!");
            }
            if(qspinner.getSelectedItem().equals("Select Service Category"))
            {
                ((TextView)qspinner.getSelectedView()).setError("Category Selection is required!");
            }
            if(!expense.matches("[0-9]+")){qexpence.setError("Enter Number only");}
            else
            {
                QuoteHelper helper= new QuoteHelper(name,email,category,description,expense);
                reference.child(name).setValue(helper);

                Toast.makeText(getActivity(), "Quote Requested Successfully!", Toast.LENGTH_LONG).show();
                qname.setText("");
                qemail.setText("");
                qexpence.setText("");
                qdescwork.setText("");
                qspinner.setSelection(0);


            }


            }
        });





        return root;
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
