import java.util.Scanner;

public class Problem120 {
    
    // Global constant for max students allowed in our fixed array
    private static final int MAX_STUDENTS = 50;
    private static String[] names = new String[MAX_STUDENTS];
    private static int[] grades = new int[MAX_STUDENTS];
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate with sample data for demonstration
        addSampleData();
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    calculateAndPrintMetrics();
                    break;
                case 4:
                    searchStudentByName();
                    break;
                case 5:
                    System.out.println("Exiting System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Function 1: Displays Menu Options
    public static void displayMenu() {
        System.out.println("\n===== STUDENT GRADE MANAGER =====");
        System.out.println("1. Add New Student & Grade");
        System.out.println("2. View All Students");
        System.out.println("3. View Class Analytics (Average, Highest, Lowest)");
        System.out.println("4. Search Student by Name");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Function 2: Adds Sample Data to the Arrays
    public static void addSampleData() {
        names[0] = "Alice Smith";  grades[0] = 88;
        names[1] = "Bob Jones";    grades[1] = 92;
        names[2] = "Charlie Brown"; grades[2] = 79;
        studentCount = 3;
    }

    // Function 3: Adds a New Entry using Array Indexing
    public static void addNewStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Error: Classroom array is full!");
            return;
        }
        System.out.print("Enter student's full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's numerical grade (0-100): ");
        int grade = scanner.nextInt();

        names[studentCount] = name;
        grades[studentCount] = grade;
        studentCount++;
        System.out.println("Student record added successfully.");
    }

    // Function 4: Iterates Arrays to Display Content
    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student Roster ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("ID: " + (i + 1) + " | Name: " + names[i] + " | Grade: " + grades[i]);
        }
    }

    // Function 5: Math Logic Processing Arrays
    public static void calculateAndPrintMetrics() {
        if (studentCount == 0) {
            System.out.println("No data to analyze.");
            return;
        }
        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int i = 0; i < studentCount; i++) {
            sum += grades[i];
            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest)  lowest = grades[i];
        }

        double average = (double) sum / studentCount;
        System.out.println("\n--- Class Performance Metrics ---");
        System.out.printf("Class Average : %.2f\n", average);
        System.out.println("Highest Grade : " + highest);
        System.out.println("Lowest Grade  : " + lowest);
    }

    // Function 6: String Manipulation & Comparison Logic
    public static void searchStudentByName() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            // Case-insensitive fractional matching
            if (names[i].toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Match Found -> Name: " + names[i] + " | Grade: " + grades[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found containing the name: " + searchName);
        }
    }
}

