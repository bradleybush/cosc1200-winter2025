// Author:      Bradley Bush
// Date:        19 March 2025
// Activity:    Class Exercise 3: Exception Handling
// File:        Student.java
// Description: Step 2: Implement the Grading System - Create a Student
//              class with a method to validate and process grades.

package assignments.classexercise3.student;

import assignments.classexercise3.exception.InvalidGradeException;

public class Student
{
	private static final int MIN_GRADE = 0;
	private static final int MAX_GRADE = 100;
	private static final int PASSING_GRADE = 50;
	
	private String name;
	private int grade;
	
	// Constructor
	public Student(String name, int grade) throws InvalidGradeException
	{
		validateGrade(grade);
		this.name = name;
		this.grade = grade;
	}
	
	// -------------------
	// Getters and setters
	// -------------------
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	
	// -------------------
	
	// Validates that a specified grade value is between min and max or
	// throws exception.
	public void validateGrade(final int grade) throws InvalidGradeException
	{
		if ((grade < MIN_GRADE) || (grade > MAX_GRADE))
		{
			throw new InvalidGradeException(
				"Grade must be between "
				+ MIN_GRADE + " and " + MAX_GRADE + "."
			);
		}
	}
	
	// Returns whether the student has a passing grade or higher.
	public boolean checkPassing()
	{
		return (grade >= PASSING_GRADE);
	}
}
