package ex1;

import java.sql.*;

public class DoctorLogin {

    public static boolean login(Connection conn, String doctorCode, String password) {
        try {
            /*
            Phần 1:
              PreparedStatement được xem như một tấm khiên chống SQL Injection vì nó không cho phép nối chuỗi trực tiếp vào câu lệnh SQL.
              Khi dùng PreparedStatement, câu SQL được gửi lên database và được biên dịch trước với các dấu hỏi ? đóng vai trò chờ dữ liệu.

              Lúc này database chỉ biên dịch phần khung của câu lệnh, còn các giá trị truyền vào sau đó
              luôn được coi là dữ liệu chứ không bao giờ được coi như một đoạn mã SQL.
              -> Dù người dùng nhập những chuỗi nguy hiểm như ' OR '1'='1,
              database cũng chỉ hiểu đó là một giá trị thông thường, không thể thay đổi cấu trúc câu lệnh SQL.
              -> PreparedStatement gần như loại bỏ hoàn toàn khả năng bị SQL Injection.
            */

            // Phần 2
            String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Gán tham số vào dấu ?
            pstmt.setString(1, doctorCode);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            // Nếu có dữ liệu -> đăng nhập thành công
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}