package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Controller.MovieController;
import Interface.InterfaceTypes;
import Interface.ReportMovie;
import Main.Main;

public class ReportMovieHandler extends WindowAdapter implements ActionListener
{
	private ReportMovie window;
	
	public ReportMovieHandler ( ReportMovie window )
	{
		this.window = window;
	}
	
	public void windowOpened ( WindowEvent e)
	{
		MovieController mc = new MovieController( this.window );
	}

	public void actionPerformed ( ActionEvent e )
	{
		this.window.setVisible(false);
		Main.changeVisibility(InterfaceTypes.MainPage);
	}
}