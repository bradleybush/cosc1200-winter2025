package assignments.assignment4;

public class NonFictionBook extends Book
{
	final String subject;
	
	public NonFictionBook(String title,
						  String author,
						  String isbn,
						  int yearPublished,
						  String subject)
	{
		super(title, author, isbn, yearPublished);
		this.subject = subject;
	}
	
	@Override
	public String getBookType()
	{
		return "Non-Fiction";
	}
}
