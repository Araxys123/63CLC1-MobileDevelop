package vn.vominh.thigk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToCau1 = findViewById(R.id.btnCau1);
        Button goToCau2 = findViewById(R.id.btnCau2);
        Button goToCau3 = findViewById(R.id.btnCau3);
        Button goToCau4 = findViewById(R.id.btnCau4);

        goToCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau1.class);
                startActivity(intent);
            }
        });
        goToCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau2.class);
                startActivity(intent);
            }
        });
        goToCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau3.class);
                startActivity(intent);
            }
        });
        goToCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau4.class);
                startActivity(intent);
            }
        });
    }
}
