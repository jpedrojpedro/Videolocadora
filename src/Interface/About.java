package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Handler.CloseWindowHandler;

public class About extends Window
{
	JLabel aboutLabel = new JLabel( "Sistema Locadora Revolucao v1.0" );
	JPanel panelWrap = new JPanel();
	
	public About (int windowWidth, int windowHeight)
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Informacao sobre o Sistema");
		this.addWindowListener( new CloseWindowHandler() );
		Container windowContaint = getContentPane();
		windowContaint.add(panelWrap);
		panelWrap.setLayout( new FlowLayout() );
		panelWrap.add(aboutLabel);
	}
}
