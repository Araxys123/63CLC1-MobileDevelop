package vn.vominh.thigk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class Cau1 extends AppCompatActivity {
        private EditText edtA;
        private EditText edtB;
        private TextView resultTextView;
        private Button calculateButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cau1);

            edtA = findViewById(R.id.edtA);
            edtB = findViewById(R.id.edtB);
            resultTextView = findViewById(R.id.textViewTong);
            calculateButton = findViewById(R.id.btnTong);

            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateSum();
                }
            });
        }
        private void calculateSum() {
            String inputA = edtA.getText().toString();
            String inputB = edtB.getText().toString();
            if (inputA.isEmpty() || inputB.isEmpty()) {
                resultTextView.setText("Vui lòng nhập cả hai giá trị.");
                return;
            }
            try {
                double c = Double.parseDouble(inputA);
                double d = Double.parseDouble(inputB);
                double sum = c + d;
                resultTextView.setText("Tổng: " + sum);
            } catch (NumberFormatException e) {
                resultTextView.setText("Lỗi: Nhập sai định dạng số.");
            }
        }
    }


