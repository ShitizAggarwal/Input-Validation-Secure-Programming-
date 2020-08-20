

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static String DB_DRIVER;
	private static String DB_CONNECTION;
	private static String DB_USER;
	private static String DB_PASSWORD;
	private static SQLConnection single_instance = null;

	public SQLConnection() {
		DB_DRIVER = "com.mysql.jdbc.Driver";
		DB_CONNECTION = "jdbc:mysql://localhost:3306/sp_shitiz?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		DB_USER = "root";
		DB_PASSWORD = "Robin#ood710";
		getDBConnection("");
	} 

	
	 Connection dbConnection = null;
	

	public Connection getDBConnection() {
		return dbConnection;
	}

	private  Connection getDBConnection(String overload) {

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbConnection;
	}

	
}