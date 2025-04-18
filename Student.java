import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ravi", 82),
            new Student("Priya", 74),
            new Student("Amit", 90),
            new Student("Sneha", 65)
        );

        System.out.println("\nStudents scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
