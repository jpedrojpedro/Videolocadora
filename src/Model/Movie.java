package Model;

public class Movie
{
	private int id;
	private String name;
	private MovieType type;
	private String synopsis;
	
	public Movie ( int id, String name, MovieType type, String synopsis )
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.synopsis = synopsis;
	}
	
	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public MovieType getType()
	{
		return type;
	}

	public void setType(MovieType type)
	{
		this.type = type;
	}

	public String getSynopsis()
	{
		return synopsis;
	}

	public void setSynopsis(String synopsis)
	{
		this.synopsis = synopsis;
	}
}