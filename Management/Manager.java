package Management;
import EmployeeManagement.*;
import java.util.Scanner;


public class Manager {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        EmployeeManagement employeeManagement = new EmployeeManagement();
        
        while (true) {
            System.out.println("\nManager Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addEmployee(employeeManagement, scanner);
                    break;
                case 2:
                    removeEmployee(employeeManagement, scanner);
                    break;
                case 3:
                    updateEmployee(employeeManagement, scanner);
                    break;
                case 4:
                    displayEmployee(employeeManagement, scanner);
                    break;
                case 5:
                    employeeManagement.displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEmployee(EmployeeManagement employeeManagement, Scanner scanner) {
        
    	System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        
        scanner.nextLine();  
        System.out.print("Enter Employee Name: ");
        
        String name = scanner.nextLine();
        System.out.print("Enter Employee Position: ");
        
        String position = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        
        double salary = scanner.nextDouble();
        System.out.print("Enter Employee Working Hours: ");
        
        int workingHours = scanner.nextInt();

        Employee employee = new Employee(id, name, position, salary, workingHours);
        
        employeeManagement.addEmployee(employee);
    }

    private static void removeEmployee(EmployeeManagement employeeManagement, Scanner scanner) {
        System.out.print("Enter Employee ID to remove: ");
        
        int id = scanner.nextInt();
        
        employeeManagement.removeEmployee(id);
    }

    private static void updateEmployee(EmployeeManagement employeeManagement, Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        
        int id = scanner.nextInt();
        scanner.nextLine();  
        
        System.out.print("Enter New Position: ");
        String newPosition = scanner.nextLine();
        
        System.out.print("Enter New Salary: ");
        double newSalary = scanner.nextDouble();
        
        System.out.print("Enter New Working Hours: ");
        int newWorkingHours = scanner.nextInt();

        employeeManagement.updateEmployee(id, newPosition, newSalary, newWorkingHours);
    }

    private static void displayEmployee(EmployeeManagement employeeManagement, Scanner scanner) {
        System.out.print("Enter Employee ID to display: ");
        int id = scanner.nextInt();
        employeeManagement.displayEmployee(id);
    }
}
