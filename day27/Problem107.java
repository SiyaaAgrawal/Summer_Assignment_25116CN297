import java.util.*;

// Class representing an individual Employee
class Employee {
    private String id;
    private String name;
    private String designation;
    private double basicSalary;

    // Constructor
    public Employee(String id, String name, String designation, double basicSalary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getBasicSalary() { return basicSalary; }

    // Logic to calculate allowances and deductions
    public double calculateHRA() { return basicSalary * 0.15; } // 15% House Rent Allowance
    public double calculateDA() { return basicSalary * 0.10; }  // 10% Dearness Allowance
    public double calculateTax() { return basicSalary * 0.12; } // 12% Income Tax Deduction
    public double calculatePF() { return basicSalary * 0.08; }  // 8% Provident Fund Deduction

    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - (calculateTax() + calculatePF());
    }

    // Method to display a formatted payslip
    public void displayPayslip() {
        System.out.println("\n===========================================");
        System.out.println("            SALARY BREAKDOWN               ");
        System.out.println("===========================================");
        System.out.printf("Employee ID   : %s\n", id);
        System.out.printf("Name          : %s\n", name);
        System.out.printf("Designation   : %s\n", designation);
        System.out.println("-------------------------------------------");
        System.out.printf("Basic Salary  : $%.2f\n", basicSalary);
        System.out.printf("HRA (15%%)     : $%.2f\n", calculateHRA());
        System.out.printf("DA (10%%)      : $%.2f\n", calculateDA());
        System.out.printf("Gross Salary  : $%.2f\n", calculateGrossSalary());
        System.out.println("-------------------------------------------");
        System.out.printf("Tax (12%%)     : $%.2f\n", calculateTax());
        System.out.printf("PF (8%%)       : $%.2f\n", calculatePF());
        System.out.println("-------------------------------------------");
        System.out.printf("NET SALARY    : $%.2f\n", calculateNetSalary());
        System.out.println("===========================================\n");
    }
}

// Main class managing the application menu and array operations
public class Problem107{
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== SALARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employee Salaries");
            System.out.println("3. Generate Employee Payslip by ID");
            System.out.println("4. Exit");
            System.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left behind

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllSalaries();
                    break;
                case 3:
                    generatePayslip();
                    break;
                case 4:
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.\n");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.print("Enter Base Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 

        employeeList.add(new Employee(id, name, designation, salary));
        System.out.println("Employee registration added successfully!\n");
    }

    private static void viewAllSalaries() {
        if (employeeList.isEmpty()) {
            System.out.println("No employee records found.\n");
            return;
        }
        System.out.println("\n---------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-12s %-12s\n", "ID", "Name", "Designation", "Gross Pay", "Net Pay");
        System.out.println("---------------------------------------------------------------------");
        for (Employee emp : employeeList) {
            System.out.printf("%-10s %-20s %-15s $%-11.2f $%-11.2f\n", 
                emp.getId(), emp.getName(), emp.getDesignation(), emp.calculateGrossSalary(), emp.calculateNetSalary());
        }
        System.out.println("---------------------------------------------------------------------\n");
    }

    private static void generatePayslip() {
        System.out.print("Enter Employee ID to fetch breakdown: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Employee emp : employeeList) {
            if (emp.getId().equalsIgnoreCase(id)) {
                emp.displayPayslip();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee record with ID " + id + " not found.\n");
        }
    }
}
