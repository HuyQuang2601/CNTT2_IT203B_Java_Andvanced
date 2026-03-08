package ex6;

public class User {

    private String name;
    private int age;

    public User(String name) {
        this.name = name;
    }

    public void setAge(int age) throws InvalidAgeException {

        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void printUserInfo() {

        if (name != null) {
            System.out.println("Tên người dùng: " + name);
        } else {
            System.out.println("Tên người dùng chưa được thiết lập.");
        }

        System.out.println("Tuổi: " + age);
    }
}