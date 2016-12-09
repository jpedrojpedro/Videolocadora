package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Handler.AuthenticationHandler;

public class Authentication extends Window
{
	JLabel loginLabel = new JLabel ( "Login: " );
	JTextField loginBox = new JTextField ( 15 );
	JLabel passwordLabel = new JLabel ( "Senha: " );
	JPasswordField passwordBox = new JPasswordField ( 15 );
	JButton confirmButton = new JButton ( "OK" );
	JPanel panelLogin = new JPanel();
	JPanel panelPassword = new JPanel();
	JPanel panelConfirm = new JPanel();
	JPanel panelWrap = new JPanel();
	
	public Authentication ( int windowWidth, int windowHeight )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Locadora Revolucao");
		Container windowContaint = getContentPane();
		windowContaint.add(panelWrap);
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		panelLogin.setLayout( new FlowLayout() );
		panelLogin.add(loginLabel);
		panelLogin.add(loginBox);
		panelPassword.setLayout( new FlowLayout() );
		passwordBox.setEchoChar('*');
		panelPassword.add(passwordLabel);
		panelPassword.add(passwordBox);
		panelConfirm.add(confirmButton);
		panelWrap.add(panelLogin);
		panelWrap.add(panelPassword);
		panelWrap.add(panelConfirm);
		confirmButton.addActionListener( new AuthenticationHandler ( this ) );
	}
	
	public String getLoginBox ()
	{
		return this.loginBox.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPasswordBox ()
	{
		return this.passwordBox.getText();
	}
	
	public void clearLoginBox ()
	{
		this.loginBox.setText( "" );
	}
	
	public void clearPasswordBox ()
	{
		this.passwordBox.setText( "" );
	}
}
