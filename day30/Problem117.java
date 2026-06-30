import java.util.Scanner;

public class Problem117 {
    // Define the maximum capacity of our system using a fixed-size array limit
    private static final int MAX_STUDENTS = 100;
    
    // Parallel arrays to store student attributes
    private static String[] studentIDs = new String[MAX_STUDENTS];
    private static String[] studentNames = new String[MAX_STUDENTS];
    private static String[] studentGrades = new String[MAX_STUDENTS];
    
    // Counter tracking the exact index placement of active records
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT RECORD SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Student Records");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    viewAllStudents();
                    break;
                case "3":
                    searchStudent();
                    break;
                case "4":
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid election! Please enter a number between 1 and 4.");
            }
        }
    }

    // Method to create and add a unique student record
    private static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Database Error: Capacity limit reached. Cannot add more records.");
            return;
        }

        System.out.print("Enter unique Student ID: ");
        String id = scanner.nextLine().trim();
        
        // Validation check to prevent duplicate identification numbers
        if (findStudentIndex(id) != -1) {
            System.out.println("Validation Error: A student with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Student Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Student Grade (e.g., A, B, C): ");
        String grade = scanner.nextLine().trim().toUpperCase();

        // Populate array structures across corresponding indices
        studentIDs[studentCount] = id;
        studentNames[studentCount] = name;
        studentGrades[studentCount] = grade;
        studentCount++;

        System.out.println("Success: Record saved cleanly at index allocation position.");
    }

    // Method to systematically display all records populated inside arrays
    private static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No records found in the system database.");
            return;
        }

        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-15s %-20s %-10s\n", "STUDENT ID", "NAME", "GRADE");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-15s %-20s %-10s\n", studentIDs[i], studentNames[i], studentGrades[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    // Method to search using direct target matching algorithms 
    private static void searchStudent() {
        System.out.print("Enter Target Student ID to query: ");
        String id = scanner.nextLine().trim();
        
        int targetIndex = findStudentIndex(id);
        
        if (targetIndex != -1) {
            System.out.println("\nRecord Found Matching Query Criteria:");
            System.out.println("ID:     " + studentIDs[targetIndex]);
            System.out.println("Name:   " + studentNames[targetIndex]);
            System.out.println("Grade:  " + studentGrades[targetIndex]);
        } else {
            System.out.println("Search Failure: No record correlates to requested ID: " + id);
        }
    }

    // Linear scanning loop helper designed to safely match String references
    private static int findStudentIndex(String id) {
        for (int i = 0; i < studentCount; i++) {
            // Using equalsIgnoreCase ensures comparison functionality resists case anomalies
            if (studentIDs[i].equalsIgnoreCase(id)) {
                return i; 
            }
        }
        return -1; 
    }
}

