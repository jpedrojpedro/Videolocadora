package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Interface.Authentication;
import Interface.InterfaceTypes;
import Interface.MainPage;
import Interface.Window;
import Main.Main;

public class AuthenticationHandler implements ActionListener
{
	private Authentication window;
	
	public AuthenticationHandler ( Authentication window )
	{
		this.window = window;
	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( verifyFields ( this.window ) )
		{
			this.window.clearLoginBox();
			this.window.clearPasswordBox();
			this.window.setVisible(false);
			Window mp = new MainPage(400, 300);
			Main.mainPage = mp;
			Main.changeVisibility(InterfaceTypes.MainPage);
		}
		else
		{
			JOptionPane.showMessageDialog ( this.window, "Senha incorreta" );
			this.window.clearLoginBox();
			this.window.clearPasswordBox();
		}
	}
	
	private boolean verifyFields ( Authentication window )
	{
		if ( window.getLoginBox().equals( Main.login ) && window.getPasswordBox().equals( Main.password ) )
			return true;
		else
			return false;
	}
}