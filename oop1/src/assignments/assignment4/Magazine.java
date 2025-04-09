// Author:      Bradley Bush
// Date:        8 April 2025
// Activity:    Assignment 4: Inheritance and Data Structure
// File:        Main.java
// Description: Optional for Extra Credit. Adds a Magazine class, which
//              inherits from Book and has an additional issue_number
//              attribute.

package assignments.assignment4;

public class Magazine extends Book
{
	final int issueNumber;
	
	public Magazine(String title,
	                String author,
	                String isbn,
	                int yearPublished,
	                int issueNumber)
	{
		super(title, author, isbn, yearPublished);
		this.issueNumber = issueNumber;
	}
	
	@Override
	public String getBookType()
	{
		return "Magazine";
	}
}
