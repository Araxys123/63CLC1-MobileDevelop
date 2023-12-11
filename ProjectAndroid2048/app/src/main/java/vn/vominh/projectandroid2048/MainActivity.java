package vn.vominh.projectandroid2048;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liên kết các thành phần giao diện
        btnLogOut = findViewById(R.id.btnLogout);

        // Khởi tạo đối tượng FirebaseAuth để quản lý đăng nhập
        mAuth = FirebaseAuth.getInstance();

        // Thiết lập sự kiện lắng nghe cho nút Log Out
        btnLogOut.setOnClickListener(view -> {
            // Đăng xuất người dùng hiện tại
            mAuth.signOut();
            // Chuyển sang màn hình đăng nhập (SignIn)
            startActivity(new Intent(MainActivity.this, SignIn.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Kiểm tra xem người dùng có đang đăng nhập hay không
        FirebaseUser user = mAuth.getCurrentUser();

        // Nếu người dùng không đăng nhập, chuyển sang màn hình đăng nhập (SignIn)
        if (user == null) {
            startActivity(new Intent(MainActivity.this, SignIn.class));
        }
    }

    // Phương thức được gọi khi người dùng bắt đầu trò chơi
    public void Start(View v) {
        // Tạo Intent để chuyển sang màn hình trò chơi (Game)
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
