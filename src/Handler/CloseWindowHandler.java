package Handler;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Interface.InterfaceTypes;
import Main.Main;

public class CloseWindowHandler extends WindowAdapter
{
	public void windowClosing ( WindowEvent e )
	{
		if ( e.getWindow().toString().contains("Alteracao") )
			Main.changeVisibility(InterfaceTypes.ReportMovie);
		else
			Main.changeVisibility(InterfaceTypes.MainPage);
	}
}
