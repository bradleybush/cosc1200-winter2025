package assignments.assignment4;

public class BorrowableBook extends FictionBook
{
	Boolean isBorrowed = false;
	String borrowerName = "";
	
	public BorrowableBook(String title,
	                      String author,
	                      String isbn,
	                      int yearPublished,
	                      String genre)
	{
		super(title, author, isbn, yearPublished, genre);
	}
	
	public void borrow(String borrowerName)
	{
		this.isBorrowed = true;
		this.borrowerName = borrowerName;
	}
	
	public void returnBook()
	{
		this.isBorrowed = false;
	}
	
	@Override
	public void displayInfo()
	{
		super.displayInfo();
		// If isBorrowed print Yes, else print No
		System.out.println("Borrowed: " + (this.isBorrowed ? "Yes" : "No"));
	}
}
