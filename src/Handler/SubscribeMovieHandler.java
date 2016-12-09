package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.MovieController;
import Interface.SubscribeMovie;

public class SubscribeMovieHandler implements ActionListener
{
	private SubscribeMovie window;
	
	public SubscribeMovieHandler ( SubscribeMovie window )
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent e)
	{
		MovieController mc = new MovieController( this.window );
	}
}