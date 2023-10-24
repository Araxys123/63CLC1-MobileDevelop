package com.minhvo.passingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
// --- get the intent sent from MainActivity
        Intent intentReceived = getIntent();
//---get the data passed in using getStringExtra()---
        String name1= intentReceived.getStringExtra("name1");
//---get the data passed in using getIntExtra()---
        int age1 = intentReceived.getIntExtra("age1", 0);
//---get the Bundle object passed in---
        Bundle bundle = intentReceived.getExtras();
//---get the data using the getString()---
        String name2 = bundle.getString("name2");
//---get the data using the getInt() method---
        int age2 = bundle.getInt("age2");
        String messageToast = name1 + ": " +String.valueOf(age1) + "\n" +
                name2 + ": " +String.valueOf(age2);
        Toast.makeText(this,messageToast, Toast.LENGTH_SHORT).show();
    }
}