package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Client;
import Model.CityOptions;

public class ClientServices
{
	public ClientServices () {}
	
	public ClientServices ( Client client )
	{
		int sex;
		
		SqlManager sql = new SqlManager( "VideoStore.db" );
		
		if ( client.isMan() )
			sex = 1;
		else
			sex = 0;
		
		sql.executeCommand( "INSERT INTO Client ( Name, Cpf, Address, Neighbor, City, isMan, Telphone, " +
							"Cellphone ) VALUES ( '" + client.getName() + "', '" + client.getCpf() + "', '" + 
							client.getAddress() + "', '" + client.getNeighbor() + "', '" + 
							client.getCity().getCity() + "', '" + sex + "', '" + client.getTelphone() + 
							"', '" + client.getCellphone() +"' )"
						  );
	}
	
	public ArrayList<Client> getAll() throws SQLException
	{
		SqlManager sql = new SqlManager( "VideoStore.db" );
		ResultSet result = sql.executeRead( "SELECT * FROM Client" );
		ArrayList<Client> clients = new ArrayList<Client>();
		
		while ( result.next() )
		{
			boolean isMan;
			CityOptions city;
			
			if ( result.getInt( "isMan" ) == 1 )
				isMan = true;
			else
				isMan = false;
			if ( result.getString( "City" ).equals(CityOptions.Rio_de_Janeiro.getCity() ) )
				city = CityOptions.Rio_de_Janeiro;
			else if ( result.getString( "City" ).equals(CityOptions.Sao_Paulo.getCity() ) )
				city = CityOptions.Sao_Paulo;
			else
				city = CityOptions.Brasilia;
			
			Client c = new Client ( result.getInt("Id"), result.getString( "Name" ), 
									result.getString( "Cpf" ), result.getString( "Address" ), 
									result.getString( "Neighbor" ), city, isMan, 
									result.getString( "Telphone" ), result.getString( "Cellphone" ) );
			clients.add(c);
		}
		
		result.close();
		
		return clients;
    }
}
