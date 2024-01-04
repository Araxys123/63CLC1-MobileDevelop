package vn.vominh.projectandroid2048;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    TextInputEditText etRegEmail;
    TextInputEditText etRegPassword;
    TextView tvLoginHere;
    Button btnRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Khởi tạo các phần tử giao diện người dùng
        TextInputLayout etRegEmailLayout = findViewById(R.id.etRegEmail);
        etRegEmail = (TextInputEditText) etRegEmailLayout.getEditText();

        TextInputLayout etRegPasswordLayout = findViewById(R.id.etRegPassword);
        etRegPassword = (TextInputEditText) etRegPasswordLayout.getEditText();

        tvLoginHere = findViewById(R.id.tvLoginHere);
        btnRegister = findViewById(R.id.btnRegister);

        // Khởi tạo Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Thiết lập lắng nghe sự kiện khi nút Sign Up được nhấn
        btnRegister.setOnClickListener(view -> {
            createUser();
        });

        // Thiết lập lắng nghe sự kiện khi nút Sign in here được nhấn
        tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(SignUp.this, SignIn.class));
        });
    }

    // Phương thức để tạo một tài khoản người dùng mới
    private void createUser() {
        // Lấy email và mật khẩu do người dùng nhập
        String email = etRegEmail.getText().toString();
        String password = etRegPassword.getText().toString();

        // Kiểm tra xem email có trống không
        if (TextUtils.isEmpty(email)) {
            etRegEmail.setError("Email cannot be empty");
            etRegEmail.requestFocus();
        }
        // Kiểm tra xem mật khẩu có trống không
        else if (TextUtils.isEmpty(password)) {
            etRegPassword.setError("Password cannot be empty");
            etRegPassword.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this, SignIn.class));
                    } else {
                        Toast.makeText(SignUp.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

