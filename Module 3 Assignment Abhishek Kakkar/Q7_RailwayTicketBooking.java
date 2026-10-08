import java.util.Scanner;

class TicketBooking {
    private int availableSeats;

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookSeat(String user, int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(user + " booked " + seats + " seat(s) successfully");
        } else {
            System.out.println(user + " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {
    private TicketBooking booking;
    private int seats;

    public User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat("User1", seats);
    }
}

class User2 extends Thread {
    private TicketBooking booking;
    private int seats;

    public User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat("User2", seats);
    }
}

public class Q7_RailwayTicketBooking {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int user1Seats = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int user2Seats = sc.nextInt();

        TicketBooking booking = new TicketBooking(availableSeats);

        User1 user1 = new User1(booking, user1Seats);
        User2 user2 = new User2(booking, user2Seats);

        user1.start();
        user1.join();
        user2.start();
        user2.join();

        sc.close();
    }
}
