package com.minhvo.explicitintents2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void manHinhInput(View v)
    {
        Intent iSubScreen= new Intent(this, InputActivity.class);
        startActivityForResult(iSubScreen,8000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==8000)
            if(resultCode==RESULT_OK)
            {
                String nameNhanDuoc = data.getStringExtra("HT");
                int yearNhanDuoc = data.getIntExtra("NS", 2020);

                TextView tvHT = (TextView)findViewById(R.id.tvName);
                TextView tvNam = (TextView)findViewById(R.id.tvYear);

                tvHT.setText(nameNhanDuoc);
                tvNam.setText(String.valueOf(yearNhanDuoc));
            }
        else
                Toast.makeText(this,"Trả về thất bại", Toast.LENGTH_SHORT);
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}