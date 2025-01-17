package EmployeeManagement;

public class Employee {
	
	private int id;
	private String name;
    private String position;
    private double salary;
    private int workingHours;

    
    public Employee(int id,String name, String position, double salary, int workingHours) {
    	this.id = id;
    	this.name = name;
        this.position = position;
        this.salary = salary;
        this.workingHours = workingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    
    @Override
    public String toString() {
        return "Employee : id=" + id + ", name='" + name + "', position='" + position + "', salary=" + salary + ", workingHours=" + workingHours ;
    }

}
