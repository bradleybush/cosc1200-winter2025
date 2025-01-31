// Author:      Bradley Bush
// Date:        30 January 2025
// Document:    Class Exercise 1: Java Fundamentals
// Program:     PayrollSystem.java

package assignments.classexercise1;

import java.util.Scanner;

public class PayrollSystem
{
	// Initialize employees with basic data
	private static final Employee e1 = new Employee(0, "e1", "dept", 0.0, 0.0);
	private static final Employee e2 = new Employee(0, "e2", "dept", 0.0, 0.0);
	private static final Employee e3 = new Employee(0, "e3", "dept", 0.0, 0.0);
	private static final Employee e4 = new Employee(0, "e4", "dept", 0.0, 0.0);
	private static final Employee e5 = new Employee(0, "e5", "dept", 0.0, 0.0);
	
	public static void main(String[] args)
	{
		// Greet the user
		System.out.println("Welcome to the Employee Payroll System!");
		
		// Main program loop
		boolean continueProgram = true;
		int menuChoice;
		while (continueProgram)
		{
			// Display menu and store option choice
			Scanner inputScanner = new Scanner(System.in);
			System.out.println("1. Define employee data");
			System.out.println("2. View all employee data");
			System.out.println("3. Search by employee ID");
			System.out.println("4. Update employee salary");
			System.out.println("5. Exit program");
			menuChoice = inputScanner.nextInt();
			
			// Execute menu actions
			switch (menuChoice)
			{
				case 1:
					setEmployeeDataFromUser();
					break;
				case 2:
					printAllEmployeeData();
					break;
				case 3:
					System.out.println("Enter ID to search: ");
					int searchId = inputScanner.nextInt();
					searchEmployeeByIdAndPrintDetails(searchId);
					break;
				case 4:
					// Prompt user for employee number
					System.out.println("Which employee? (1-5): ");
					// Switch inputted employee number and allow the
					// user to set that employee's salary
					switch (inputScanner.nextInt())
					{
						case 1:
							e1.setSalaryFromUserInput();
							break;
						case 2:
							e2.setSalaryFromUserInput();
							break;
						case 3:
							e3.setSalaryFromUserInput();
							break;
						case 4:
							e4.setSalaryFromUserInput();
							break;
						case 5:
							e5.setSalaryFromUserInput();
							break;
						default:
							// Input number does not correspond to a
							// valid employee, display error
							System.out.println("Employee not found.");
							break;
					}
					break;
				case 5:
					// Cause the program loop to end/stop looping
					continueProgram = false;
					break;
			}
		}
		
		// Bid farewell to the user
		System.out.println("Thanks for playing!");
	}
	
	private static void setEmployeeDataFromUser()
	{
		Scanner inputScanner = new Scanner(System.in);
		switch (inputScanner.nextInt())
		{
			case 1:
				e1.setAllFromUserInput();
				break;
			case 2:
				e2.setAllFromUserInput();
				break;
			case 3:
				e3.setAllFromUserInput();
				break;
			case 4:
				e4.setAllFromUserInput();
				break;
			case 5:
				e5.setAllFromUserInput();
				break;
			default:
				System.out.println("Employee not found.");
				break;
		}
	}
	
	private static void printAllEmployeeData()
	{
		System.out.println("1st employee:");
		e1.printDetails();
		System.out.println("2nd employee:");
		e2.printDetails();
		System.out.println("3rd employee:");
		e3.printDetails();
		System.out.println("4th employee:");
		e4.printDetails();
		System.out.println("5th employee:");
		e5.printDetails();
	}
		
	private static void searchEmployeeByIdAndPrintDetails(int searchId)
	{
		if (searchId == e1.getId())
		{
			System.out.println("Employee 1:");
			e1.printDetails();
		}
		else if (searchId == e2.getId())
		{
			System.out.println("Employee 2:");
			e2.printDetails();
		}
		else if (searchId == e3.getId())
		{
			System.out.println("Employee 3:");
			e3.printDetails();
		}
		else if (searchId == e4.getId())
		{
			System.out.println("Employee 4:");
			e4.printDetails();
		}
		else if (searchId == e5.getId())
		{
			System.out.println("Employee 5:");
			e5.printDetails();
		}
		else
		{
			System.out.println("ID " + searchId + " not found.");
		}
	}
}
