import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Professor {
    private String name, employeeId, specialization;

    public Professor() {}

    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId
                + ", Specialization: " + specialization;
    }
}

class Department {
    private String deptName, hodName;
    private List<Professor> professors;

    public Department() {
        professors = new ArrayList<>();
    }

    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
        professors = new ArrayList<>();
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getHodName() { return hodName; }
    public void setHodName(String hodName) { this.hodName = hodName; }
    public List<Professor> getProfessors() { return professors; }
    public void setProfessors(List<Professor> professors) { this.professors = professors; }

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Department: ").append(deptName).append("\n");
        result.append("HOD: ").append(hodName).append("\n");
        result.append("Professors:\n");
        for (Professor p : professors) {
            result.append(p).append("\n");
        }
        return result.toString();
    }
}

public class Q1_UniversityDepartmentProfessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Department details (deptName,hodName)");
        String[] d = sc.nextLine().split(",", 2);
        Department dept = new Department(d[0].trim(), d[1].trim());

        System.out.println("Enter number of professors");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Enter professor details (name,employeeId,specialization)");
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split(",", 3);
            dept.addProfessor(new Professor(p[0].trim(), p[1].trim(), p[2].trim()));
        }

        System.out.println(dept);
        sc.close();
    }
}
