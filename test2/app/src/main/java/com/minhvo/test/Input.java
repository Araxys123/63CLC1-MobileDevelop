package com.minhvo.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
    }
    public void QuayVe(View v){
        EditText edName=(EditText)findViewById(R.id.inputName);
        EditText edBirth=(EditText)findViewById(R.id.inputBirth);
        String name=edName.getText().toString();
        int birth=Integer.parseInt(edBirth.getText().toString());
        Intent iKQ=new Intent();
        iKQ.putExtra("HT",name);
        iKQ.putExtra("NS",birth);
        setResult(RESULT_OK,iKQ);
        finish();
    }
}