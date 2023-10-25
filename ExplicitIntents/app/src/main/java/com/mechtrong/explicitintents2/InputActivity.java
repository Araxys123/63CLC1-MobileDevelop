package com.minhvo.explicitintents2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void manHinhMain(View v)
    {
        EditText edtHT = (EditText)findViewById(R.id.edtName);
        EditText edtNam = (EditText)findViewById(R.id.edtYear);
        String hoTen = edtHT.getText().toString();
        int namSinh = Integer.parseInt(edtNam.getText().toString());

        Intent iMainScreen= new Intent();

        iMainScreen.putExtra("HT",hoTen);
        iMainScreen.putExtra("NS",namSinh);

        setResult(RESULT_OK, iMainScreen);
        finish();
    }

    public void huyBo(View v)
    {
        Intent iMainScreen= new Intent(this,MainActivity.class);
        startActivity(iMainScreen);
    }
}

