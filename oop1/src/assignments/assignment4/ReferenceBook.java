package assignments.assignment4;

public class ReferenceBook extends Book
{
	private Boolean restricted = true;
	
	public ReferenceBook(String title,
						 String author,
						 String isbn,
						 int yearPublished)
	{
		super(title, author, isbn, yearPublished);
	}
	
	public Boolean getRestricted()
	{
		return this.restricted;
	}
	
	public void setRestricted(Boolean restricted)
	{
		this.restricted = restricted;
	}
	
	@Override
	public String getBookType()
	{
		return "Reference";
	}
	
	@Override
	public void displayInfo()
	{
		super.displayInfo();
		System.out.println("This book cannot be borrowed.");
	}
}
