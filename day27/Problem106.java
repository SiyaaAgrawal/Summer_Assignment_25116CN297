import java.util.*;

public class Problem106{
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.getenv("NO_CONSOLES") == null ? System.in : new java.io.ByteArrayInputStream(new byte[0]));

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Details");
            System.out.println("5. Delete Employee Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: displayEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateEmployee(); break;
                case 5: deleteEmployee(); break;
                case 6: 
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid entry. Please pick an option between 1 and 6.");
            }
        }
    }

    // 1. CREATE Operation
    private static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        // Prevent duplicate ID entry
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("Error: An employee with ID " + id + " already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employeeList.add(new Employee(id, name, age, designation, salary));
        System.out.println("Employee recorded successfully.");
    }

    // 2. READ Operation (All)
    private static void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No records found in the directory.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    // 3. READ Operation (Targeted Search)
    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("\nRecord Found:\n" + emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // 4. UPDATE Operation
    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter New Name: ");
                emp.setName(scanner.nextLine());
                System.out.print("Enter New Age: ");
                emp.setAge(scanner.nextInt());
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter New Designation: ");
                emp.setDesignation(scanner.nextLine());
                System.out.print("Enter New Salary: ");
                emp.setSalary(scanner.nextDouble());
                System.out.println("Employee profile updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // 5. DELETE Operation
    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                System.out.println("Employee profile removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
}
public class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;
    private double salary;

    // Constructor
    public Employee(int id, String name, int age, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + 
               " | Designation: " + designation + " | Salary: $" + salary;
    }
}

