import java.util.Scanner;

class Vehicle {
    protected String regNo, brand;
    protected double baseRate;

    public Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public double calculateRent() {
        return baseRate;
    }
}

class Car extends Vehicle {
    public Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.5;
    }
}

class Bike extends Vehicle {
    public Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.2;
    }
}

public class Q12_VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split(",");
            Vehicle vehicle;

            if (p[0].equalsIgnoreCase("Car")) {
                vehicle = new Car(p[1].trim(), p[2].trim(),
                        Double.parseDouble(p[3].trim()));
            } else {
                vehicle = new Bike(p[1].trim(), p[2].trim(),
                        Double.parseDouble(p[3].trim()));
            }

            System.out.println(p[0].trim() + " " + p[1].trim() + " " + p[2].trim()
                    + " Rent: " + vehicle.calculateRent());
        }

        sc.close();
    }
}
