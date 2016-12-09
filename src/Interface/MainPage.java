package Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import Handler.MainPageHandler;

public class MainPage extends Window
{
	JMenuBar mainMenuBar = new JMenuBar();
	JMenu fileMenu = new JMenu( "Arquivo" );
	JMenu subscribeMenu = new JMenu( "Cadastros" );
	JMenu reportMenu = new JMenu( "Relatorios" );
	JMenu aboutMenu = new JMenu( "Sobre" );
	JMenuItem subsClientItem = new JMenuItem( "Cadastro de Clientes" );
	JMenuItem subsMovieItem = new JMenuItem( "Cadastro de Filmes" );
	JMenuItem reportClientItem = new JMenuItem( "Relatorio de Clientes" );
	JMenuItem reportMovieItem = new JMenuItem( "Relatorio de Filmes" );
	JMenuItem fileCloseItem = new JMenuItem( "Fechar" );
	Icon logoIcon = new ImageIcon("img/logoLocRev.png", "Locadora Revolucao");
	JLabel logoLabel = new JLabel();
	JLabel nomeLabel = new JLabel("Sistema \n Locadora Revolucao");
	JPanel panelMenu = new JPanel();
	JPanel panelLogo = new JPanel();
	JPanel panelNome = new JPanel();
	JPanel panelWrap = new JPanel();
	
	public MainPage ( int windowWidth, int windowHeight )
	{
		super ( windowWidth, windowHeight );
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Locadora Revolucao");
		this.addWindowListener( new MainPageHandler( this ) );
		Container windowContaint = getContentPane();
		windowContaint.add(panelWrap);
		panelWrap.setLayout( new BoxLayout(panelWrap, BoxLayout.Y_AXIS) );
		mainMenuBar.add(fileMenu);
		mainMenuBar.add(subscribeMenu);
		mainMenuBar.add(reportMenu);
		mainMenuBar.add(aboutMenu);
		subscribeMenu.add(subsClientItem);
		subscribeMenu.add(subsMovieItem);
		reportMenu.add(reportClientItem);
		reportMenu.add(reportMovieItem);
		fileMenu.add(fileCloseItem);
		panelMenu.setLayout( new FlowLayout() );
		panelMenu.add(mainMenuBar);
		panelLogo.setLayout( new FlowLayout() );
		logoLabel.setIcon(logoIcon);
		panelLogo.add(logoLabel);
		panelNome.setLayout( new FlowLayout() );
		panelNome.add(nomeLabel);
		panelWrap.add(panelMenu);
		panelWrap.add(panelLogo);
		panelWrap.add(panelNome);
		fileCloseItem.addActionListener( new MainPageHandler ( this ) );
		aboutMenu.addMouseListener( new MainPageHandler ( this ) );
		subsClientItem.addActionListener( new MainPageHandler ( this ) );
		subsMovieItem.addActionListener( new MainPageHandler ( this ) );
		reportClientItem.addActionListener( new MainPageHandler ( this ) );
		reportMovieItem.addActionListener( new MainPageHandler ( this ) );
	}
}
