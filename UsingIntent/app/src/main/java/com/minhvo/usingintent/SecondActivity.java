package com.minhvo.usingintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to go back to the main activity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                // Pass data (iteration count) back to the main activity
                intent.putExtra("iterationCount", 1);

                // Set the result and finish the current activity
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
