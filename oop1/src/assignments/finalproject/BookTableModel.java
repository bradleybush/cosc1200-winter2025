package assignments.finalproject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel
{
	private final String[] columnNames = {
		"Title",
		"Author",
		"ISBN",
		"Category",
		"Issued?",
	};
	ArrayList<Book> books;
	
	public BookTableModel(ArrayList<Book> books)
	{
		this.books = books;
	}
	
	@Override
	public int getRowCount()
	{
		return books.size();
	}
	
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Book book = books.get(rowIndex);
		return switch (columnNames[columnIndex])
		{
			case "Title" -> book.getTitle();
			case "Author" -> book.getAuthor();
			case "ISBN" -> book.getIsbn();
			case "Category" -> book.getCategory();
			case "Issued?" -> book.isIssued();
			default -> "";
		};
	}
}
