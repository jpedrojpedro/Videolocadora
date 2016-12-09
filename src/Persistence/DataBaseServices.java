package Persistence;

public class DataBaseServices
{
	public DataBaseServices ()
	{
		SqlManager create = new SqlManager( "VideoStore.db" );
		create.executeCommand( "DROP TABLE IF EXISTS Client" );
		create.executeCommand( "DROP TABLE IF EXISTS Movie" );
		create.executeCommand( "CREATE TABLE IF NOT EXISTS Client (ID INTEGER PRIMARY KEY, Name TEXT, " +
							   "Cpf TEXT, Address TEXT, Neighbor TEXT, City TEXT, isMan INT, Telphone TEXT, " +
							   "Cellphone TEXT )" );
		create.executeCommand( "CREATE TABLE IF NOT EXISTS Movie (ID INTEGER PRIMARY KEY, Name TEXT, " +
							   "Type TEXT, Sinopsis TEXT )" );
	}
}