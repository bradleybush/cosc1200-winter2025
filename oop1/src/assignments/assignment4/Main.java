// Author:      Bradley Bush
// Date:        8 April 2025
// Activity:    Assignment 4: Inheritance and Data Structure
// File:        Main.java
// Description: Applies inheritance in an Object-Oriented Program.
//              
//              A library requires a system to manage books, categorize
//              them into different genres, and handle borrowing and
//              returning operations efficiently. This system utilizes
//              OOP principles (inheritance, method overriding,
//              polymorphism) along with stack, queue, and linked list
//              to track books and borrowing operations.
//              
//              Additional Challenge (Optional for Extra Credit):
//              - Adds a Magazine class, which inherits from Book and
//                has an additional issue_number attribute.
//              - Implements a search feature that allows users to find
//                books by title, author, or genre using a dictionary.

package assignments.assignment4;

import java.util.*;

public class Main
{
	private static final Stack<Book> returnHistory = new Stack<>();
	private static final Queue<BookBorrowRequest> borrowRequests =
		new LinkedList<>();
	private static final List<Book> availableBooks = new LinkedList<>();
	private static final Map<String, ArrayList<Book>> titleDict =
		new HashMap<>();
	private static final Map<String, ArrayList<Book>> authorDict =
		new HashMap<>();
	private static final Map<String, ArrayList<Book>> genreDict =
			new HashMap<>();
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// ---------
		// Add books
		// ---------
		addBook(new BorrowableBook(
			"The Great Gatsby",
			"F. Scott Fitzgerald",
			"12345",
			1925,
			"Mystery"
		));
		addBook(new NonFictionBook(
			"A Brief History of Time",
			"Stephen Hawking",
			"67890",
			1988,
			"Science"
		));
		addBook(new ReferenceBook(
			"Encyclopedia Britannica",
			"William Smellie et al.",
			"55555",
			1768
		));
		addBook(new Magazine(
			"The Magazine",
			"Magazine Writer",
			"54321",
			2025,
			10
		));
		
		// -----------------------
		// Display available books
		// -----------------------
		displayAvailableBooks();
		
		// -------------------
		// Add borrow requests
		// -------------------
		borrowRequests.add(new BookBorrowRequest("The Great Gatsby", "Alice"));
		borrowRequests.add(new BookBorrowRequest(
			"Encyclopedia Britannica",
			"Bob"
		));
		
		// -----------------------
		// Process borrow requests
		// -----------------------
		System.out.println("\nProcessing Borrow Requests:");
		while (!borrowRequests.isEmpty())
		{
			BookBorrowRequest borrowRequest = borrowRequests.poll();
			String requesterName = borrowRequest.requesterName;
			String bookName = borrowRequest.bookName;
			System.out.println(
				"\n" + requesterName + " requested \"" + bookName + "\"..."
			);
			processBorrowRequest(borrowRequest);
		}
		
		// ------------------------
		// Books currently borrowed
		// ------------------------
		displayBorrowedBooks();
		
		// ----------------
		// Returning a book
		// ----------------
		System.out.println("\nReturning a Book:");
		Book bookToReturn = availableBooks.getFirst();
		returnBook(bookToReturn);
		
		// ---------------------------
		// Most Recently Returned Book
		// ---------------------------
		System.out.println("\nMost Recently Returned Book:");
		Book returnedBook = returnHistory.pop();
		System.out.println(returnedBook.title);
		
		// -------------------------------------------------------------
		// Optional for Extra Credit. Implement a search feature that
		// allows users to find books by title, author, or genre using a
		// dictionary.
		// -------------------------------------------------------------
		boolean finishedSearching = false;
		String choice;
		while (!finishedSearching)
		{
			System.out.print("\nWould you like to search? (y/n): ");
			choice = scanner.nextLine().trim();
			if (choice.equals("n"))
			{
				// "n"
				finishedSearching = true;
			}
			else if (!choice.equals("y"))
			{
				// Invalid choice
				System.out.println(
					"Invalid choice. Please enter only \"y\" OR \"n\"."
				);
			}
			else
			{
				// "y"
				searchForBookFromUser();
			}
		}
	}
	
	private static void addBook(Book book)
	{
		availableBooks.add(book);
		// Update search dictionaries
		titleDict.putIfAbsent(book.title, new ArrayList<>());
		titleDict.get(book.title).add(book);
		authorDict.putIfAbsent(book.author, new ArrayList<>());
		authorDict.get(book.author).add(book);
		if (book instanceof FictionBook)
		{
			genreDict.putIfAbsent(
				((FictionBook) book).genre,
				new ArrayList<>()
			);
			genreDict.get(((FictionBook) book).genre).add(book);
		}
	}
	
	private static void displayAvailableBooks()
	{
		System.out.println("\nAvailable Books:");
		for (Book book : availableBooks)
		{
			System.out.println();  // Newline for separation
			book.displayInfo();
		}
	}
	
	private static void displayBorrowedBooks()
	{
		System.out.println("\nBooks Currently Borrowed:");
		for (Book book : availableBooks)
		{
			if (book instanceof BorrowableBook)
			{
				if (((BorrowableBook) book).isBorrowed)
				{
					System.out.println();  // Newline for separation
					book.displayInfo();
				}
			}
		}
	}
	
	private static void processBorrowRequest(BookBorrowRequest request)
	{
		// Loop through available books
		for (Book book : availableBooks)
		{
			// Check for matching book name
			if (book.title.equals(request.bookName))
			{
				// Check if book is borrowable and borrow it if so
				if (book instanceof BorrowableBook)
				{
					((BorrowableBook) book).borrow(request.requesterName);
					System.out.println("Book borrowed successfully!");
				}
				else
				{
					System.out.println("This book cannot be borrowed.");
				}
				return;
			}
		}
		// No book matched in available books
		System.out.println("Book \"" + request.bookName + "\" not available.");
	}
	
	private static void returnBook(Book book)
	{
		((BorrowableBook) book).returnBook();
		returnHistory.push(book);
		String borrowerName = ((BorrowableBook) book).borrowerName;
		System.out.println(borrowerName + " returned \"" + book.title + "\".");
	}
	
	private static void searchForBookFromUser()
	{
		String choice;
		System.out.println("1. Title");
		System.out.println("2. Author");
		System.out.println("3. Genre");
		System.out.print("Enter your search filter choice: ");
		choice = scanner.nextLine().trim();
		switch (choice)
		{
			case "1":
				// Title
				System.out.print("Enter the book title: ");
				String title = scanner.nextLine();
				if (!titleDict.containsKey(title))
				{
					System.out.println("Could not find \"" + title + "\"!");
				}
				else
				{
					titleDict.get(title).getFirst().displayInfo();
				}
				break;
			case "2":
				// Author
				System.out.print("Enter the book author: ");
				String author = scanner.nextLine();
				if (!authorDict.containsKey(author))
				{
					System.out.println("Could not find \"" + author + "\"!");
				}
				else
				{
					authorDict.get(author).getFirst().displayInfo();
				}
				break;
			case "3":
				// Genre
				System.out.print("Enter the book genre: ");
				String genre = scanner.nextLine();
				if (!genreDict.containsKey(genre))
				{
					System.out.println("No \"" + genre + "\" books found!");
				}
				else
				{
					genreDict.get(genre).getFirst().displayInfo();
				}
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
		System.out.println();  // Newline for separation
	}
}
