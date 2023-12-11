package vn.vominh.projectandroid2048;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    // Constructor nhận một Context để khởi tạo GestureDetector
    public OnSwipeTouchListener(Context ctx){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    // Lớp GestureListener xử lý việc nhận diện cử chỉ chạm
    private final class GestureListener extends SimpleOnGestureListener {

        // Các hằng số cho ngưỡng và tốc độ của cử chỉ vuốt
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        // onDown luôn trả về true để tiêu thụ sự kiện chạm
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // onFling được gọi khi phát hiện cử chỉ vuốt
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                // Tính toán sự chênh lệch giữa các tọa độ X và Y
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();

                // Xác định xem cử chỉ vuốt là ngang hay dọc
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    // Kiểm tra xem cử chỉ vuốt ngang có đáp ứng điều kiện ngưỡng và tốc độ không
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        // Kích hoạt onSwipeRight hoặc onSwipeLeft dựa trên hướng cử chỉ vuốt
                        if (diffX > 0) {
                            onSwipeRight(); // Vuốt sang phải
                        } else {
                            onSwipeLeft(); // Vuốt sang trái
                        }
                    }
                } else {
                    // Kiểm tra xem cử chỉ vuốt dọc có đáp ứng điều kiện ngưỡng và tốc độ không
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        // Kích hoạt onSwipeBottom hoặc onSwipeTop dựa trên hướng cử chỉ vuốt
                        if (diffY > 0) {
                            onSwipeBottom(); // Vuốt xuống
                        } else {
                            onSwipeTop(); // Vuốt lên
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    // Các phương thức trống cho các hướng vuốt, sẽ được ghi đè bởi các lớp con
    public void onSwipeTop() {
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeBottom() {
    }

    // Ghi đè phương thức onTouch để gửi sự kiện chạm đến gestureDetector
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
