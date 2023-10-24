package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(username.getText().toString().equals("63CLC1") && password.getText().toString().equals("123"))
        {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Username or Password is incorrect!", Toast.LENGTH_LONG).show();
    }
}