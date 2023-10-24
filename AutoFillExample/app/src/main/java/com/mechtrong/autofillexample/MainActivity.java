package com.minhvo.autofillexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView auTV;
    ArrayList<String >COUNTRIES = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        COUNTRIES.add("Vietnam");
        COUNTRIES.add("England");
        COUNTRIES.add("Australia");
        COUNTRIES.add("Albania");
        COUNTRIES.add("USA");

        ArrayAdapter<String> adapterCountries = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        auTV.setAdapter(adapterCountries);

    }

    void getWidget(){
        auTV = findViewById(R.id.autoFillBar);
    }
}