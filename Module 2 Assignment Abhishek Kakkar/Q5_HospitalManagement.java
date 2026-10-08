import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Doctor extends Person {
    protected String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }
}

class Surgeon extends Doctor {
    private String surgeryType;

    public Surgeon(String name, int age, String specialization, String surgeryType) {
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age
                + "\nSpecialization: " + specialization
                + "\nSurgery Type: " + surgeryType;
    }
}

public class Q5_HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(",", 4);

        Surgeon surgeon = new Surgeon(p[0].trim(),
                Integer.parseInt(p[1].trim()),
                p[2].trim(), p[3].trim());

        System.out.println(surgeon);
        sc.close();
    }
}
