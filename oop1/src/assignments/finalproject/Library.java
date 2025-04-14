package assignments.finalproject;

import java.util.ArrayList;

public class Library
{
	private final ArrayList<Book> books;
	
	public Library()
	{
		this.books = new ArrayList<>();
	}
	
	public ArrayList<Book> getBooks()
	{
		return this.books;
	}
	
	public void addBook(final Book book)
	{
		this.books.add(book);
	}
	
	public boolean issueBookByIsbn(final String isbn)
	{
		for (Book book : books)
		{
			if (book.getIsbn().equals(isbn) && !book.isIssued())
			{
				book.issueBook();
				return true;
			}
		}
		return false;
	}
	
	public boolean returnBookByIsbn(final String isbn)
	{
		for (Book book : books)
		{
			if (book.getIsbn().equals(isbn) && book.isIssued())
			{
				book.returnBook();
				return true;
			}
		}
		return false;
	}
	
	public void clear()
	{
		this.books.clear();
	}
}
