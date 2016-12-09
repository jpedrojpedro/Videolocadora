package Main;

import java.sql.SQLException;
import Interface.Authentication;
import Interface.InterfaceTypes;
import Interface.Window;

public class Main
{
	public static final String login = "admin";
	public static final String password = "admin123";
	public static Window authentication;
	public static Window mainPage;
	public static Window subscribeClient;
	public static Window subscribeMovie;
	public static Window reportClient;
	public static Window reportMovie;
	public static Window editMovie;
	public static Window about;
	
	public static void main(String[] args) throws SQLException
	{	
		authentication = new Authentication(250, 150);
		authentication.setVisible(true);
	}
	
	public static void changeVisibility ( InterfaceTypes type )
	{
		if ( type == InterfaceTypes.Authentication )
		{
			if ( authentication.isVisible() )
				authentication.setVisible(false);
			else
				authentication.setVisible(true);
		}
		
		if ( type == InterfaceTypes.MainPage )
		{
			if ( mainPage.isVisible() )
				mainPage.setVisible(false);
			else
				mainPage.setVisible(true);
		}
		
		if ( type == InterfaceTypes.SubscribeClient )
		{
			if ( subscribeClient.isVisible() )
				subscribeClient.setVisible(false);
			else
				subscribeClient.setVisible(true);
		}
		
		if ( type == InterfaceTypes.SubscribeMovie )
		{
			if ( subscribeMovie.isVisible() )
				subscribeMovie.setVisible(false);
			else
				subscribeMovie.setVisible(true);
		}
		
		if ( type == InterfaceTypes.ReportClient )
		{
			if ( reportClient.isVisible() )
				reportClient.setVisible(false);
			else
				reportClient.setVisible(true);
		}
		
		if ( type == InterfaceTypes.ReportMovie )
		{
			if ( reportMovie.isVisible() )
				reportMovie.setVisible(false);
			else
				reportMovie.setVisible(true);
		}
		
		if ( type == InterfaceTypes.EditMovie )
		{
			if ( editMovie.isVisible() )
				editMovie.setVisible(false);
			else
				editMovie.setVisible(true);
		}
		
		if ( type == InterfaceTypes.About )
		{
			if ( about.isVisible() )
				about.setVisible(false);
			else
				about.setVisible(true);
		}

	}
}