package com.minhvo.bt5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    EditText height,weight; int h,w;
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("BMI Calculator");

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        textView = findViewById(R.id.result);
        cal = findViewById(R.id.btn);

        cal.setOnClickListener(this);
    }
    public int getData(EditText editText){
        if(editText.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your height and weight", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    public float calculateBMI(int heightInCm, int weightInKg) {
        float heightInM = heightInCm / 100.0f;
        return weightInKg / (heightInM * heightInM);
    }

    @Override
    public void onClick(View view) {
        h = getData(height);
        w = getData(weight);
        int id = view.getId();

        if (id == R.id.btn) {
            if (h > 0 && w > 0) {
                float bmi = calculateBMI(h, w);
                if (bmi < 20)
                {
                    String state = String.format("YOUR RESULT \n%.1f\nUnderweight",bmi);
                    textView.setText(state);
                } else if(bmi<=25){
                    String state = String.format("YOUR RESULT \n%.1f\nNormal",bmi);
                    textView.setText(state);
                } else if(bmi<=30){
                    String state = String.format("YOUR RESULT \n%.1f\nOverweight",bmi);
                    textView.setText(state);
                } else if(bmi<=40){
                    String state = String.format("YOUR RESULT \n%.1f\nOverweight lv2",bmi);
                    textView.setText(state);
                } else {
                    String state = String.format("YOUR RESULT \n%.1f\nOverweight lv3",bmi);
                    textView.setText(state);
                }
            } else {
                Toast.makeText(this, "Please enter valid height and weight values", Toast.LENGTH_SHORT).show();
                textView.setText("");
            }
        }
    }
}