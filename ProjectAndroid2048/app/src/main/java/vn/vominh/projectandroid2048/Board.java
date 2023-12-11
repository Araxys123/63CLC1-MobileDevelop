package vn.vominh.projectandroid2048;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final Square[] board; // Mảng chứa các ô vuông trên bảng trò chơi
    private ArrayList<Square> listSquare; // Danh sách chứa các ô trống trên bảng
    private int score; // Điểm số

    public Board() { // Tạo ra một bảng mới, ban đầu tất cả các ô có giá trị là 0 và được thêm vào danh sách listSquare
        board = new Square[16];
        listSquare = new ArrayList<>();
        score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i * 4 + j] = new Square(i, j, 0); // Tạo ra một đối tượng Square mới với tọa độ (i, j) và giá trị ban đầu là 0
                listSquare.add(board[i * 4 + j]);  // Thêm đối tượng Square vừa tạo vào ArrayList listSquare
            }
        }
    }

    public void generateNewRandom() { // Tạo một ô mới với giá trị là 2 hoặc 4 ở một ô trống ngẫu nhiên trên bảng
        Random randomGenerator = new Random();
        int randomValue = randomGenerator.nextInt(10); // Random một số từ 0 đến 9 (bao gồm 0 và 9)
        int newValue = (randomValue == 9) ? 4 : 2;  // Nếu số ngẫu nhiên là từ 0 đến 8 thì gán giá trị 2
        // Nếu số ngẫu nhiên là 9, gán giá trị 4
        int randomIndex = randomGenerator.nextInt(listSquare.size()); // Random một số để chọn ô trống
        listSquare.get(randomIndex).setValue(newValue); // Lấy ô trống từ danh sách và gán giá trị mới
        listSquare.remove(randomIndex); // Loại bỏ ô trống khỏi danh sách
    }

    public String getValue(int row, int column) {
        // Lấy giá trị của ô tại vị trí (row, column) và chuyển thành chuỗi
        String value = Integer.toString(board[row * 4 + column].getValue());

        // Nếu giá trị là 0, trả về chuỗi trống
        if (value.compareTo("0") == 0)
            return "";
        return value;
    }

    public boolean moveSquare(Square start, Square end) {
        // Biến moved dùng để theo dõi xem có di chuyển nào xảy ra hay không
        boolean moved = false;

        // Nếu giá trị của ô start không phải là 0 và giá trị của ô end là 0
        if (start.getValue() != 0 && end.getValue() == 0) {
            // Di chuyển giá trị từ ô start đến ô end
            end.setValue(start.getValue());
            start.setValue(0);

            // Cập nhật danh sách ô (listSquare)
            listSquare.add(start);
            listSquare.remove(end);

            // Đã có di chuyển
            moved = true;
        }
        // Nếu giá trị của ô start không phải là 0, giá trị của ô start bằng giá trị của ô end
        // Cả hai ô đều có thể di chuyển và được đánh dấu là "có thể di chuyển" (isCanMove() trả về true)
        else if (start.getValue() != 0 && start.getValue() == end.getValue() && start.isCanMove() && end.isCanMove()) {
            // Cộng điểm với tổng giá trị của ô start và end
            score += start.getValue() + end.getValue();

            // Gộp giá trị của ô start và end vào ô end
            end.setValue(start.getValue() + end.getValue());
            start.setValue(0);

            // Cập nhật danh sách ô (listSquare)
            listSquare.add(start);

            // Đánh dấu ô end là không thể di chuyển nữa
            end.setCanMove(false);

            // Đã có di chuyển
            moved = true;
        }

        // Trả về giá trị moved, là true nếu có di chuyển và false nếu không có di chuyển
        return moved;
    }


    public int moveRow(int rowStart, boolean moveUp) {
        // Số ô đã di chuyển
        int moved = 0;

        // Nếu di chuyển lên
        if (moveUp) {
            for (int i = 0; i < 4; i++)
                // Di chuyển ô từ vị trí hiện tại lên trên
                if (moveSquare(board[rowStart * 4 + i], board[rowStart * 4 - 4 + i]))
                    moved++;
        }
        // Ngược lại, nếu di chuyển xuống
        else {
            for (int i = 0; i < 4; i++)
                // Di chuyển ô từ vị trí hiện tại xuống dưới
                if (moveSquare(board[rowStart * 4 + i], board[rowStart * 4 + 4 + i]))
                    moved++;
        }

        // Trả về số ô đã di chuyển
        return moved;
    }

    public int moveColumn(int columnStart, boolean moveRight) {
        // Số ô đã di chuyển
        int moved = 0;

        // Nếu di chuyển sang phải
        if (moveRight) {
            for (int i = 0; i < 4; i++)
                // Di chuyển ô từ vị trí hiện tại sang phải
                if (moveSquare(board[i * 4 + columnStart], board[i * 4 + columnStart + 1]))
                    moved++;
        }
        // Ngược lại, nếu di chuyển sang trái
        else {
            for (int i = 0; i < 4; i++)
                // Di chuyển ô từ vị trí hiện tại sang trái
                if (moveSquare(board[i * 4 + columnStart], board[i * 4 + columnStart - 1]))
                    moved++;
        }

        // Trả về số ô đã di chuyển
        return moved;
    }


    public int moveBlockUp() {
        // Số ô đã di chuyển
        int moved = 0;

        // Lặp qua các cột (column) trừ cột cuối cùng
        for (int j = 0; j < 3; j++)
            // Lặp qua các dòng (row) từ dòng thứ 2 đến dòng cuối cùng
            for (int i = 1; i < 4; i++)
                // Di chuyển dòng lên trên bằng cách sử dụng moveRow
                moved += moveRow(i, true);

        // Trả về số ô đã di chuyển
        return moved;
    }

    public int moveBlockDown() {
        // Số ô đã di chuyển
        int moved = 0;

        // Lặp qua các cột (column) trừ cột cuối cùng
        for (int j = 0; j < 3; j++)
            // Lặp qua các dòng (row) từ dòng thứ 3 xuống dòng đầu tiên
            for (int i = 2; i >= 0; i--)
                // Di chuyển dòng xuống dưới bằng cách sử dụng moveRow
                moved += moveRow(i, false);

        // Trả về số ô đã di chuyển
        return moved;
    }

    public int moveBlockRight() {
        // Số ô đã di chuyển
        int moved = 0;

        // Lặp qua các dòng (row) trừ dòng cuối cùng
        for (int j = 0; j < 3; j++)
            // Lặp qua các cột (column) từ cột thứ 3 xuống cột đầu tiên
            for (int i = 2; i >= 0; i--)
                // Di chuyển cột sang phải bằng cách sử dụng moveColumn
                moved += moveColumn(i, true);

        // Trả về số ô đã di chuyển
        return moved;
    }

    public int moveBlockLeft() {
        // Số ô đã di chuyển
        int moved = 0;

        // Lặp qua các dòng (row) trừ dòng cuối cùng
        for (int j = 0; j < 3; j++)
            // Lặp qua các cột (column) từ cột thứ 2 đến cột cuối cùng
            for (int i = 1; i < 4; i++)
                // Di chuyển cột sang trái bằng cách sử dụng moveColumn
                moved += moveColumn(i, false);

        // Trả về số ô đã di chuyển
        return moved;
    }


    public void setSquaresToCanMove() {
        // Đặt tất cả các ô trên bảng có thể di chuyển (canMove) về true
        for (int i = 0; i < 16; i++)
            board[i].setCanMove(true);
    }

    public void topSwipe() {
        // Di chuyển các ô lên trên, nếu có ô nào di chuyển được thì tạo ô mới và đặt lại các ô có thể di chuyển
        if (moveBlockUp() > 0)
            generateNewRandom();
        setSquaresToCanMove();
    }

    public void bottomSwipe() {
        if (moveBlockDown() > 0)
            generateNewRandom();
        setSquaresToCanMove();
    }

    public void leftSwipe() {
        if (moveBlockLeft() > 0)
            generateNewRandom();
        setSquaresToCanMove();
    }

    public void rightSwipe() {
        if (moveBlockRight() > 0)
            generateNewRandom();
        setSquaresToCanMove();
    }

    public String getScore() {
        // Trả về điểm số dưới dạng chuỗi
        return Integer.toString(score);
    }
}
