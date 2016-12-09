package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.ClientController;
import Interface.InterfaceTypes;
import Interface.SubscribeClient;
import Main.Main;

public class SubscribeClientHandler implements ActionListener
{
	private SubscribeClient window;
	
	public SubscribeClientHandler ( SubscribeClient window )
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent e)
	{
		ClientController cc = new ClientController( this.window );
	}
}