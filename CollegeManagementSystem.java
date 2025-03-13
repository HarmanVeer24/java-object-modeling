import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate Composition & Aggregation
public class CollegeManagementSystem {
    public static void main(String[] args) {
        // Creating College
        College institute = new College("Chitkara University");

        // Adding Departments (Composition)
        institute.addDepartment("Artificial Intelligence");
        institute.addDepartment("Cyber Security");

        // Creating Faculty members (Independent of College)
        Faculty professor1 = new Faculty("Dr. Mridul Sharma");
        Faculty professor2 = new Faculty("Prof. Ravinder Kaur");

        // Adding Faculty to College (Aggregation)
        institute.addFaculty(professor1);
        institute.addFaculty(professor2);

        // Displaying College Details
        institute.displayDetails();

        // Deleting College (Departments should be deleted, Faculty still exists)
        institute = null;
        System.out.println("\nCollege deleted! Departments are gone, but Faculty still exists.");
        System.out.println("Faculty members still exist: " + professor1.getName() + ", " + professor2.getName());
    }
}

// Faculty class (Can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Exists only within a College → Composition)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// College class (Composition: Contains Departments, Aggregation: Contains Faculty)
class College {
    private String name;
    private List<Department> departments; // Composition
    private List<Faculty> faculties; // Aggregation

    public College(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Adding Departments (Composition)
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Adding Faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display College details
    public void displayDetails() {
        System.out.println("College: " + name);

        // Display Departments
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("  - " + dept.getName());
        }

        // Display Faculty
        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println("  - " + faculty.getName());
        }
    }
}

//output
// College: Chitkara University
//Departments:
//  - Artificial Intelligence
//  - Cyber Security
//Faculty Members:
//  - Dr. Mridul Sharma
//  - Prof. Ravinder Kaur
//
//College deleted! Departments are gone, but Faculty still exists.
//Faculty members still exist: Dr. Mridul Sharma, Prof. Ravinder Kaur
