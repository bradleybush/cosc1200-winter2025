// Author:   Bradley Bush
// Date:     2 February 2025
// Activity: Assignment 1: Simple Java Application
// File:     SimpleJavaApplication.java

package assignments.assignment1;

public class SimpleJavaApplication
{
	public static void main(String[] args)
	{
		// Instantiate two Student objects
		Student s1 = new Student("Brad", 20, "101000002");
		Student s2 = new Student("John", 90, "1");
		
		// Test Student class methods
		
		s1.displayDetails();
		s2.displayDetails();
		
		// Modify details to test setter methods
		s2.setName("Jon");
		s2.setAge(100);
		s2.setStudentId("2");
		Student.changeUniversityName("Jon University");
		System.out.println("\n- Details modified!");
		
		s1.displayDetails();
		s2.displayDetails();
	}
}
