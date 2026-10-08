import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    private LinkedHashSet<String> students = new LinkedHashSet<>();

    public void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5_OnlineCourseEnrollment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment enrollment = new CourseEnrollment();

        System.out.print("Enroll: ");
        enrollment.enrollStudent(sc.nextLine());

        System.out.print("Enroll: ");
        enrollment.enrollStudent(sc.nextLine());

        System.out.print("Enroll: ");
        enrollment.enrollStudent(sc.nextLine());

        enrollment.displayEnrolledStudents();

        sc.close();
    }
}
