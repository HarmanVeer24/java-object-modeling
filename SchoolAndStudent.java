import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate Association and Aggregation
public class SchoolAndStudent {
    public static void main(String[] args) {
        // Creating a school
        School sunriseAcademy = new School("Sunrise Academy");

        // Creating students
        Student ryan = new Student("Ryan");
        Student sophia = new Student("Sophia");

        // Adding students to the school (Aggregation)
        sunriseAcademy.addStudent(ryan);
        sunriseAcademy.addStudent(sophia);

        // Creating courses
        Course physics = new Course("Physics");
        Course history = new Course("History");

        // Enrolling students in courses (Association)
        physics.enrollStudent(ryan);
        physics.enrollStudent(sophia);
        history.enrollStudent(sophia);

        // Displaying students in the school
        sunriseAcademy.showStudents();

        // Displaying students enrolled in each course
        physics.showEnrolledStudents();
        history.showEnrolledStudents();

        // Displaying courses each student is enrolled in
        ryan.showEnrolledCourses();
        sophia.showEnrolledCourses();
    }
}

// Course class (Students can enroll in multiple courses)
class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("\nCourse: " + courseName);
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("Student: " + student.getName());
            }
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class (Can enroll in multiple courses)
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showEnrolledCourses() {
        System.out.println("\nStudent: " + name);
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("Enrolled in: " + course.getCourseName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// School class (Aggregates multiple students)
class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("\nSchool: " + schoolName);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                System.out.println("Student: " + student.getName());
            }
        }
    }
}
//output
// School: Sunrise Academy
//Student: Ryan
//Student: Sophia
//
//Course: Physics
//Student: Ryan
//Student: Sophia
//
//Course: History
//Student: Sophia
//
//Student: Ryan
//Enrolled in: Physics
//
//Student: Sophia
//Enrolled in: Physics
//Enrolled in: History