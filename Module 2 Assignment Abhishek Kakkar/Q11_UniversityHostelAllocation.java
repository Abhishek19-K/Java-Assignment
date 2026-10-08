import java.util.Scanner;

class Room {
    private String roomNumber, block, type;

    public Room(String roomNumber, String block, String type) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + " " + block + " " + type;
    }
}

class Student {
    private String name, roll, course;
    private Room room;

    public Student(String name, String roll, String course) {
        this.name = name;
        this.roll = roll;
        this.course = course;
    }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    @Override
    public String toString() {
        return "Student: " + name + " (" + roll + ") " + course + "\n" + room;
    }
}

public class Q11_UniversityHostelAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(",");
        String[] r = sc.nextLine().split(",");

        Student student = new Student(s[0].trim(), s[1].trim(), s[2].trim());
        student.setRoom(new Room(r[0].trim(), r[1].trim(), r[2].trim()));

        System.out.println(student);
        sc.close();
    }
}
