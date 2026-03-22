package ex2;

// - Đoạn mã ban đầu dùng if (rs.next()) => chỉ kiểm tra được 1 lần duy nhất.
// - Sau khi gọi rs.next(), con trỏ của ResultSet di chuyển từ vị trí "trước dòng đầu tiên"
//   sang dòng đầu tiên. Nếu dùng if, ta chỉ xử lý đúng 1 dòng rồi kết thúc.
// - Nếu bảng trống, rs.next() trả về false => không in gì, dễ gây lỗi logic.
//
//  Giải pháp:
// - Dùng vòng lặp while(rs.next()) để duyệt qua toàn bộ các dòng trong ResultSet.
// - Mỗi lần gọi rs.next(), con trỏ sẽ di chuyển sang dòng kế tiếp (nếu có).
// - Nhờ đó, ta có thể in ra toàn bộ danh sách thuốc trong kho.

// PHẦN 2 - THỰC THI


import java.sql.*;

public class Ex2 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db", "root", "260106huy");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT medicine_name, stock FROM Pharmacy");

            boolean isEmpty = true;

            while (rs.next()) {
                isEmpty = false;

                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Số lượng tồn: " + stock);
            }

            if (isEmpty) {
                System.out.println("Danh mục thuốc đang trống.");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}