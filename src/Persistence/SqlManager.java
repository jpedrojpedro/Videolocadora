package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SqlManager
{
	private Connection conn;
	
	public SqlManager ( String dbPath )
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog( null, "Problemas de conexao! -- Path" );
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog( null, "Problemas de conexao! -- JDBC" );
		}
	}
	
	public ResultSet executeRead ( String query )
	{
		Statement stat;
		ResultSet result = null;
		String sql;
		
		sql = query.toString();
		
		try
		{
			stat = this.conn.createStatement();
			result = stat.executeQuery(sql);
			return result;
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog( null, "Sintaxe de consulta incorreta -- executeReader" );
		}		
		return result;
	}
	
	public void executeCommand ( String query )
	{
		Statement stat;
		String sql;
		int affectedRows;
		
		sql = query.toString();
		
		// the query will return just the number of affected rows
		try
		{
			stat = this.conn.createStatement();
			affectedRows = stat.executeUpdate(sql);
			stat.close();
			JOptionPane.showMessageDialog( null, affectedRows + " Linha(s) Modificada(s)" );
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog( null, "Problemas na query -- executeCommand" );
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}
	}
	
	protected void finalize() throws Throwable
	{
		// does the connection exist?
		if ( !this.conn.isClosed() )
			// close connection with database
			this.conn.close();
	}
}
