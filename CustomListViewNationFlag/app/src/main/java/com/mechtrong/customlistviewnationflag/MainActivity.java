package com.minhvo.CustomListViewNationFlag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        dsQG = new ArrayList<Country>();
        Country qg1 = new Country("Vietnam", "vn", 999999);
        Country qg2 = new Country("United States", "us", 999999);
        Country qg3 = new Country("Russia", "rus", 999999);
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);

        ListView lvQG = findViewById(R.id.list_item);

        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG,this);
        lvQG.setAdapter(adapter);
    }
}