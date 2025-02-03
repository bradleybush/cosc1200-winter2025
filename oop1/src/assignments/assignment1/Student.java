// Author:   Bradley Bush
// Date:     2 February 2025
// Activity: Assignment 1: Simple Java Application
// File:     Student.java

package assignments.assignment1;

public class Student
{
	// Fields
	private String name;
	private int age;
	private String studentId;
	public static String universityName = "Tech University";
	
	// Default constructor
	public Student() {}
	
	// Parameterized constructor
	public Student(String name, int age, String studentId)
	{
		this.name = name;
		this.age = age;
		this.studentId = studentId;
	}
	
	// Prints the student’s details in a user-friendly format
	public void displayDetails()
	{
		System.out.println("\nStudent Details:\n");
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Student ID: " + getStudentId());
		System.out.println("University: " + universityName);
	}
	
	// Getters and setters
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getStudentId()
	{
		return studentId;
	}
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	
	public static void changeUniversityName(String newName)
	{
		universityName = newName;
	}
}
