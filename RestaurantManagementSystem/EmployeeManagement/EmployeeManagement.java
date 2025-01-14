package EmployeeManagement;

import java.util.HashMap;

public class EmployeeManagement {
	
	private HashMap<Integer, Employee> employees = new HashMap<>();

    
    public EmployeeManagement() {
       
    }

    
    public void addEmployee(Employee employee)
    {
        if (employees.containsKey(employee.getId())) 
        {
            System.out.println("Employee with ID " + employee.getId() + " already exists.");
        }
        else 
        {
            employees.put(employee.getId(), employee);
            System.out.println("Employee " + employee.getName() + " added.");
        }
    }

    
    public void removeEmployee(int id) 
    {
        Employee employeeToRemove = employees.remove(id);
        
        if (employeeToRemove != null) 
        {
            System.out.println("Employee with ID " + id + " removed.");
        } 
        else 
        {
            System.out.println("Employee not found.");
        }
    }

    
    public void updateEmployee(int id, String newPosition, double newSalary, int newWorkingHours) 
    {
        Employee employee = employees.get(id);
        
        if (employee != null) 
        {
            employee.setPosition(newPosition);
            employee.setSalary(newSalary);
            employee.setWorkingHours(newWorkingHours);
            System.out.println("Employee with ID " + id + "'s details updated.");
        } 
        else 
        {
            System.out.println("Employee not found.");
        }
    }

    
    public void displayEmployee(int id) 
    {
        Employee employee = employees.get(id);
        
        if (employee != null) 
        {
            System.out.println(employee);
        } 
        else 
        {
            System.out.println("Employee not found.");
        }
    }

    
    public void displayAllEmployees() 
    {
        if (employees.isEmpty()) 
        {
            System.out.println("No employees in the list.");
        } 
        else 
        {
            System.out.println("\nEmployee List:");
            
            for (Employee employee : employees.values()) 
            {
                System.out.println(employee);
            }
        }
    }

}
