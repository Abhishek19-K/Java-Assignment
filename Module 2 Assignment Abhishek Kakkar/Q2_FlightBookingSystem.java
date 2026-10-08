import java.util.Scanner;

abstract class Flight {
    private String flightNumber, airline;
    private double fare;

    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    protected double getBaseFare() { return fare; }
    public abstract double calculateFare();

    @Override
    public String toString() {
        return "Flight No: " + flightNumber + " Airline: " + airline
                + " Fare: " + calculateFare();
    }
}

class DomesticFlight extends Flight {
    public DomesticFlight(String number, String airline, double fare) {
        super(number, airline, fare);
    }

    public double calculateFare() {
        return getBaseFare() * 1.10;
    }
}

class InternationalFlight extends Flight {
    public InternationalFlight(String number, String airline, double fare) {
        super(number, airline, fare);
    }

    public double calculateFare() {
        return getBaseFare() * 1.25;
    }
}

public class Q2_FlightBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter flight type,number,airline,fare");
        String line;

        while (sc.hasNextLine() && !(line = sc.nextLine().trim()).isEmpty()) {
            String[] p = line.split(",", 4);
            Flight flight;

            if (p[0].equalsIgnoreCase("Domestic")) {
                flight = new DomesticFlight(p[1].trim(), p[2].trim(),
                        Double.parseDouble(p[3].trim()));
            } else if (p[0].equalsIgnoreCase("International")) {
                flight = new InternationalFlight(p[1].trim(), p[2].trim(),
                        Double.parseDouble(p[3].trim()));
            } else {
                System.out.println("Invalid flight type.");
                continue;
            }

            System.out.println(flight);
        }

        sc.close();
    }
}
