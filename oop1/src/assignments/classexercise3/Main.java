// Author:      Bradley Bush
// Date:        19 March 2025
// Activity:    Class Exercise 3: Exception Handling
// File:        Main.java
// Description: For a university system to process student grades,
//              validates that grades are in a valid range or throw an
//              exception, reads multiple grades from a file, handles
//              multiple exceptions, and displays a pass/fail status.
//              
//              Step 3: Handle Multiple Exceptions in main

package assignments.classexercise3;

import assignments.classexercise3.exception.InvalidGradeException;
import assignments.classexercise3.student.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	private final static int NUM_STUDENTS = 3;
	private final static Scanner inputScanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// --------------
		// Greet the user
		// --------------
		System.out.println("\nWelcome to the student processing program!\n");
		
		// ---------------------------------------
		// Collect students and display pass count
		// ---------------------------------------
		
		// Collect the students from the user and put them in a list
		ArrayList<Student> studentList = new ArrayList<>(NUM_STUDENTS);
		for (int i = 0; i < NUM_STUDENTS; i++)
		{
			studentList.add(getStudentFromUser());
			System.out.println("Student recorded successfully!\n");
		}
		
		// Iterate through students list, count and display the number
		// of students who are passing
		int passCount = 0;
		for (Student student : studentList)
		{
			if (student.checkPassing())
			{
				passCount += 1;
			}
		}
		System.out.println(
			"Number of students who are passing: " + passCount + "\n"
		);
		
		// ------------------------------
		// Demonstrate try-with-resources
		// ------------------------------
		System.out.println("Demonstrating try-with-resources...");
		try (Scanner resource = new Scanner(System.in))
		{
			System.out.println("Created scanner...");
		}
		catch (Exception e)
		{
			System.out.println("Exception while handling resource:");
			System.out.println(e.getMessage());
		}
		System.out.println("Try-with-resources demonstration complete!");
		
		// ------------------------
		// Bid farewell to the user
		// ------------------------
		System.out.println("\nThanks for playing!");
	}
	
	// Returns a validated grade for a student from the user
	private static int getStudentGradeFromUser()
	{
		while (true)
		{
			// Prompt the user for the first number
			System.out.print("Enter student grade: ");
			// Attempt to get an integer from user
			if (!inputScanner.hasNextInt())
			{
				// Non-integer inputted, skip line and display message
				inputScanner.nextLine();
				System.out.println("Invalid input. Please enter a "
				                   + "whole number.");
			}
			else
			{
				// Integer inputted, read it from user
				int ret = inputScanner.nextInt();
				// Consume the newline from input for future scanning
				inputScanner.nextLine();
				return ret;
			}
		}
	}
	
	// Returns a student object with fields defined by user input,
	// with validation
	private static Student getStudentFromUser()
	{
		while (true)
		{
			// Get student information from the user
			System.out.print("Enter student name: ");
			final String name = inputScanner.nextLine();
			final int grade = getStudentGradeFromUser();
			// Attempt to create a student object with user-given
			// information, display any exceptions that are avoided and
			// re-prompt after doing so
			try
			{
				return new Student(name, grade);
			}
			catch (InvalidGradeException e)
			{
				System.out.println("Student creation failed:");
				System.out.println(e.getMessage());
				System.out.println("Please try again.\n");
			}
		}
	}
}
