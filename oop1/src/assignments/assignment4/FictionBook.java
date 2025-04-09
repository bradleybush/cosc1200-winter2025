package assignments.assignment4;

public class FictionBook extends Book
{
	final String genre;
	
	public FictionBook(String title,
	                   String author,
					   String isbn,
					   int yearPublished,
					   String genre)
	{
		super(title, author, isbn, yearPublished);
		this.genre = genre;
	}
	
	@Override
	public String getBookType()
	{
		return "Fiction";
	}
}
