package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button btnSignup, btnLogin;
    EditText etName, etEmailid, etPassword, etConfirmpassword, etPhonenumber;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.etName);
        etEmailid = findViewById(R.id.etEmailid);
        etPassword = findViewById(R.id.etPassword);
        etConfirmpassword = findViewById(R.id.etConfirmpassword);
        etPhonenumber = findViewById(R.id.etPhonenumber);

        //creating object of Database helper class to save data in database db
        db = new DatabaseHelper(this);
        //Button on click listener
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

        //Button on click listener
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = etName.getText().toString();
                String em = etEmailid.getText().toString();
                String pass = etPassword.getText().toString();
                String cpass = etConfirmpassword.getText().toString();
                String pho = etPhonenumber.getText().toString();

                if (!emailcheck(em)) {
                    etEmailid.setError("Invalid email");
                }
                if (!passwordCheck(pass)) {
                    etPassword.setError("Invalid password");
                }
                if (!passwordCheck(cpass)) {
                    etConfirmpassword.setError("Invalid password");
                }
                if (!pass.equals(cpass)) {
                    etPassword.setError("Passwords donot match");
                    etConfirmpassword.setError("Passwords donot match");
                }
                if (!phoneCheck(pho)) {
                    etPhonenumber.setError("Cannot be less than 10 Numbers");
                }

                if (isNullOrBlank(n) || isNullOrBlank(em) || isNullOrBlank(pass) || isNullOrBlank(cpass) || isNullOrBlank(pho)) {
                    Toast.makeText(Signup.this, "No field should be empty", Toast.LENGTH_SHORT).show();
                }
                if (emailcheck(em) && passwordCheck(pass) && passwordCheck(cpass) && pass.equals(cpass) && phoneCheck(pho)) {
                    if (db.checkAlreadyExist(em)) {

                        if (db.insertdata(n, em, pass, pho)) {
                            Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Signup.this, "Cant Register Successfully", Toast.LENGTH_SHORT).show();
                        }

                        final ProgressDialog progressDialog = new ProgressDialog(Signup.this,
                                R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("Creating Account...");
                        progressDialog.show();
                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        SuccessfulSignup();
                                        progressDialog.dismiss();
                                    }
                                }, 4500);
                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                    }
                    else{
                        etEmailid.setError("Account already exists! ");
                    }
                }


            }
        });
    }

    public void SuccessfulSignup() {
        btnSignup.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    private boolean emailcheck(String email) {
        if (email == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    public void onBackPressed() {

        new AlertDialog.Builder(getApplicationContext()).setIcon(android.R.drawable.ic_dialog_alert).setTitle("EXIT").setMessage("Want to Exit ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        }).setNegativeButton("No", null).show();
    }

    private boolean passwordCheck(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }

    boolean isNullOrBlank(String s) {
        return (s == null || s.trim().equals(""));
    }

    private boolean phoneCheck(String num) {
        if (num.length() == 10) {
            return true;
        } else {
            return false;
        }
    }


    }


