package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Login extends AppCompatActivity {
    Session session;

    Button btnSignup,btnLogin;
    DatabaseHelper db;
    EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        session = new Session(this);
         etUsername =  findViewById(R.id.etUsername);
         etPassword =  findViewById(R.id.etPassword);
        btnLogin =  findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);


        btnLogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String em = etUsername.getText().toString();
                    String pass = etPassword.getText().toString();


                    if (!emailCheck(em)) {
                        etUsername.setError("Invalid email");
                    }
                    if (!passwordCheck(pass)) {
                        etPassword.setError("Invalid password");
                    }
//
                    if (emailCheck(em) && passwordCheck(pass)) {

                        if (db.checkAlreadyExist(em)) {
                            etUsername.setError("Account does not exists");

                        }
                        if (!db.checkAlreadyExist(em)) {
                            int i = db.Login(em, pass);
                            final ProgressDialog progressDialog = new ProgressDialog(Login.this,
                                    R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                            progressDialog.setIndeterminate(true);
                            progressDialog.setMessage("LOGGING INTO YOUR ACCOUNT...");
                            progressDialog.show();
                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            SuccessfulLogin();
                                            progressDialog.dismiss();
                                        }
                                    }, 4500);

                            if (i == 1) {

                                try {
                                    FileOutputStream fos = openFileOutput("pvg.txt", MODE_PRIVATE);
                                    fos.write(em.getBytes());
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Intent i1 = new Intent(Login.this, MainActivity.class);
                                startActivity(i1);
                            } else {
                                etUsername.setError("Check Username");
                                etPassword.setError("Check Password");
                            }
                        }

                    }
                }

            private boolean emailCheck(String email){
                if(email==null){return false;}
                else{return Patterns.EMAIL_ADDRESS.matcher(email).matches();}
            }


                public void SuccessfulLogin() {
                    btnLogin.setEnabled(true);
                    setResult(RESULT_OK, null);
                    finish();
                }



                private boolean passwordCheck(String pass){
                    if(pass!=null && pass.length()>=6){
                        return true;}
                    else{
                        return false;
                    }
                }




            });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
            }
        });
        if(session.loggedin())
        {
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }



    }

}
