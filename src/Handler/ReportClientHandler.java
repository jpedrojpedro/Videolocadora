package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Interface.InterfaceTypes;
import Interface.ReportClient;
import Main.Main;
import Controller.ClientController;

public class ReportClientHandler extends WindowAdapter implements ActionListener
{
	private ReportClient window;
	
	public ReportClientHandler ( ReportClient window )
	{
		this.window = window;
	}
	
	public void windowOpened ( WindowEvent e)
	{
		ClientController cc = new ClientController( this.window );
	}

	public void actionPerformed ( ActionEvent e )
	{
		this.window.setVisible(false);
		Main.changeVisibility(InterfaceTypes.MainPage);
	}
}