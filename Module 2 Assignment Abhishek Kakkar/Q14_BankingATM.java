import java.util.Scanner;

class Account {
    private String accNo, holderName;
    private double balance;

    public Account(String accNo, String holderName) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Q14_BankingATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example setup; account details are not specified in the input format.
        Account account = new Account("A101", "User");

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            switch (operation.toLowerCase()) {
                case "deposit":
                    account.deposit(sc.nextDouble());
                    break;
                case "withdraw":
                    account.withdraw(sc.nextDouble());
                    break;
                case "getbalance":
                    System.out.println("Balance: " + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }

        sc.close();
    }
}
