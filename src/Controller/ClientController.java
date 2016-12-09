package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.InterfaceTypes;
import Interface.SubscribeClient;
import Interface.ReportClient;
import Main.Main;
import Model.CityOptions;
import Model.Client;
import Persistence.ClientServices;

public class ClientController
{
	public ClientController ( ReportClient rc )
	{
		ClientServices cs = new ClientServices();
		ArrayList<Client> clients = new ArrayList<Client>();
		try
		{
			clients = cs.getAll();
		} 
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		for ( int i = 0; i < clients.size(); i++ )
		{
			String sexo;
			if ( clients.get(i).isMan() )
				sexo = "Homem";
			else
				sexo = "Mulher";
			rc.insertRow( i, clients.get(i).getId(), clients.get(i).getCpf(), clients.get(i).getName(), 
						  clients.get(i).getAddress(), clients.get(i).getNeighbor(), 
						  clients.get(i).getCity().getCity(), sexo, clients.get(i).getTelphone(), 
						  clients.get(i).getCellphone() );
		}
	}
	
	public ClientController ( SubscribeClient sc )
	{
		if ( !this.verifyFields(sc).contains( "OK" ) )
			JOptionPane.showMessageDialog( null, this.verifyFields(sc) );
		else
		{
			boolean isMan;
			CityOptions city;
			int id = 0;
			
			if ( sc.getSexRadio().equals( "Homem" ) )
				isMan = true;
			else
				isMan = false;

			if ( sc.getCityCombo().equals( CityOptions.Rio_de_Janeiro.getCity() ) )
				city = CityOptions.Rio_de_Janeiro;
			else if ( sc.getCityCombo().equals( CityOptions.Sao_Paulo.getCity() ) )
				city = CityOptions.Sao_Paulo;
			else
				city = CityOptions.Brasilia;
			
			Client c = new Client( id,
								   sc.getNameBox(), 
								   sc.getCpfBox(), 
								   sc.getAddressBox(), 
								   sc.getNeighborBox(), 
								   city, 
								   isMan, 
								   sc.getPhoneBox(), 
								   sc.getCellBox()
								  );
			ClientServices cs = new ClientServices( c );
			
			sc.setVisible(false);
			Main.changeVisibility(InterfaceTypes.MainPage);
		}
		
	}
	
	private String verifyFields ( SubscribeClient window )
	{
		if ( window.getCpfBox().contains("_") )
			return "Preencha corretamente o campo cpf";
		else if ( window.getNameBox().isEmpty() )
			return "Preencha corretamente o campo nome";
		else if ( window.getAddressBox().isEmpty() )
			return "Preencha corretamente o campo endereco";
		else if ( window.getNeighborBox().isEmpty() )
			return "Preencha corretamente o campo bairro";
		else if ( window.getCityCombo().isEmpty() )
			return "Selecione corretamente o campo cidade";
		else if ( window.getSexRadio() == null )
			return "Selecione corretamente o campo sexo";
		else if ( window.getPhoneBox().contains("_") )
			return "Preencha corretamente o campo telefone";
		else if ( window.getCellBox().contains("_") )
			return "Preencha corretamente o campo celular";
		else if ( window.getCityCombo().isEmpty() )
			return "Selecione corretamente o campo cidade";
		else
			return "OK";
	}
	
}
