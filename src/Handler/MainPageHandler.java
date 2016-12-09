package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import Interface.About;
import Interface.InterfaceTypes;
import Interface.MainPage;
import Interface.ReportClient;
import Interface.ReportMovie;
import Interface.SubscribeClient;
import Interface.SubscribeMovie;
import Interface.Window;
import Main.Main;

public class MainPageHandler extends MouseAdapter implements ActionListener, WindowListener
{
	private MainPage window;
	
	public MainPageHandler ( MainPage window )
	{
		this.window = window;
	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource().toString().contains( "Fechar" ) )
		{
			Object[] options = {"Sim", "Nao"};
			int n = JOptionPane.showOptionDialog ( null, 
												   "Tem certeza que deseja fechar o programa?", 
												   "Mensagem",
												   JOptionPane.YES_NO_OPTION,
												   JOptionPane.QUESTION_MESSAGE,
												   null,     //do not use a custom Icon
												   options,  //the titles of buttons
												   options[0]); //default button title
			if ( n == 0 )
			{
				this.window.setVisible(false);
				System.exit(0);
			}
		}
		
		if ( e.getSource().toString().contains( "Cadastro de Clientes" ) )
		{
			this.window.setVisible(false);
			Window sc = new SubscribeClient(400, 400);
			Main.subscribeClient = sc;
			Main.changeVisibility(InterfaceTypes.SubscribeClient);
		}
		
		if ( e.getSource().toString().contains( "Cadastro de Filmes" ) )
		{
			this.window.setVisible(false);
			Window sm = new SubscribeMovie(400, 400);
			Main.subscribeMovie = sm;
			Main.changeVisibility(InterfaceTypes.SubscribeMovie);
		}
		
		if ( e.getSource().toString().contains( "Relatorio de Filmes" ) )
		{
			this.window.setVisible(false);
			Window rm = new ReportMovie(800, 600);
			Main.reportMovie = rm;
			Main.changeVisibility(InterfaceTypes.ReportMovie);
		}
		
		if ( e.getSource().toString().contains( "Relatorio de Clientes" ) )
		{
			this.window.setVisible(false);
			Window rc = new ReportClient(800, 600);
			Main.reportClient = rc;
			Main.changeVisibility(InterfaceTypes.ReportClient);
		}
	}
	
	public void mouseClicked ( MouseEvent e )
	{
		if ( e.getSource().toString().contains( "Sobre" ) )
		{
			this.window.setVisible(false);
			Window a = new About(300, 60);
			Main.about = a;
			Main.changeVisibility(InterfaceTypes.About);
		}
	}

	public void windowActivated(WindowEvent e)
	{}

	public void windowClosed(WindowEvent e)
	{}

	public void windowClosing(WindowEvent e)
	{
		Object[] options = {"Sim", "Nao"};
		int n = JOptionPane.showOptionDialog ( null, 
											   "Tem certeza que deseja fechar o programa?", 
											   "Mensagem",
											   JOptionPane.YES_NO_OPTION,
											   JOptionPane.QUESTION_MESSAGE,
											   null,     //do not use a custom Icon
											   options,  //the titles of buttons
											   options[0]); //default button title
		if ( n == 0 )
		{
			this.window.setVisible(false);
			System.exit(0);
		}
	}

	public void windowDeactivated(WindowEvent e){}
	
	public void windowDeiconified(WindowEvent e){}

	public void windowIconified(WindowEvent e){}

	public void windowOpened(WindowEvent e){}
}
