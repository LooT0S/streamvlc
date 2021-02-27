package com.ziuman.streamvlc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username = null;
    private EditText password = null;
    private Button bSignin = null;

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.loginusername);
        password = findViewById(R.id.loginpassword);
        bSignin = findViewById(R.id.btnloginsignin);

        db = new DB(this);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT);
                } else {
                    Boolean cheackuserpass  = db.cheackUserNamePassword(user, pass);

                    if (cheackuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Sign in seccessfull", Toast.LENGTH_SHORT).show();
                        Intent iStream = new Intent(getApplicationContext(), StreamVLC.class);
                        startActivity(iStream);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}