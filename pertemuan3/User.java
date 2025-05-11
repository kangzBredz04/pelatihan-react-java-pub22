package pertemuan3;

import java.util.Scanner;

public class User {
    // Data yang ingin dirahasiakan
    private String username;
    private String password;

    // public User(String username, String password) {
    // this.username = username;
    // this.password = password;
    // }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        // User user = new User("admin", "123");
        User user = new User();

        // System.out.println("Sebelum diisi : ");
        // System.out.println("Username : " + user.getUsername());
        // System.out.println("Password : " + user.getPassword());

        // user.setUsername("admin");
        // user.setPassword("123");
        // System.out.println("Sesudah diisi : ");
        // System.out.println("Username : " + user.getUsername());
        // System.out.println("Password : " + user.getPassword());

        // user.setUsername("arjun");
        // user.setPassword("234");
        // System.out.println("Setelah Update : ");
        // System.out.println("Username : " + user.getUsername());
        // System.out.println("Password : " + user.getPassword());

        Scanner input = new Scanner(System.in);
        System.out.print("Username : ");
        user.setUsername(input.nextLine());
        System.out.print("Password : ");
        user.setPassword(input.nextLine());

        if (user.getUsername().equalsIgnoreCase("admin") &&
                user.getPassword().equalsIgnoreCase("123")) {
            System.out.println("Login berhasil");
        } else {
            System.out.println("Login gagal");
        }

        input.close();
    }
}
