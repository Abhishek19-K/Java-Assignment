import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Course {
    private String courseName, duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() { return courseName; }
    public String getDuration() { return duration; }
}

class Student {
    protected String name;
    protected Course enrolledCourse;

    public Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    @Override
    public String toString() {
        return "Student: " + name + " Course: "
                + enrolledCourse.getCourseName() + " (" + enrolledCourse.getDuration() + ")";
    }
}

class PremiumStudent extends Student {
    private double discount;

    public PremiumStudent(String name, Course course, double discount) {
        super(name, course);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Premium Student: " + name + " Course: "
                + enrolledCourse.getCourseName() + " (" + enrolledCourse.getDuration()
                + ") Discount: " + discount + "%";
    }
}

public class Q9_OnlineCoursePlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] c = sc.nextLine().split(",", 2);
        Course course = new Course(c[0].trim(), c[1].trim());

        Map<String, Student> students = new HashMap<>();

        String[] s1 = sc.nextLine().split(",");
        students.put(s1[0].trim(), new Student(s1[0].trim(), course));

        String[] s2 = sc.nextLine().split(",");
        students.put(s2[0].trim(),
                new PremiumStudent(s2[0].trim(), course,
                        Double.parseDouble(s2[2].trim())));

        System.out.println(students.get(s1[0].trim()));
        System.out.println(students.get(s2[0].trim()));

        sc.close();
    }
}
