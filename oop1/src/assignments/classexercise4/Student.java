// Author:      Bradley Bush
// Date:        8 April 2025
// Activity:    Class Exercise 4: File I/O
// File:        Student.java
// Description: Student class (name, course ID, marks).

package assignments.classexercise4;

public class Student
{
	private String name;
	private int courseId;
	private int marks;
	
	public Student(String name, int courseId, int marks)
	{
		this.name = name;
		this.courseId = courseId;
		this.marks = marks;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCourseId()
	{
		return this.courseId;
	}
	
	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}
	
	public int getMarks()
	{
		return this.marks;
	}
	
	public void setMarks(int marks)
	{
		this.marks = marks;
	}
}
