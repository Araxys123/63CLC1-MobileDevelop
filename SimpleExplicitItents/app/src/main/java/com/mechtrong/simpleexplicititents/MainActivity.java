package com.minhvo.simpleexplicititents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chuyenManHinh(View v){
        Intent iSubScreen = new Intent(this,SubActivity.class);

        startActivity(iSubScreen);
    }

}