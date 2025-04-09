package assignments.assignment4;

public class BookBorrowRequest
{
	final String bookName;
	final String requesterName;
	
	public BookBorrowRequest(String bookName, String requesterName)
	{
		this.bookName = bookName;
		this.requesterName = requesterName;
	}
}
