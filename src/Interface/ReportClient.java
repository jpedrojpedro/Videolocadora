package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Handler.CloseWindowHandler;
import Handler.ReportClientHandler;

public class ReportClient extends Window
{
	DefaultTableModel clientModel = new DefaultTableModel();
	NonEditableTable clientTable = new NonEditableTable(clientModel);
	JScrollPane movieScroll = new JScrollPane(clientTable);
	JButton closeButton = new JButton( "Fechar" );
	JPanel panelWrap = new JPanel();
	JPanel panelClose = new JPanel();
	JPanel panelTable = new JPanel();
	
	public ReportClient ( int windowWidth, int windowHeight )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Relatorio de Clientes");
		this.addWindowListener( new CloseWindowHandler() );
		this.addWindowListener( new ReportClientHandler(this) );
		Container windowContaint = getContentPane();
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		clientModel.addColumn( "ID" );
		clientModel.addColumn( "CPF" );
		clientModel.addColumn( "Nome" );
		clientModel.addColumn( "Endereco" );
		clientModel.addColumn( "Bairro" );
		clientModel.addColumn( "Cidade" );
		clientModel.addColumn( "Sexo" );
		clientModel.addColumn( "Telefone" );
		clientModel.addColumn( "Celular" );
		clientTable.getTableHeader().setReorderingAllowed(false);
		clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clientTable.getColumn("ID").setWidth(0);
		clientTable.getColumn("ID").setMinWidth(0);
		clientTable.getColumn("ID").setMaxWidth(0);
		panelTable.setLayout( new BoxLayout(panelTable, BoxLayout.Y_AXIS) );
		panelTable.add(movieScroll);
		panelClose.setLayout( new FlowLayout() );
		panelClose.add(closeButton);
		panelWrap.add(panelTable);
		panelWrap.add(panelClose);
		windowContaint.add(panelWrap);
		closeButton.addActionListener( new ReportClientHandler( this ) );
	}
	
	public void insertRow ( int position, int id, String cpf, String name, String address, String neighbor, 
							String city, String sex, String tel, String cel )
	{
		Object row[] = {id, cpf, name, address, neighbor, city, sex, tel, cel};
		this.clientModel.insertRow( position, row );
	}
}
