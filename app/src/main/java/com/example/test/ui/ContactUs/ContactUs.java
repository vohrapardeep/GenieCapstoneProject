package com.example.test.ui.ContactUs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.test.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUs extends Fragment {

    public ContactUs(){}


    EditText fullname, email, contact, message;
    Button send;

    FirebaseDatabase rootToDatabase;
    DatabaseReference reference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_contact_us, container, false);



        fullname=root.findViewById(R.id.fullname);
        email=root.findViewById(R.id.emailid);
        contact=root.findViewById(R.id.contactno);
        message=root.findViewById(R.id.message);

        send=root.findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootToDatabase= FirebaseDatabase.getInstance();
                reference= rootToDatabase.getReference("ContactUs");

                String name = fullname.getText().toString();
                String email1 = email.getText().toString();
                String contact1 = contact.getText().toString();
                String message1 = message.getText().toString();

                if(isNullOrBlank(name))
                {
                    fullname.setError("Name Required !");
                }
                if(isNullOrBlank(email1))
                {
                    email.setError("Email Required!");
                }
                if(isNullOrBlank(contact1))
                {
                    contact.setError("Contact Required!");
                }
                if(isNullOrBlank(message1))
                {
                    message.setError("Enter Your Query!");
                }
                if(!emailPatterncheck(email1))
                {
                    email.setError("Invalid Email ID!");
                }
                else {

                    ContactHelper helper1 = new ContactHelper(name, email1, contact1, message1);
                    reference.child(contact1).setValue(helper1);

                    Toast.makeText(getActivity(), "Thanks, We will get back to you shortly!", Toast.LENGTH_SHORT).show();
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
}