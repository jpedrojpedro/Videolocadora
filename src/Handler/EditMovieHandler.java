package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.MovieController;
import Interface.EditMovie;

public class EditMovieHandler implements ActionListener
{
	private EditMovie window;
	
	public EditMovieHandler ( EditMovie window )
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent e)
	{
		MovieController mc = new MovieController( this.window );
	}
}