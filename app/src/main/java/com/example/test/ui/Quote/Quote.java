package com.example.test.ui.Quote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.ui.Adapter;

public class Quote extends Fragment {
    public Quote(){}
    RecyclerView recyclerView;
    EditText qname,qemail,qcategory,qdescwork,qexpence;
    Button send;
    public String message;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.quote, container, false);

        qname=root.findViewById(R.id.qname);
        qemail=root.findViewById(R.id.qemail);
        qcategory=root.findViewById(R.id.qcategory);
        qdescwork=root.findViewById(R.id.qdescwork);
        qexpence=root.findViewById(R.id.qexpence);
        send=root.findViewById(R.id.send);




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message= "Name: "+ qname.getText().toString()+ "\n Email: "
                        + qemail.getText().toString()+ "\n Category for quotation:"+ qcategory.getText().toString()+
                        "\n Description: "+ qdescwork.getText().toString()+ "\n Expected expense:"+ qexpence.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:Supadhyay3131@conestogac.on.ca"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Inquiry for quotation");
                intent.putExtra(Intent.EXTRA_TEXT,message);
                startActivity(intent);
            }
        });





        return root;
    }

}
