import java.util.*;

public class Problem105{
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.util.System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT RECORD MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Record");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: 
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    // 1. Create Operation
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        // Check if ID already exists
        if (findStudentById(id) != null) {
            System.out.println("Error: A student with this ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("Student profile created successfully!");
    }

    // 2. Read Operation (All Records)
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found in the database.");
            return;
        }
        System.out.println("\n--- Current Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // 3. Read Operation (Specific Search)
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("\nRecord Found:\n" + student);
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // 4. Update Operation
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.print("Enter New Name (Current: " + student.getName() + "): ");
            student.setName(scanner.nextLine());
            System.out.print("Enter New Age (Current: " + student.getAge() + "): ");
            student.setAge(scanner.nextInt());
            scanner.nextLine(); // Consume newline
            System.out.print("Enter New Course (Current: " + student.getCourse() + "): ");
            student.setCourse(scanner.nextLine());
            System.out.println("Student record updated successfully!");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // 5. Delete Operation
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            studentList.remove(student);
            System.out.println("Student record deleted successfully!");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // Helper method to look up students and avoid repetitive loops
    private static Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
}
public class Student {
    private String studentId;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(String studentId, String name, int age, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}
