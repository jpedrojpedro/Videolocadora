package Model;

public enum MovieType
{
	VHS ( "VHS" ),
	DVD ( "DVD" ),
	BlueRay ( "BlueRay" );
	
	private String movie;
	
	MovieType ( String movie )
	{
		this.movie = movie;
	}
	
	public String getMovie ()
	{
		return this.movie;
	}
}