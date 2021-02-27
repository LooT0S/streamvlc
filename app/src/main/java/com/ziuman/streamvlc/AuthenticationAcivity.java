package com.ziuman.streamvlc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenticationAcivity extends AppCompatActivity {

    private EditText username = null;
    private EditText password = null;
    private EditText repassword = null;
    private Button bSignup = null;
    private Button bSignin = null;

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_acivity);

        Intent iLogo =  new Intent(this, MainActivity.class);
        startActivity(iLogo);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        bSignin = findViewById(R.id.btnsignin);
        bSignup = findViewById(R.id.btnsignup);

        db = new DB(this);

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(AuthenticationAcivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean cheackuser = db.cheackUserName(user);
                        if (cheackuser == false) {
                            Boolean insert = db.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(AuthenticationAcivity.this, "Registered seccessfully", Toast.LENGTH_SHORT).show();
                                Intent iStreamVLS = new Intent(getApplicationContext(), StreamVLC.class);
                                startActivity(iStreamVLS);
                            } else {
                                Toast.makeText(AuthenticationAcivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(AuthenticationAcivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(AuthenticationAcivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(iLogin);
            }
        });
    }
}
