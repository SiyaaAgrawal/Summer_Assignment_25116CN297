import java.util.ArrayList;
import java.util.Scanner;

// Employee Class demonstrating Encapsulation
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Overriding toString to format employee details nicely
    @Override
    public String toString() {
        return String.format("ID: %-6d | Name: %-15s | Dept: %-12s | Salary: $%.2f", id, name, department, salary);
    }
}

// Main Application Class
public class Problem119{
    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.util.Scanner.in == null ? System.in : System.in);

    public static void main(String[] args) {
        // Pre-populating some mock records for testing
        employeeList.add(new Employee(101, "Alice Smith", "IT", 75000));
        employeeList.add(new Employee(102, "Bob Jones", "HR", 60000));

        while (true) {
            System.out.println("\n===== MINI EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option! Please pick a number from 1 to 6.");
            }
        }
    }

    // 1. CREATE: Add a new employee record
    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        int id = getValidIntegerInput("Enter Employee ID: ");

        // Check if ID already exists
        if (findEmployeeById(id) != null) {
            System.out.println("Error: An employee with ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine().trim();
        
        double salary = getValidDoubleInput("Enter Salary: ");

        employeeList.add(new Employee(id, name, dept, salary));
        System.out.println("Employee recorded successfully!");
    }

    // 2. READ: View all active records
    private static void viewAllEmployees() {
        System.out.println("\n--- Employee Roster ---");
        if (employeeList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    // 3. READ: Search record by ID
    private static void searchEmployee() {
        System.out.println("\n--- Search Employee ---");
        int id = getValidIntegerInput("Enter Employee ID to search: ");
        Employee emp = findEmployeeById(id);

        if (emp != null) {
            System.out.println("Record Found -> " + emp);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // 4. UPDATE: Modify an existing record
    private static void updateEmployee() {
        System.out.println("\n--- Update Employee Details ---");
        int id = getValidIntegerInput("Enter Employee ID to update: ");
        Employee emp = findEmployeeById(id);

        if (emp == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter New Name (or press Enter to keep '" + emp.getName() + "'): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) emp.setName(newName);

        System.out.print("Enter New Department (or press Enter to keep '" + emp.getDepartment() + "'): ");
        String newDept = scanner.nextLine().trim();
        if (!newDept.isEmpty()) emp.setDepartment(newDept);

        System.out.print("Enter New Salary (or enter -1 to keep '" + emp.getSalary() + "'): ");
        try {
            String salaryInput = scanner.nextLine().trim();
            if (!salaryInput.isEmpty()) {
                double newSalary = Double.parseDouble(salaryInput);
                if (newSalary >= 0) emp.setSalary(newSalary);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary input. Keeping old value.");
        }

        System.out.println("Employee records updated successfully!");
    }

    // 5. DELETE: Remove an employee record
    private static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        int id = getValidIntegerInput("Enter Employee ID to delete: ");
        Employee emp = findEmployeeById(id);

        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Employee record deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Helper Utility: Find employee object by filtering ID
    private static Employee findEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Helper Utility: Validates integer inputs securely
    private static int getValidIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please enter a whole number.");
            }
        }
    }

    // Helper Utility: Validates double inputs securely
    private static double getValidDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please enter a numerical decimal value.");
            }
        }
    }
}

