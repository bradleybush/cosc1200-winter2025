// Author:      Bradley Bush
// Date:        8 April 2025
// Activity:    Class Exercise 4: File I/O
// File:        Main.java
// Description: Reads student records from a file, processes the data,
//              and writes selected information to a new file. Includes
//              some printing to the console during the process.

package assignments.classexercise4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	// Make sure this file exists before running the program
	private static final String INPUT_FILENAME = "students.txt";
	// This file will be created if it doesn't exist already
	private static final String OUTPUT_FILENAME = "top_students.txt";
	
	public static void main(String[] args)
	{
		// Begin program
		System.out.println("Program started...");
		
		// -------------------------------------
		// Read the data from the file and parse
		// each line into a Student object
		// -------------------------------------
		// Create a list of students
		ArrayList<Student> students = new ArrayList<>();
		// Read the data from the input file
		System.out.println("Reading data...");
		try (BufferedReader reader = new BufferedReader(
			new FileReader(INPUT_FILENAME)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				// Create a new student with the data from the current
				// input file line and add it to the students list
				String[] cols = line.split(",");
				String name = cols[0].trim();
				int courseId = Integer.parseInt(cols[1].trim());
				int marks = Integer.parseInt(cols[2].trim());
				students.add(new Student(name, courseId, marks));
				System.out.println(
					"Student read from " + INPUT_FILENAME + "..."
				);
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: File not found or cannot be read.");
			System.out.println(e.getMessage());
		}
		System.out.println("Data finished reading...");
		
		// -------------------------------------------------
		// Filter students who have marks above 80 (>80) and
		// write the names of these students to a new file
		// -------------------------------------------------
		// Write the data to the output file
		System.out.println("Writing data...");
		try (BufferedWriter writer = new BufferedWriter(
			new FileWriter(OUTPUT_FILENAME, true)))
		{
			// Loop through students list
			for (Student student : students)
			{
				// Check if mark is above 80
				if (student.getMarks() > 80)
				{
					// Write the name of the student to the output file
					writer.write(student.getName() + "\n");
					System.out.println(
						"Student written to " + OUTPUT_FILENAME + "..."
					);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: Unable to write to file.");
			System.out.println(e.getMessage());
		}
		System.out.println("Data finished reading...");
		
		// End program
		System.out.println("Program finished!");
	}
}
