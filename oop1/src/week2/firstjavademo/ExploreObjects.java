package org.dc.oop1.objects;

public class ExploreObjects
{
	public static void main(String[] args)
	{
		Student student1 = new Student();
		student1.setId("1");
		student1.setFirstName("John");
		student1.setLastName("Smith");
		student1.setAge(22);
		
		System.out.println("ID of the student is: " + student1.getId());
		System.out.println("First name of the student is: " + student1.getFirstName());
		System.out.println("Last name of the student is: " + student1.getLastName());
		System.out.println("Age of the student is: " + student1.getAge());
		
		System.out.println("Full name of student is: " + student1.showFullName());
		
		Student student2 = new Student("2", "John", "Snow", 30);
		
		System.out.println("ID of the student is: " + student2.getId());
		System.out.println("First name of the student is: " + student2.getFirstName());
		System.out.println("Last name of the student is: " + student2.getLastName());
		System.out.println("Age of the student is: " + student2.getAge());
		
		System.out.println("Full name of student is: " + student2.showFullName());
	}
}
