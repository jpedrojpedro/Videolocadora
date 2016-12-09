package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.MovieController;
import Interface.ReportMovie;

public class DeleteMovieHandler implements ActionListener
{
	private ReportMovie window;
	
	public DeleteMovieHandler ( ReportMovie window )
	{
		this.window = window;
	}

	public void actionPerformed ( ActionEvent e )
	{
		boolean deletar = true;
		MovieController mc = new MovieController ( this.window.getLine(), deletar );
	}
}