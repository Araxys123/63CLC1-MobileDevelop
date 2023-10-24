package com.minhvo.simpleexplicititents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void quayVe(View v)
    {
        Intent iMainScreen = new Intent(this, MainActivity.class);
        startActivity(iMainScreen);
    }
}
