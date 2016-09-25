package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	 private Connection connect = null;

	public Database() throws ClassNotFoundException, SQLException {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
	      // Setup the connection with the DB
		String url="jdbc:mysql://localhost:3306/localization_db?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String password="1234";
		connect = DriverManager.getConnection(url,username,password);
//	    connect = DriverManager
//	          .getConnection("jdbc:mysql://localhost:3306/localization_db?"
//	              + "user=root&password=1234");
	}


	  public Connection getConnect() {
		return connect;
	}

	  // You need to close the resultSet
	  private void close() {
	    try {
	      
	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
}
