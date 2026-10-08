import java.util.Scanner;

abstract class Loan {
    protected double principal, rate, time;

    public Loan(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double principal, double time) {
        super(principal, 8, time);
    }

    public double calculateInterest() {
        return (principal * rate * time) / 100;
    }
}

class CarLoan extends Loan {
    public CarLoan(double principal, double time) {
        super(principal, 10, time);
    }

    public double calculateInterest() {
        return (principal * rate * time) / 100;
    }
}

public class Q8_LoanManagement {
    public static void main(String[] args) {
        // The assignment fixes Home Loan at 8% and Car Loan at 10%.
        // Input format is interpreted as: Type,Principal,Time.
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split(",");
            double principal = Double.parseDouble(p[1].trim());
            double time = Double.parseDouble(p[2].trim());

            Loan loan;
            if (p[0].equalsIgnoreCase("Home")) {
                loan = new HomeLoan(principal, time);
                System.out.println("Home Loan Interest: " + loan.calculateInterest());
            } else if (p[0].equalsIgnoreCase("Car")) {
                loan = new CarLoan(principal, time);
                System.out.println("Car Loan Interest: " + loan.calculateInterest());
            }
        }

        sc.close();
    }
}
