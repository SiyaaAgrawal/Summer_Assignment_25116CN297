import java.util.Scanner;

class Student {
    // Encapsulated fields for student attributes
    private String name;
    private int rollNumber;
    private String studentClass;
    private String[] subjects;
    private int[] marks;
    private int totalMarks;
    private double percentage;
    private String grade;

    // Constructor to initialize structural data
    public Student(int numSubjects) {
        subjects = new String[numSubjects];
        marks = new int[numSubjects];
        totalMarks = 0;
    }

    // Method to ingest data safely from the standard console
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Student Name: ");
        this.name = scanner.nextLine();
        
        System.out.print("Enter Roll Number: ");
        this.rollNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer line
        
        System.out.print("Enter Class/Grade: ");
        this.studentClass = scanner.nextLine();

        // Dynamically request marks per subject
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter Name for Subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            
            while (true) {
                System.out.print("Enter Marks for " + subjects[i] + " (0-100): ");
                int score = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer line
                
                // Direct constraint validation for realistic grade scopes
                if (score >= 0 && score <= 100) {
                    marks[i] = score;
                    break;
                }
                System.out.println("⚠️ Invalid Entry! Marks must strictly fall between 0 and 100.");
            }
        }
    }

    // Evaluates aggregate criteria and structural pass limits
    public void calculateResults() {
        for (int score : marks) {
            totalMarks += score;
        }
        
        // Accurate mathematical calculation utilizing casting precision
        this.percentage = (double) totalMarks / subjects.length;

        // Logical conditions determining final global classification
        if (percentage >= 90) {
            this.grade = "A+ (Excellent)";
        } else if (percentage >= 80) {
            this.grade = "A (Very Good)";
        } else if (percentage >= 70) {
            this.grade = "B (Good)";
        } else if (percentage >= 60) {
            this.grade = "C (Satisfactory)";
        } else if (percentage >= 50) {
            this.grade = "D (Pass)";
        } else {
            this.grade = "F (Fail)";
        }
    }

    // Generates a cleanly structured, scannable terminal layout
    public void printMarksheet() {
        System.out.println("\n==================================================");
        System.out.println("            NATIONAL ACADEMY MARKSHEET            ");
        System.out.println("==================================================");
        System.out.printf("%-15s: %-30s\n", "Student Name", name);
        System.out.printf("%-15s: %-30d\n", "Roll Number", rollNumber);
        System.out.printf("%-15s: %-30s\n", "Class", studentClass);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s | %-15s\n", "SUBJECT", "MARKS OBTAINED");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-25s | %-15d\n", subjects[i], marks[i]);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s | %-15d\n", "TOTAL MARKS", totalMarks);
        System.out.printf("%-25s | %-15.2f%%\n", "PERCENTAGE", percentage);
        System.out.printf("%-25s | %-15s\n", "FINAL GRADE", grade);
        System.out.println("==================================================");
    }
}

public class Problem108{
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        
        System.out.println("=== Automated Marksheet Generator Application ===");
        System.out.print("Enter total number of subjects to register: ");
        int totalSubjects = mainScanner.nextInt();
        
        // Execute logic sequentially using modular object actions
        Student student = new Student(totalSubjects);
        student.inputDetails();
        student.calculateResults();
        student.printMarksheet();
        
        mainScanner.close();
    }
}
