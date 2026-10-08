import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guest {
    private String name, idProof;
    private int age;

    public Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + idProof;
    }
}

class Reservation {
    private String reservationId, roomType;
    private List<Guest> guests = new ArrayList<>();

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(
                "Reservation ID: " + reservationId + " Room: " + roomType + "\nGuests:\n");
        for (Guest g : guests) s.append(g).append("\n");
        return s.toString();
    }
}

public class Q13_HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] r = sc.nextLine().split(",");
        Reservation reservation = new Reservation(r[0].trim(), r[1].trim());

        int n = Integer.parseInt(r[2].trim());
        for (int i = 0; i < n; i++) {
            String[] g = sc.nextLine().split(",");
            reservation.addGuest(new Guest(g[0].trim(),
                    Integer.parseInt(g[1].trim()), g[2].trim()));
        }

        System.out.println(reservation);
        sc.close();
    }
}
