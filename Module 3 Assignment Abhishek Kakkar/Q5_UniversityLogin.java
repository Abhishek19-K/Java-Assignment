import java.util.Scanner;

class UniversityLogin {
    public void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        System.out.println("Login successful for user: " + username);
    }
}

public class Q5_UniversityLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Treat the literal word "null" as a null username for the given assignment input.
        if (username.equalsIgnoreCase("null")) {
            username = null;
        }

        UniversityLogin loginSystem = new UniversityLogin();

        try {
            loginSystem.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
