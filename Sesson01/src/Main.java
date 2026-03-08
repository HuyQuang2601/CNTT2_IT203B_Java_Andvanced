import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // 1. số nguyên
    public static int inputInt() {
        while (true) {
            try {
                System.out.print("Nhap int: ");
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Vui long nhap lai so nguyen.");
            }
        }
    }

    public static byte inputByte() {
        while (true) {
            try {
                System.out.print("Nhap byte: ");
                return Byte.parseByte(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Nhap lai.");
            }
        }
    }

    public static short inputShort() {
        while (true) {
            try {
                System.out.print("Nhap short: ");
                return Short.parseShort(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Nhap lai.");
            }
        }
    }

    public static long inputLong() {
        while (true) {
            try {
                System.out.print("Nhap long: ");
                return Long.parseLong(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Nhap lai.");
            }
        }
    }

    // 2. số thực
    public static double inputDouble() {
        while (true) {
            try {
                System.out.print("Nhap double: ");
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Nhap lai.");
            }
        }
    }

    public static float inputFloat() {
        while (true) {
            try {
                System.out.print("Nhap float: ");
                return Float.parseFloat(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai! Nhap lai.");
            }
        }
    }

    // 3. ký tự
    public static char inputChar() {
        while (true) {
            try {
                System.out.print("Nhap ky tu: ");
                String s = sc.nextLine();
                if (s.length() == 1) {
                    return s.charAt(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Chi duoc nhap 1 ky tu!");
            }
        }
    }

    // chuỗi
    public static String inputString() {
        System.out.print("Nhap chuoi: ");
        return sc.nextLine();
    }

    // 4. boolean
    public static boolean inputBoolean() {
        while (true) {
            try {
                System.out.print("Nhap true/false: ");
                String s = sc.nextLine();
                if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(s);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Chi duoc nhap true hoac false!");
            }
        }
    }

    public static void main(String[] args) {

        int a = inputInt();
        byte b = inputByte();
        short c = inputShort();
        long d = inputLong();

        double e = inputDouble();
        float f = inputFloat();

        char g = inputChar();
        String h = inputString();

        boolean i = inputBoolean();

        System.out.println("\nKet qua:");
        System.out.println("int: " + a);
        System.out.println("byte: " + b);
        System.out.println("short: " + c);
        System.out.println("long: " + d);
        System.out.println("double: " + e);
        System.out.println("float: " + f);
        System.out.println("char: " + g);
        System.out.println("String: " + h);
        System.out.println("boolean: " + i);
    }
}

