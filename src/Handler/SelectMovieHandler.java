package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.MovieController;
import Interface.ReportMovie;

public class SelectMovieHandler implements ActionListener
{
	private ReportMovie window;
	
	public SelectMovieHandler ( ReportMovie window )
	{
		this.window = window;
	}

	public void actionPerformed ( ActionEvent e )
	{
		boolean deletar = false;
		MovieController mc = new MovieController ( this.window.getLine(), deletar );
	}
}