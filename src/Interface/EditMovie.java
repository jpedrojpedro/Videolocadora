package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Handler.CloseWindowHandler;
import Handler.EditMovieHandler;
import Model.Movie;
import Model.MovieType;

public class EditMovie extends Window
{
	int id;
	JLabel nameLabel = new JLabel ( "Nome do Filme: " );
	JLabel typeLabel = new JLabel ( "Tipo: " );
	JLabel synopsisLabel = new JLabel ( "Sinopse: " );
	JTextField nameBox = new JTextField ( 20 );
	JComboBox typeCombo = new JComboBox ();
	JTextArea synopsisArea = new JTextArea( 10, 20 );
	JScrollPane synopsisScroll = new JScrollPane(synopsisArea);
	JButton confirmButton = new JButton ( "OK" );
	JPanel panelWrap = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelType = new JPanel();
	JPanel panelSynopsis = new JPanel();
	JPanel panelConfirm = new JPanel();
	
	public EditMovie ( int windowWidth, int windowHeight, Movie movie )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Alteracao do Cadastro de Filme");
		this.addWindowListener( new CloseWindowHandler() );
		this.setId(movie.getId());
		Container windowContaint = getContentPane();
		windowContaint.add(panelWrap);
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		panelName.setLayout( new FlowLayout() );
		panelName.add(nameLabel);
		this.setNameBox(movie.getName());
		panelName.add(nameBox);
		panelType.setLayout( new FlowLayout() );
		panelType.add(typeLabel);
		typeCombo.addItem(MovieType.DVD.getMovie());
		typeCombo.addItem(MovieType.VHS.getMovie());
		typeCombo.addItem(MovieType.BlueRay.getMovie());
		typeCombo.setEditable(false);
		this.setTypeCombo(movie.getType().getMovie());
		panelType.add(typeCombo);
		panelSynopsis.setLayout( new FlowLayout() );
		panelSynopsis.add(synopsisLabel);
		synopsisArea.setLineWrap(true);
		this.setSynopsisArea(movie.getSynopsis());
		panelSynopsis.add(synopsisScroll);
		panelConfirm.setLayout( new FlowLayout() );
		panelConfirm.add(confirmButton);
		panelWrap.add(panelName);
		panelWrap.add(panelType);
		panelWrap.add(panelSynopsis);
		panelWrap.add(panelConfirm);
		confirmButton.addActionListener( new EditMovieHandler( this ) );
	}

	public String getNameBox()
	{
		return this.nameBox.getText();
	}

	public String getTypeCombo()
	{
		return this.typeCombo.getSelectedItem().toString();
	}

	public String getSynopsisArea()
	{
		return this.synopsisArea.getText();
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setNameBox( String name )
	{
		this.nameBox.setText(name);
	}

	public void setTypeCombo( String type )
	{
		this.typeCombo.setSelectedItem(type);
	}

	public void setSynopsisArea( String synopsis )
	{
		this.synopsisArea.setText(synopsis);
	}
	
	public void setId( int id )
	{
		this.id = id;
	}

	public void clearNameBox()
	{
		this.nameBox.setText( "" );
	}

	public void clearTypeCombo()
	{
		this.typeCombo.setSelectedItem(null);
	}

	public void clearSynopsisArea()
	{
		this.synopsisArea.setText( "" );
	}
}
