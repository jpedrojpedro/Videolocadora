package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Movie;
import Model.MovieType;

public class MovieServices
{
	public MovieServices () {}
	
	public MovieServices ( Movie movie )
	{	
		SqlManager sql = new SqlManager( "VideoStore.db" );
		
		sql.executeCommand( "INSERT INTO Movie ( Name, Type, Sinopsis ) VALUES ( '" 
							+ movie.getName() + "', '" + movie.getType().getMovie() + "', '" 
							+ movie.getSynopsis() + "' )"
						  );
	}
	
	public MovieServices ( int id )
	{
		SqlManager sql = new SqlManager( "VideoStore.db" );
		
		sql.executeCommand( "DELETE FROM Movie WHERE ID = '" + id + "'" );
	}
	
	public MovieServices ( Movie movie, int id )
	{
		SqlManager sql = new SqlManager( "VideoStore.db" );
		
		sql.executeCommand( "UPDATE Movie SET Name = '" + movie.getName() + "', Type = '" 
							+ movie.getType().getMovie() + "', Sinopsis = '" + movie.getSynopsis() + "'" 
							+ " WHERE ID = '" + id + "'" 
						  );
	}
	
	public ArrayList<Movie> getAll() throws SQLException
	{
		SqlManager sql = new SqlManager( "VideoStore.db" );
		ResultSet result = sql.executeRead( "SELECT * FROM Movie" );
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		while ( result.next() )
		{
			MovieType movie;
			
			if ( result.getString( "Type" ).equals(MovieType.BlueRay.getMovie() ) )
				movie = MovieType.BlueRay;
			else if ( result.getString( "Type" ).equals(MovieType.VHS.getMovie() ) )
				movie = MovieType.VHS;
			else
				movie = MovieType.DVD;
			
			Movie m = new Movie ( result.getInt("Id"), result.getString( "Name" ), 
								  movie, result.getString( "Sinopsis" ) );
			movies.add(m);
		}
		
		result.close();
		
		return movies;
    }
}