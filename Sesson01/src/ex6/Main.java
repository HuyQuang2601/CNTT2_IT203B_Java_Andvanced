package ex6;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void saveToFile() throws IOException {

        System.out.println("Đang lưu dữ liệu vào file...");

        throw new IOException("Không thể ghi file.");
    }

    public static void processUserData() throws IOException {

        System.out.println("Đang xử lý dữ liệu người dùng...");
        saveToFile();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Nhập tên người dùng: ");
            String name = scanner.nextLine();

            User user = new User(name);

            System.out.print("Nhập tuổi: ");
            String ageInput = scanner.nextLine();

            int age = Integer.parseInt(ageInput);

            user.setAge(age);

            user.printUserInfo();

            System.out.print("Nhập tổng số người: ");
            int total = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số nhóm: ");
            int groups = Integer.parseInt(scanner.nextLine());

            int result = total / groups;

            System.out.println("Mỗi nhóm có: " + result + " người");

            processUserData();

        }
        catch (NumberFormatException e) {

            Logger.logError("Dữ liệu nhập không phải số hợp lệ.");

        }
        catch (ArithmeticException e) {

            Logger.logError("Không thể chia cho 0.");

        }
        catch (InvalidAgeException e) {

            Logger.logError(e.getMessage());

        }
        catch (IOException e) {

            Logger.logError("Lỗi ghi file: " + e.getMessage());

        }
        finally {

            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên...");
        }

        System.out.println("Chương trình vẫn tiếp tục chạy.");
    }
}