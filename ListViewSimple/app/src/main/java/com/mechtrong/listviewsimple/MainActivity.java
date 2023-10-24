package com.minhvo.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lstNNLT = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWidget();
        lstNNLT.add("C++");
        lstNNLT.add("Java");
        lstNNLT.add("Ruby");
        lstNNLT.add("Python");
        lstNNLT.add("Android Kotlin");
        ArrayAdapter<String> adapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lstNNLT);

        auLV.setAdapter(adapterNNLT);

        auLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mucChon = lstNNLT.get(i).toString();
                String chuoiThongBao = "Select one" + mucChon;
                Toast.makeText(MainActivity.this, chuoiThongBao, Toast.LENGTH_SHORT ).show();
            }
        });
    }
        public void getWidget() {
            auLV = findViewById(R.id.lv);
        }
        ListView auLV;

}