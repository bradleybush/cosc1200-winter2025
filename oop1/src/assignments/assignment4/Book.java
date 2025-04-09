// Author:      Bradley Bush
// Date:        8 April 2025
// Activity:    Assignment 4: Inheritance and Data Structure
// File:        Book.java
// Description: Base book class.

package assignments.assignment4;

public abstract class Book
{
	String title;
	String author;
	String isbn;
	final int yearPublished;
	
	public Book(String title, String author, String isbn, int yearPublished)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.yearPublished = yearPublished;
	}
	
	public abstract String getBookType();
	
	public void displayInfo()
	{
		System.out.println("Title: " + this.title);
		System.out.println("Author: " + this.author);
		System.out.println("ISBN: " + this.isbn);
		System.out.println("Year Published: " + this.yearPublished);
	}
}
