package btth;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;encrypt=false";
    private static final String USER = "root";
    private static final String PASS = "260106huy";

    public static void main(String[] args) {

        String senderId = "ACC01";
        String receiverId = "ACC02";
        double amount = 1000;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            conn.setAutoCommit(false);

            if (!hasSufficientBalance(conn, senderId, amount)) {
                System.out.println("Không đủ số dư để thực hiện giao dịch!");
                conn.rollback();
                return;
            }

            try (CallableStatement cs1 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}")) {
                cs1.setString(1, senderId);
                cs1.setDouble(2, -amount);
                cs1.execute();
            }

            try (CallableStatement cs2 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}")) {
                cs2.setString(1, receiverId);
                cs2.setDouble(2, amount);
                cs2.execute();
            }

            conn.commit();
            System.out.println("Chuyển khoản thành công!");

            printFinalBalances(conn, senderId, receiverId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasSufficientBalance(Connection conn, String accountId, double amount)
            throws SQLException {

        String sql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Không tìm thấy tài khoản người gửi!");
                return false;
            }

            double balance = rs.getDouble("Balance");
            return balance >= amount;
        }
    }

    private static void printFinalBalances(Connection conn, String acc1, String acc2)
            throws SQLException {

        String sql = "SELECT AccountId, FullName, Balance FROM Accounts WHERE AccountId IN (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, acc1);
            ps.setString(2, acc2);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== KẾT QUẢ SAU GIAO DỊCH =====");
            System.out.printf("%-10s %-20s %-10s\n", "ID", "Name", "Balance");

            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10.2f\n",
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance"));
            }
        }
    }
}

