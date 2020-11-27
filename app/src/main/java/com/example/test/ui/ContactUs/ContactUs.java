package com.example.test.ui.ContactUs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.R;
import com.example.test.ui.Home.HomeModel;

public class ContactUs extends Fragment {


    EditText fullname,email,contact,message;
    Button send;
    public String mailmsg;

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

                mailmsg= message.getText().toString() +"\n Contact Number: " + contact.getText().toString() + "\n Email Id:"+ email.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:Supadhyay3131@conestogac.on.ca"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Contact Us Inquiry");
                intent.putExtra(Intent.EXTRA_TEXT,mailmsg);
                startActivity(intent);
            }
        });
        return root;
    }
}