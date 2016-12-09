package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Handler.CloseWindowHandler;
import Handler.SubscribeClientHandler;
import Model.CityOptions;

public class SubscribeClient extends Window 
{
	JLabel cpfLabel = new JLabel ( "CPF: " );
	JLabel nameLabel = new JLabel ( "Nome: " );
	JLabel addressLabel = new JLabel ( "Endereco: " );
	JLabel neighborLabel = new JLabel ( "Bairro: " );
	JLabel phoneLabel = new JLabel ( "Telefone Residencial: " );
	JLabel cellLabel = new JLabel ( "Telefone Celular: " );
	JLabel cityLabel = new JLabel ( "Cidade: " );
	JLabel sexLabel = new JLabel ( "Sexo: " );
	JFormattedTextField cpfBox = null;
	JTextField nameBox = new JTextField ( 20 );
	JTextField addressBox = new JTextField ( 20 );
	JTextField neighborBox = new JTextField ( 20 );
	JFormattedTextField phoneBox = null;
	JFormattedTextField cellBox = null;
	MaskFormatter cpfMask = null;
	MaskFormatter telMask = null;
	MaskFormatter celMask = null;
	JComboBox cityCombo = new JComboBox ();
	ButtonGroup sexRadio = new ButtonGroup();
	JRadioButton menSexItem = new JRadioButton( "Homem" );
	JRadioButton womanSexItem = new JRadioButton( "Mulher" );
	JButton confirmButton = new JButton ( "OK" );
	JPanel panelWrap = new JPanel();
	JPanel panelCpf = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelAddress = new JPanel();
	JPanel panelNeighbor = new JPanel();
	JPanel panelTel = new JPanel();
	JPanel panelCell = new JPanel();
	JPanel panelCity = new JPanel();
	JPanel panelSex = new JPanel();
	JPanel panelConfirm = new JPanel();
	
	public SubscribeClient ( int windowWidth, int windowHeight )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Cadastro de Cliente");
		this.addWindowListener( new CloseWindowHandler() );
		Container windowContaint = getContentPane();
		windowContaint.add(panelWrap);
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		panelCpf.setLayout( new FlowLayout() );
		try
		{
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setPlaceholderCharacter('_');
		}
		catch(ParseException e)
		{
		}
		cpfBox = new JFormattedTextField(cpfMask);
		panelCpf.add(cpfLabel);
		panelCpf.add(cpfBox);
		panelName.setLayout( new FlowLayout() );
		panelName.add(nameLabel);
		panelName.add(nameBox);
		panelAddress.setLayout( new FlowLayout() );
		panelAddress.add(addressLabel);
		panelAddress.add(addressBox);
		panelNeighbor.setLayout( new FlowLayout() );
		panelNeighbor.add(neighborLabel);
		panelNeighbor.add(neighborBox);
		panelCity.setLayout( new FlowLayout() );
		panelCity.add(cityLabel);
		cityCombo.addItem(CityOptions.Rio_de_Janeiro.getCity());
		cityCombo.addItem(CityOptions.Sao_Paulo.getCity());
		cityCombo.addItem(CityOptions.Brasilia.getCity());
		cityCombo.setEditable(false);
		panelCity.add(cityCombo);
		panelSex.setLayout( new FlowLayout() );
		sexRadio.add(menSexItem);
		sexRadio.add(womanSexItem);
		panelSex.add(sexLabel);
		panelSex.add(menSexItem);
		panelSex.add(womanSexItem);
		panelTel.setLayout( new FlowLayout() );
		try
		{
			telMask = new MaskFormatter("(##)####-####");
			telMask.setPlaceholderCharacter('_');
		}
		catch(ParseException e)
		{
		}
		phoneBox = new JFormattedTextField(telMask);
		panelTel.add(phoneLabel);
		panelTel.add(phoneBox);
		panelCell.setLayout( new FlowLayout() );
		try
		{
			celMask = new MaskFormatter("(##)####-####");
			celMask.setPlaceholderCharacter('_');
		}
		catch(ParseException e)
		{
		}
		cellBox  = new JFormattedTextField(celMask);
		panelCell.add(cellLabel);
		panelCell.add(cellBox);
		panelConfirm.setLayout( new FlowLayout() );
		panelConfirm.add(confirmButton);
		panelWrap.add(panelCpf);
		panelWrap.add(panelName);
		panelWrap.add(panelAddress);
		panelWrap.add(panelNeighbor);
		panelWrap.add(panelCity);
		panelWrap.add(panelSex);
		panelWrap.add(panelTel);
		panelWrap.add(panelCell);
		panelWrap.add(panelConfirm);
		confirmButton.addActionListener( new SubscribeClientHandler ( this ) );
	}

	public String getCpfBox()
	{
		return this.cpfBox.getText();
	}

	public String getNameBox()
	{
		return this.nameBox.getText();
	}

	public String getAddressBox()
	{
		return this.addressBox.getText();
	}

	public String getNeighborBox()
	{
		return this.neighborBox.getText();
	}

	public String getPhoneBox()
	{
		return this.phoneBox.getText();
	}

	public String getCellBox()
	{
		return this.cellBox.getText();
	}

	public String getCityCombo()
	{
		return this.cityCombo.getSelectedItem().toString();
	}

	public String getSexRadio()
	{
		if ( this.menSexItem.isSelected() )
			return this.menSexItem.getText();
		if ( this.womanSexItem.isSelected() )
			return this.womanSexItem.getText();
		return null;
	}
	
	public void clearCpfBox()
	{
		this.cpfBox.setText( "" );
	}

	public void clearNameBox()
	{
		this.nameBox.setText( "" );
	}

	public void clearAddressBox()
	{
		this.addressBox.setText( "" );
	}

	public void clearNeighborBox()
	{
		this.neighborBox.setText( "" );
	}

	public void clearPhoneBox()
	{
		this.phoneBox.setText( "" );
	}

	public void clearCellBox()
	{
		this.cellBox.setText( "" );
	}

	public void clearCityCombo()
	{
		this.cityCombo.setSelectedItem(null);
	}

	public void clearSexRadio()
	{
		this.menSexItem.setSelected(false);
		this.womanSexItem.setSelected(false);
	}
}
