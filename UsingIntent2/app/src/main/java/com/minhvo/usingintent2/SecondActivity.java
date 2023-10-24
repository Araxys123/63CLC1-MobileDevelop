package com.minhvo.usingintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view) {
        Intent intentBacktoMainActivity = new Intent();
//---get the EditText view---
        EditText txt_username = (EditText) findViewById(R.id.edtUsername);
//---put/set the data to pass back, in key,value pair format---
        intentBacktoMainActivity.putExtra("UNAME", txt_username.getText().toString());
        setResult(RESULT_OK, intentBacktoMainActivity);
        finish();
    }
}
