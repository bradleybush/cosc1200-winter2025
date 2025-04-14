// Author:      Bradley Bush
// Date:        12 April 2025
// Activity:    Project: User Interface
// File:        Main.java
// Description: A Library Management System using Java Swing for GUI
//              and Object-Oriented Programming principles for backend
//              logic. Allows users to manage books, issue and return
//              them, and persist data using file operations. Includes a
//              clean, interactive user interface and modular code
//              structure.

package assignments.finalproject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main
{
	private static final String FILENAME = "books.dat";
	private static final Library library = new Library();
	private static final BookTable bookTable =
		new BookTable(library.getBooks());
	private static final JFrame frame =
		new JFrame("Library Management System");
	
	public static void main(String[] args)
	{
		// -------------
		// Set up window
		// -------------
		frame.setSize(640, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ---------------
		// Create menu bar
		// ---------------
		createMenuBar();
		
		// --------------
		// Create toolbar
		// --------------
		createToolBar();
		
		// -----------------
		// Create book table
		// -----------------
		frame.add(new JScrollPane(bookTable), BorderLayout.CENTER);
		// -----------------
		
		// Attempt to autoload previously saved library data on startup
		load();
		
		frame.setVisible(true);
	}
	
	private static void createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		// File
		JMenu file = new JMenu("File");
		menuBar.add(file);
		// Help
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		// File > Open
		JMenuItem fileOpen = new JMenuItem("Open");
		file.add(fileOpen);
		fileOpen.addActionListener(e -> open());
		// File > Save
		JMenuItem fileSave = new JMenuItem("Save");
		file.add(fileSave);
		fileSave.addActionListener(e -> save());
		// File > Exit
		JMenuItem fileExit = new JMenuItem("Exit");
		file.add(fileExit);
		fileExit.addActionListener(e -> exit());
		// File > About
		JMenuItem helpAbout = new JMenuItem("About");
		help.add(helpAbout);
		helpAbout.addActionListener(e -> showAbout());
	}
	
	private static void createToolBar()
	{
		JToolBar toolbar = new JToolBar();
		frame.add(toolbar, BorderLayout.SOUTH);
		// Add book
		JButton addBook = new JButton("Add book");
		toolbar.add(addBook);
		addBook.addActionListener(e -> addBookFromUser());
		// Issue book
		JButton issueBook = new JButton("Issue book");
		toolbar.add(issueBook);
		issueBook.addActionListener(e -> issueBookFromUser());
		// Return book
		JButton returnBook = new JButton("Return book");
		toolbar.add(returnBook);
		returnBook.addActionListener(e -> returnBookFromUser());
		// Exit
		JButton toolbarExit = new JButton("Exit");
		toolbar.add(toolbarExit);
		toolbarExit.addActionListener(e -> exit());
	}
	
	// Loads library data from file.
	private static boolean load()
	{
		// Read the data from the input file
		ArrayList<Book> loadedBooks = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(
			new FileReader(FILENAME)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				// Create a new book with the data from the current
				// input file line and add it to the library
				String[] cols = line.split(",");
				String title = cols[0];
				String author = cols[1];
				String isbn = cols[2];
				String category = cols[3];
				loadedBooks.add(new Book(title, author, isbn, category));
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: File not found or cannot be read.");
			System.out.println(e.getMessage());
			return false;  // Loading failed
		}
		
		// Rebuild the library data
		library.clear();
		for (Book loadedBook : loadedBooks)
		{
			library.addBook(loadedBook);
		}
		bookTable.repaint();
		
		return true;  // Loading successful
	}
	
	// Opens file dialog to load data.
	private static void open()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Are you sure?"));
		int result = JOptionPane.showConfirmDialog(
			frame,
			panel,
			"Open",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		if (result == JOptionPane.NO_OPTION)
		{
			return;
		}
		
		boolean loadSuccess = load();
		if (loadSuccess)
		{
			showSuccess();
		}
		else
		{
			showFailure();
		}
	}
	
	// Saves current library data to file.
	private static void save()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Are you sure?"));
		int result = JOptionPane.showConfirmDialog(
			frame,
			panel,
			"Save",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		if (result == JOptionPane.NO_OPTION)
		{
			// --
			// No
			// --
			return;
		}
		
		// ---
		// Yes
		// ---
		
		// Write the data to the output file
		try (BufferedWriter writer = new BufferedWriter(
			new FileWriter(FILENAME)))
		{
			// Loop through books list
			for (Book book : library.getBooks())
			{
				// Write the book to a line in the file
				writer.write(book.getTitle() + ",");
				writer.write(book.getAuthor() + ",");
				writer.write(book.getIsbn() + ",");
				writer.write(book.getCategory() + "\n");
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: Unable to write to file.");
			System.out.println(e.getMessage());
			// Fail
			showFailure();
			return;
		}
		// Success
		showSuccess();
	}
	
	// Exits the program with a confirmation message.
	private static void exit()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Are you sure?"));
		int result = JOptionPane.showConfirmDialog(
				frame,
				panel,
				"Exit",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
		);
		if (result == JOptionPane.YES_OPTION)
		{
			// Exit the program
			System.exit(0);
		}
	}
	
	// Shows a form to let the user add a new book with fields.
	private static void addBookFromUser()
	{
		// ---------------
		// Create the form
		// ---------------
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		
		// -----
		// Title
		// -----
		JTextField titleField = new JTextField();
		JPanel titleRow = new JPanel(new BorderLayout(5, 5));
		JLabel titleLabel = new JLabel("Title:", SwingConstants.RIGHT);
		titleLabel.setPreferredSize(new Dimension(80, 25));
		titleRow.add(titleLabel, BorderLayout.WEST);
		titleRow.add(titleField, BorderLayout.CENTER);
		formPanel.add(titleRow);
		
		// ------
		// Author
		// ------
		JTextField authorField = new JTextField();
		JPanel authorRow = new JPanel(new BorderLayout(5, 5));
		JLabel authorLabel = new JLabel("Author:", SwingConstants.RIGHT);
		authorLabel.setPreferredSize(new Dimension(80, 25));
		authorRow.add(authorLabel, BorderLayout.WEST);
		authorRow.add(authorField, BorderLayout.CENTER);
		formPanel.add(authorRow);
		
		// ----
		// ISBN
		// ----
		JTextField isbnField = new JTextField();
		JPanel isbnRow = new JPanel(new BorderLayout(5, 5));
		JLabel isbnLabel = new JLabel("ISBN:", SwingConstants.RIGHT);
		isbnLabel.setPreferredSize(new Dimension(80, 25));
		isbnRow.add(isbnLabel, BorderLayout.WEST);
		isbnRow.add(isbnField, BorderLayout.CENTER);
		formPanel.add(isbnRow);
		
		// --------
		// Category
		// --------
		JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup categoryGroup = new ButtonGroup();
		// Literature
		JRadioButton literature = new JRadioButton("Literature");
		categoryGroup.add(literature);
		categoryPanel.add(literature);
		// Science
		JRadioButton science = new JRadioButton("Science");
		categoryGroup.add(science);
		categoryPanel.add(science);
		// History
		JRadioButton history = new JRadioButton("History");
		categoryGroup.add(history);
		categoryPanel.add(history);
		// Other
		JRadioButton other = new JRadioButton("Other");
		categoryGroup.add(other);
		categoryPanel.add(other);
		// Add to form
		JPanel categoryRow = new JPanel(new BorderLayout(5, 5));
		JLabel categoryLabel = new JLabel("Category:", SwingConstants.RIGHT);
		categoryLabel.setPreferredSize(new Dimension(80, 25));
		categoryRow.add(categoryLabel, BorderLayout.WEST);
		categoryRow.add(categoryPanel, BorderLayout.CENTER);
		formPanel.add(categoryRow);
		// Set a default selection
		categoryGroup.setSelected(literature.getModel(), true);
		// --------
		
		// Show the input form for user and get their response
		int result = JOptionPane.showConfirmDialog(
			frame,
			formPanel,
			"Enter Book Details",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		
		if (result == JOptionPane.OK_OPTION)
		{
			// User said OK
			
			// Get their inputs for the book fields
			String title = titleField.getText();
			String author = authorField.getText();
			String isbn = isbnField.getText().trim();
			String category = "";
			JRadioButton[] buttons = {literature, science, history, other};
			for (JRadioButton button : buttons)
			{
				if (button.isSelected())
				{
					category = button.getText();
					break;
				}
			}
			
			// Make sure user didn't leave any fields empty
			if (title.trim().isEmpty()
				|| author.trim().isEmpty()
				|| isbn.isEmpty()
				|| category.isEmpty())
			{
				// Fail
				showFailure();
				return;
			}
			
			// Add the book
			Book book = new Book(title, author, isbn, category);
			library.addBook(book);
			bookTable.revalidate();
			bookTable.repaint();
			// Success
			showSuccess();
		}
	}
	
	// Shows a form to let the user issue a book by a given ISBN.
	private static void issueBookFromUser()
	{
		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		// ISBN
		panel.add(new JLabel("ISBN:"));
		JTextField isbnField = new JTextField();
		panel.add(isbnField);
		
		int result = JOptionPane.showConfirmDialog(
			frame,
			panel,
			"Issue Book by ISBN",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		if (result == JOptionPane.OK_OPTION)
		{
			String isbn = isbnField.getText().trim();
			boolean issueSuccess = library.issueBookByIsbn(isbn);
			if (issueSuccess)
			{
				bookTable.revalidate();
				bookTable.repaint();
				showSuccess();
			}
			else
			{
				showFailure();
			}
		}
	}
	
	// Shows a form to let the user return a book by a given ISBN.
	private static void returnBookFromUser()
	{
		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		// ISBN
		panel.add(new JLabel("ISBN:"));
		JTextField isbnField = new JTextField();
		panel.add(isbnField);
		
		int result = JOptionPane.showConfirmDialog(
			frame,
			panel,
			"Return Book by ISBN",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		if (result == JOptionPane.OK_OPTION)
		{
			String isbn = isbnField.getText().trim();
			boolean returnSuccess = library.returnBookByIsbn(isbn);
			if (returnSuccess)
			{
				bookTable.revalidate();
				bookTable.repaint();
				showSuccess();
			}
			else
			{
				showFailure();
			}
		}
	}
	
	// Shows a simple About popup message.
	private static void showAbout()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Made by Bradley Bush."));
		JOptionPane.showMessageDialog(
				frame,
				panel,
				"About",
				JOptionPane.INFORMATION_MESSAGE
		);
	}
	
	// Shows a simple Operation Success popup message.
	private static void showSuccess()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Operation successful!"));
		JOptionPane.showMessageDialog(
			frame,
			panel,
			"Success",
			JOptionPane.INFORMATION_MESSAGE
		);
	}
	
	// Shows a simple Operation Failure popup message.
	private static void showFailure()
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Operation failed!"));
		JOptionPane.showMessageDialog(
			frame,
			panel,
			"Error",
			JOptionPane.ERROR_MESSAGE
		);
	}
}
