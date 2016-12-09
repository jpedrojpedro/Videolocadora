package Model;

public enum CityOptions
{
	Rio_de_Janeiro ( "Rio de Janeiro" ),
	Sao_Paulo ( "Sao Paulo" ),
	Brasilia ( "Brasilia" );
	
	private final String city;
	
	CityOptions ( String city)
	{
		this.city = city;
	}
	
	public String getCity ()
	{
		return this.city;
	}
}
