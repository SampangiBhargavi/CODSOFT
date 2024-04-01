import java.util.*;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    List<String> schedule;
    List<String> registeredStudents;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(String studentID) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(studentID);
            return true;
        }
        return false;
    }

    public boolean dropStudent(String studentID) {
        return registeredStudents.remove(studentID);
    }

    public String toString() {
        return "Code: " + code + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity +
                ", Schedule: " + schedule + ", Registered Students: " + registeredStudents.size() + "/" + capacity;
    }
}

class Student {
    String id;
    String name;
    List<String> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Registered Courses: " + registeredCourses;
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Course c1 = new Course("CSC101", "Introduction to Computer Science", "An introductory course to computer science concepts", 30, Arrays.asList("Mon 10:00 AM - 12:00 PM", "Wed 10:00 AM - 12:00 PM"));
        Course c2 = new Course("MAT201", "Calculus I", "Fundamental concepts of calculus", 25, Arrays.asList("Tue 1:00 PM - 3:00 PM", "Thu 1:00 PM - 3:00 PM"));

        Student s1 = new Student("1001", "John Doe");
        Student s2 = new Student("1002", "Jane Smith");

        // Registering students for courses
        c1.registerStudent(s1.id);
        c1.registerStudent(s2.id);
        c2.registerStudent(s1.id);

        // Display course details
        System.out.println("Course 1: " + c1);
        System.out.println("Course 2: " + c2);

        // Display student details
        System.out.println("Student 1: " + s1);
        System.out.println("Student 2: " + s2);

        // Dropping a course
        c1.dropStudent(s2.id);

        // Display updated course details
        System.out.println("Course 1 after dropping a student: " + c1);
    }
}