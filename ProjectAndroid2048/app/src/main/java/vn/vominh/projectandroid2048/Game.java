package vn.vominh.projectandroid2048;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Game extends Activity {

    private Board board;
    private TextView[][] tvBoard;
    private final int[][] tvIds = {{R.id.tv00, R.id.tv01, R.id.tv02, R.id.tv03},
            {R.id.tv10, R.id.tv11, R.id.tv12, R.id.tv13},
            {R.id.tv20, R.id.tv21, R.id.tv22, R.id.tv23},
            {R.id.tv30, R.id.tv31, R.id.tv32, R.id.tv33}}; // Mảng chứa các ID của TextView tương ứng với mỗi ô trên bảng
    private TextView score;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RelativeLayout rel = findViewById(R.id.completeLayout);

        board = new Board(); // Tạo một đối tượng mới của lớp Board, đại diện cho bảng trò chơi
        score = findViewById(R.id.textResult); //  Liên kết TextView để hiển thị điểm số
        tvBoard = new TextView[4][4];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                tvBoard[i][j] = findViewById(tvIds[i][j]); // Liên kết mỗi ô trên bảng với TextView tương ứng

        board.generateNewRandom();
        board.generateNewRandom();
        showBoard(); // Cập nhật hiển thị của bảng và điểm số trên giao diện người dùng
        rel.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                board.topSwipe();
                showBoard();
                checkGameStatus();
            }

            public void onSwipeRight() {
                board.rightSwipe();
                showBoard();
                checkGameStatus();
            }

            public void onSwipeLeft() {
                board.leftSwipe();
                showBoard();
                checkGameStatus();
            }

            public void onSwipeBottom() {
                board.bottomSwipe();
                showBoard();
                checkGameStatus();
            }
        });
    }

     // board.getValue(i, j): Lấy giá trị của ô tại vị trí (i, j) trên bảng.
     // tvBoard[i][j].getText().toString(): Lấy giá trị hiện tại của TextView tương ứng với ô (i, j) dưới dạng chuỗi.
     // Nếu giá trị mới của ô khác với giá trị hiện tại của TextView, cập nhật TextView với giá trị mới.
     // score.setText("Score: "+board.getScore()): Cập nhật điểm số trên giao diện
    @SuppressLint("SetTextI18n")
    public void showBoard() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (board.getValue(i, j).compareTo(tvBoard[i][j].getText().toString()) != 0)
                    tvBoard[i][j].setText(board.getValue(i, j));
        score.setText("Score: "+board.getScore());
    }

    // Phương thức được gọi khi người chơi kết thúc trò chơi. Chuyển sang MainActivity để quay lại màn hình chính.
    public void Finish(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // Phương thức để kiểm tra xem game đã kết thúc chưa
    private void checkGameStatus() {
        // Kiểm tra điều kiện thua
        boolean isGameOver = isGameOver();

        // Kiểm tra điều kiện thắng
        boolean isGameWon = isGameWon();

        // Hiển thị thông báo tương ứng
        if (isGameOver || isGameWon) {
            showGameOverDialog(isGameWon);
        }
    }

    // Phương thức để hiển thị thông báo khi game kết thúc
    private void showGameOverDialog(boolean isGameWon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(isGameWon ? "Congratulations!" : "Game Over!");
        builder.setMessage(isGameWon ? ("You won! Your score is " + board.getScore())
                            : "Try harder next time. Your score is "+ board.getScore());
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Phương thức để kiểm tra điều kiện thua
    private boolean isGameOver() {
        if(isGameWon()){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(tvBoard[i][j].getText().toString()) == 0 ||
                        (i > 0 && Integer.parseInt(tvBoard[i][j].getText().toString()) == Integer.parseInt(tvBoard[i - 1][j].getText().toString())) ||
                        (i < 4 - 1 && Integer.parseInt(tvBoard[i][j].getText().toString()) == Integer.parseInt(tvBoard[i + 1][j].getText().toString())) ||
                        (j > 0 && Integer.parseInt(tvBoard[i][j].getText().toString()) == Integer.parseInt(tvBoard[i][j - 1].getText().toString())) ||
                        (j < 4 - 1 && Integer.parseInt(tvBoard[i][j].getText().toString()) == Integer.parseInt(tvBoard[i][j + 1].getText().toString()))) {
                    return false;
                }
            }
        }
        return true;
    }

    // Phương thức để kiểm tra điều kiện thắng
    private boolean isGameWon() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(tvBoard[i][j].getText().toString()) == 2048) {
                    return true;
                }
            }
        }
        return false;
    }
}
