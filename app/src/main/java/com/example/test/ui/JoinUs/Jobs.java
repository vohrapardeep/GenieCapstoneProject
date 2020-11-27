package com.example.test.ui.JoinUs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Jobs extends Fragment {
    public Jobs() {
    }

    EditText personName, emailaddress, phone, etResume;
    Spinner spinner;
    Button btnsubmit, btnUpload;
    TextView message;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.joinus, container, false);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("resume");

        personName = root.findViewById(R.id.personName);
        emailaddress = root.findViewById(R.id.emailaddress);
        phone = root.findViewById(R.id.phone);
        etResume = root.findViewById(R.id.etResume);
        spinner = root.findViewById(R.id.spinner);
        btnsubmit = root.findViewById(R.id.btnsubmit);
        btnUpload = root.findViewById(R.id.btnUpload);
        message = root.findViewById(R.id.message);

        List<String> list = new ArrayList<String>();
        list.add("Choose Job");
        list.add("Electrician");
        list.add("Plumber");
        list.add("Makeup artist");
        list.add("Roofing");
        list.add("Construction");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectResume();

            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("your job application has been sent, You will be contacted shortly!");
                personName.setText("");
                emailaddress.setText("");
                phone.setText("");

            }
        });
        return root;}
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            uploadPdf(data.getData());
        }
    }

    private void uploadPdf(Uri data) {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Uploading your file....");
        progressDialog.show();
        StorageReference reference = storageReference.child("resume/" + System.currentTimeMillis()
                + ".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete()) ;
                        Uri url = uri.getResult();

                        helperUpload helperUpload = new helperUpload(etResume.getText().toString(), url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(helperUpload);
                        Toast.makeText(getContext(), "File Uploaded Successfully", Toast.LENGTH_LONG);

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {


                double progresspercent = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("uploaded:" + (int) progresspercent + "%");

            }
        });

    }


    private void selectResume() {
        Intent i = new Intent();
        i.setType("application/pdf");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Resume pdf"), 1);
    }

}





