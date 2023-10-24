package com.minhvo.bt6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addButton, minusButton, multiButton, divButton;
    EditText num1, num2;
    TextView textView;
    float n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("BT6");
        addButton = findViewById(R.id.addButton);
        minusButton = findViewById(R.id.minusButton);
        multiButton = findViewById(R.id.multiButton);
        divButton = findViewById(R.id.divButton);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        textView = findViewById(R.id.result);

        addButton.setOnClickListener(this); minusButton.setOnClickListener(this); multiButton.setOnClickListener(this); divButton.setOnClickListener(this);
    }

    public float getNum(EditText editText)
    {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Number(s) are required to be filled", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Float.parseFloat(input);
    }

    @Override
    public void onClick(View view) {
        n1 = getNum(num1);
        n2 = getNum(num2);
        if(num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
            Toast.makeText(this, "Number(s) are required to be filled", Toast.LENGTH_SHORT).show();
            textView.setText("");
        }
        else {
            int id = view.getId();
            if (id == R.id.addButton) {
                textView.setText(n1 + " + " + n2 + " = " + (n1 + n2));
            } else if (id == R.id.minusButton) {
                textView.setText(n1 + " - " + n2 + " = " + (n1 - n2));
            } else if (id == R.id.multiButton) {
                textView.setText(n1 + " x " + n2 + " = " + (n1 * n2));
            } else if (id == R.id.divButton) {
                if (n2 == 0) {
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                textView.setText(n1 + " / " + n2 + " = " + (n1 / n2));
            }
        }
    }
}