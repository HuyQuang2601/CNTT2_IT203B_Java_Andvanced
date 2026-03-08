import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh của bạn: ");
            String input = scanner.nextLine();

            int birthYear = Integer.parseInt(input);
            int age = 2026 - birthYear;

            System.out.println("Tuổi của bạn là: " + age);
        }
        catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập năm sinh bằng số. Ví dụ: 2004");
        }

        try {
            System.out.print("Nhập tổng số người dùng: ");
            int tongNguoi = scanner.nextInt();

            System.out.print("Nhập số nhóm muốn chia: ");
            int soNhom = scanner.nextInt();

            int moiNhom = tongNguoi / soNhom;

            System.out.println("Mỗi nhóm có: " + moiNhom + " người");
        }
        catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0!");
        }

        System.out.println("Chương trình vẫn tiếp tục chạy sau khi xử lý lỗi.");

        scanner.close();
        System.out.println("Thực hiện dọn dẹp tài nguyên...");
    }
}