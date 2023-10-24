package com.minhvo.usingintent;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int iterationCount = 0;
    private TextView iterationCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iterationCountTextView = findViewById(R.id.iterationCountTextView);
        updateIterationCountView();
    }

    private void updateIterationCountView() {
        iterationCountTextView.setText("Iteration Count: " + iterationCount);
    }

    public void onClick(View view) {
        // Start the SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Retrieve the iteration count from SecondActivity
            int countFromSecondActivity = data.getIntExtra("iterationCount", 0);

            // Update the main activity's iteration count and UI
            iterationCount += countFromSecondActivity;
            updateIterationCountView();
        }
    }
}


