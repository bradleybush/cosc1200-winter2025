package assignments.finalproject;

public class Book
{
	private String title;
	private String author;
	private String isbn;
	private String category;
	private boolean isIssued;
	
	public Book(String title, String author, String isbn, String category)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		isIssued = false;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getIsbn()
	{
		return isbn;
	}
	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public boolean isIssued()
	{
		return isIssued;
	}
	
	public void issueBook()
	{
		isIssued = true;
	}
	
	public void returnBook()
	{
		isIssued = false;
	}
}
