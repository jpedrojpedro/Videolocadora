package Interface;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NonEditableTable extends JTable
{
	public NonEditableTable ( DefaultTableModel table )
	{
		super(table);
	}
	
	public boolean isCellEditable ( int row, int column )
	{
		return false;
	}
}