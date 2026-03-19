package BTTH2.pattern;

import BTTH2.entity.DigitalProduct;
import BTTH2.entity.PhysicalProduct;
import BTTH2.entity.Product;

import java.util.Scanner;

public class ProductFactory {

    public static Product createProduct(int type, Scanner sc) {
        System.out.print(" ID: ");
        String id = sc.nextLine();

        System.out.print(" Name: ");
        String name = sc.nextLine();

        System.out.print(" Price: ");
        double price = Double.parseDouble(sc.nextLine());

        switch (type) {
            case 1:
                System.out.print(" Weight: ");
                double weight = Double.parseDouble(sc.nextLine());
                return new PhysicalProduct(id, name, price, weight);

            case 2:
                System.out.print(" Size (MB): ");
                double size = Double.parseDouble(sc.nextLine());
                return new DigitalProduct(id, name, price, size);

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return null;
        }
    }
}