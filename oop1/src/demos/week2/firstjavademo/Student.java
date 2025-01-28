package demos.week2.firstjavademo;

public class Student
{
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Student() {}
	public Student(String id, String firstName, String lastName, int age)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getId()
	{
		return this.id;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public int getAge()
	{
		return this.age;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String showFullName()
	{
		return this.getFirstName() + " " + this.getLastName();
	}
}
