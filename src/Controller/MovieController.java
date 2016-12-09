package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interface.EditMovie;
import Interface.InterfaceTypes;
import Interface.ReportMovie;
import Interface.SubscribeMovie;
import Interface.Window;
import Main.Main;
import Model.Movie;
import Model.MovieType;
import Persistence.MovieServices;

public class MovieController
{
	public MovieController ( ReportMovie rm )
	{
		MovieServices ms = new MovieServices();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try
		{
			movies = ms.getAll();
		} 
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		for ( int i = 0; i < movies.size(); i++ )
		{
			rm.insertRow( i, movies.get(i).getId(), movies.get(i).getName(), 
						  movies.get(i).getType().getMovie(), movies.get(i).getSynopsis() );
		}
	}
	
	public MovieController ( SubscribeMovie sm )
	{
		if ( !this.verifyFields(sm).contains( "OK" ) )
			JOptionPane.showMessageDialog( null, this.verifyFields(sm) );
		else
		{
			MovieType type;
			int id = 0;

			if ( sm.getTypeCombo().equals( MovieType.BlueRay.getMovie() ) )
				type = MovieType.BlueRay;
			else if ( sm.getTypeCombo().equals( MovieType.VHS.getMovie() ) )
				type = MovieType.VHS;
			else
				type = MovieType.DVD;
			
			Movie m = new Movie ( id,
								  sm.getNameBox(),
								  type,
								  sm.getSynopsisArea()
								);
			MovieServices ms = new MovieServices( m );
			
			sm.setVisible(false);
			Main.changeVisibility(InterfaceTypes.MainPage);
		}
		
	}
	
	public MovieController ( EditMovie em )
	{
		if ( !this.verifyFields(em).contains( "OK" ) )
			JOptionPane.showMessageDialog( null, this.verifyFields(em) );
		else
		{
			MovieType type;

			if ( em.getTypeCombo().equals( MovieType.BlueRay.getMovie() ) )
				type = MovieType.BlueRay;
			else if ( em.getTypeCombo().equals( MovieType.VHS.getMovie() ) )
				type = MovieType.VHS;
			else
				type = MovieType.DVD;
			
			Movie m = new Movie ( em.getId(),
								  em.getNameBox(),
								  type,
								  em.getSynopsisArea()
								);
			
			MovieServices ms = new MovieServices( m, em.getId() );
			
			em.setVisible(false);
			Window rm = new ReportMovie(800, 600);
			Main.reportMovie = rm;
			Main.changeVisibility(InterfaceTypes.ReportMovie);
		}
	}
	
	public MovieController ( String row[], boolean delete )
	{
		if ( row != null && delete == false )
		{
			int id = Integer.parseInt(row[0]);
			
			MovieType type;
			
			if ( row[2].equals( MovieType.BlueRay.getMovie() ) )
				type = MovieType.BlueRay;
			else if ( row[2].equals( MovieType.VHS.getMovie() ) )
				type = MovieType.VHS;
			else
				type = MovieType.DVD;
			
			Movie m = new Movie ( id,
					  			  row[1],
					  			  type,
					  			  row[3]
								);
			
			Main.changeVisibility(InterfaceTypes.ReportMovie);
			Window em = new EditMovie(400, 400, m);
			Main.editMovie = em;
			Main.changeVisibility(InterfaceTypes.EditMovie);
		}
		
		if ( row != null && delete == true )
		{
			int id = Integer.parseInt(row[0]);
			Object[] options = {"Sim", "Nao"};
			int n = JOptionPane.showOptionDialog ( null, 
					   "Tem certeza que deseja excluir o filme?", 
					   "Mensagem",
					   JOptionPane.YES_NO_OPTION,
					   JOptionPane.QUESTION_MESSAGE,
					   null,     //do not use a custom Icon
					   options,  //the titles of buttons
					   options[0]); //default button title
			
			if ( n == 0 )
			{
				Main.changeVisibility(InterfaceTypes.ReportMovie);
				
				MovieServices ms = new MovieServices ( id );
				
				Window rm = new ReportMovie(800, 600);
				Main.reportMovie = rm;
				Main.changeVisibility(InterfaceTypes.ReportMovie);
			}
		}
	}
	
	private String verifyFields ( SubscribeMovie window )
	{
		if ( window.getNameBox().isEmpty() )
			return "Preencha corretamente o campo nome";
		else if ( window.getTypeCombo().isEmpty() )
			return "Selecione o tipo de Filme";
		else if ( window.getSynopsisArea().isEmpty() )
			return "Preencha corretamente o campo Sinopse";
		else
			return "OK";
	}
	
	private String verifyFields ( EditMovie window )
	{
		if ( window.getNameBox().isEmpty() )
			return "Preencha corretamente o campo nome";
		else if ( window.getTypeCombo().isEmpty() )
			return "Selecione o tipo de Filme";
		else if ( window.getSynopsisArea().isEmpty() )
			return "Preencha corretamente o campo Sinopse";
		else
			return "OK";
	}
}
