package assignments.finalproject;

import javax.swing.*;
import java.util.ArrayList;

public class BookTable extends JTable
{
	public BookTable(ArrayList<Book> books)
	{
		super(new BookTableModel(books));
	}
}
