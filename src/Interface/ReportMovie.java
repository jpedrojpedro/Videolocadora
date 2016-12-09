package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Handler.CloseWindowHandler;
import Handler.DeleteMovieHandler;
import Handler.ReportMovieHandler;
import Handler.SelectMovieHandler;

public class ReportMovie extends Window
{
	DefaultTableModel movieModel = new DefaultTableModel();
	NonEditableTable movieTable = new NonEditableTable(movieModel);
	JScrollPane movieScroll = new JScrollPane(movieTable);
	JButton closeButton = new JButton( "Fechar" );
	Icon editIcon = new ImageIcon("img/edit.png", "Editar");
	Icon deleteIcon = new ImageIcon("img/delete.png", "Deletar");
	JButton editButton = new JButton ( editIcon );
	JButton deleteButton = new JButton ( deleteIcon );
	JPanel panelWrap = new JPanel();
	JPanel panelClose = new JPanel();
	JPanel panelTable = new JPanel();
	JPanel panelOptions = new JPanel();
	
	public ReportMovie ( int windowWidth, int windowHeight )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Relatorio de Filmes");
		this.addWindowListener( new CloseWindowHandler() );
		this.addWindowListener( new ReportMovieHandler(this) );
		Container windowContaint = getContentPane();
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		movieModel.addColumn("ID");
		movieModel.addColumn( "Nome" );
		movieModel.addColumn( "Tipo" );
		movieModel.addColumn( "Sinopse" );
		movieTable.getTableHeader().setReorderingAllowed(false);
		movieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		movieTable.getColumn("ID").setWidth(0);
		movieTable.getColumn("ID").setMinWidth(0);
		movieTable.getColumn("ID").setMaxWidth(0);
		panelOptions.setLayout( new FlowLayout() );
		panelOptions.add(editButton);
		panelOptions.add(deleteButton);
		panelTable.setLayout( new BoxLayout(panelTable, BoxLayout.Y_AXIS) );
		panelTable.add(movieScroll);
		panelClose.setLayout( new FlowLayout() );
		panelClose.add(closeButton);
		panelWrap.add(panelOptions);
		panelWrap.add(panelTable);
		panelWrap.add(panelClose);
		windowContaint.add(panelWrap);
		closeButton.addActionListener( new ReportMovieHandler( this ) );
		editButton.addActionListener( new SelectMovieHandler( this ) );
		deleteButton.addActionListener( new DeleteMovieHandler( this ) );
	}
	
	public void insertRow ( int position, int id, String name, String type, String synopsis )
	{
		Object row[] = {id, name, type, synopsis};
		this.movieModel.insertRow( position, row );
	}
	
	public String[] getLine ()
	{
		int rowId = this.movieTable.getSelectedRow();
		
		if ( rowId == -1 )
		{
			JOptionPane.showMessageDialog(null, "Selecione algum filme");
			return null;
		}
		else
		{
			String row[] = {this.movieTable.getValueAt(rowId, 0).toString(), 
							this.movieTable.getValueAt(rowId, 1).toString(), 
							this.movieTable.getValueAt(rowId, 2).toString(), 
							this.movieTable.getValueAt(rowId, 3).toString()};
			return row;
		}
	}
}
