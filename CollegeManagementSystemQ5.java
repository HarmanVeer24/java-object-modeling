import java.util.ArrayList;
import java.util.List;

// University Management System Simulation
public class CollegeManagementSystemQ5 {
    public static void main(String[] args) {
        // Creating courses
        CourseDetails math = new CourseDetails("Mathematics");
        CourseDetails cs = new CourseDetails("Computer Science");

        // Creating students
        StudentDetails harman = new StudentDetails("Harman");
        StudentDetails harsh = new StudentDetails("Harsh");

        // Creating professors
        Professor drRohit = new Professor("Dr. Rohit");
        Professor drRavinder = new Professor("Dr. Ravinder");

        // Assigning professors to courses
        drRohit.assignCourse(math);
        drRavinder.assignCourse(cs);

        // Enrolling students in courses
        harman.enrollCourse(math);
        harman.enrollCourse(cs);
        harsh.enrollCourse(cs);

        // Viewing enrolled courses of students
        harman.viewEnrolledCourses();
        harsh.viewEnrolledCourses();

        // Viewing assigned courses of professors
        drRohit.viewAssignedCourses();
        drRavinder.viewAssignedCourses();

        // Displaying course details
        math.showCourseDetails();
        cs.showCourseDetails();
    }
}

// CourseDetails class
class CourseDetails {
    private String courseName;
    private Professor professor;
    private List<StudentDetails> enrolledStudents;

    public CourseDetails(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
        System.out.println("Course created: " + courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " has been assigned to teach " + courseName);
    }

    public void enrollStudent(StudentDetails student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " has enrolled in " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (StudentDetails student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

// StudentDetails class
class StudentDetails {
    private String name;
    private List<CourseDetails> enrolledCourses;

    public StudentDetails(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        System.out.println("Student created: " + name);
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(CourseDetails course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println("\nStudent: " + name + " is enrolled in:");
        for (CourseDetails course : enrolledCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

// Professor class
class Professor {
    private String name;
    private List<CourseDetails> assignedCourses;

    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
        System.out.println("Professor created: " + name);
    }

    public String getName() {
        return name;
    }

    public void assignCourse(CourseDetails course) {
        assignedCourses.add(course);
        course.assignProfessor(this);
    }

    public void viewAssignedCourses() {
        System.out.println("\nProfessor: " + name + " teaches:");
        for (CourseDetails course : assignedCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

//output
// Course created: Mathematics
//Course created: Computer Science
//Student created: Harman
//Student created: Harsh
//Professor created: Dr. Rohit
//Professor created: Dr. Ravinder
//Dr. Rohit has been assigned to teach Mathematics
//Dr. Ravinder has been assigned to teach Computer Science
//Harman has enrolled in Mathematics
//Harman has enrolled in Computer Science
//Harsh has enrolled in Computer Science
//
//Student: Harman is enrolled in:
//- Mathematics
//- Computer Science
//
//Student: Harsh is enrolled in:
//- Computer Science
//
//Professor: Dr. Rohit teaches:
//- Mathematics
//
//Professor: Dr. Ravinder teaches:
//- Computer Science
//
//Course: Mathematics
//Professor: Dr. Rohit
//Enrolled Students:
//- Harman
//
//Course: Computer Science
//Professor: Dr. Ravinder
//Enrolled Students:
//- Harman
//- Harsh