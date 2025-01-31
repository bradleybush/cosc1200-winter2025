// Author:      Bradley Bush
// Date:        29 January 2025
// Document:    Class Exercise 1: Java Fundamentals
// Program:     Employee.java

package assignments.classexercise1;

import java.util.Scanner;

public class Employee
{
	// Private attributes
	private int id;
	private String name;
	private String department;
	private double salary;
	private double taxRate;
	
	// Default constructor
	public Employee() {}
	
	// Parameterized constructor
	public Employee(int id, String name, String department, double salary, double taxRate)
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.taxRate = taxRate;
	}
	
	// Getters and setters
	
	public double getTaxRate()
	{
		return taxRate;
	}
	public void setTaxRate(double taxRate)
	{
		this.taxRate = taxRate;
	}
	
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	// Other methods
	
	public double calculateNetSalary()
	{
		return salary * (1.0 - taxRate);
	}
	
	public void printDetails()
	{
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Salary: " + salary);
		System.out.println("Tax Rate: " + taxRate);
	}
	
	public void setIdFromUserInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		// Collect ID from user
		System.out.println("Enter the ID: ");
		id = inputScanner.nextInt();
	}
	public void setNameFromUserInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		// Collect name from user
		System.out.println("Enter the name: ");
		name = inputScanner.nextLine();
	}
	public void setDepartmentFromUserInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		// Collect department from user
		System.out.println("Enter the department: ");
		department = inputScanner.nextLine();
	}
	public void setSalaryFromUserInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		// Collect salary from user
		System.out.println("Enter the salary: ");
		salary = inputScanner.nextDouble();
	}
	public void setTaxRateFromUserInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		// Collect tax rate from user
		System.out.println("Enter the tax rate: ");
		salary = inputScanner.nextDouble();
	}
	public void setAllFromUserInput()
	{
		setIdFromUserInput();
		setNameFromUserInput();
		setDepartmentFromUserInput();
		setSalaryFromUserInput();
		setTaxRateFromUserInput();
	}
}
