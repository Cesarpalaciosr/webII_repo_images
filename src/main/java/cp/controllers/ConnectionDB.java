package cp.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
Connection conn = null;
	 
	public ConnectionDB() {
		
		String driver = "org.postgresql.Driver";
/*		
		String url = "jdbc:postgresql://localhost:5432/dbprueba";
		String user = "postgres";
		String password = "masterkey";
*/
		String url = "jdbc:postgresql://ec2-3-222-11-129.compute-1.amazonaws.com:5432/de511gfgus123n?sslmode=require";
		String user = "tryqteclkftanp";
		String password = "05db7b52ac66289538be68d886f33753a8839d2de5c81f0272ec20f8760a8fd8" ;
	
		try {
			Class.forName(driver);
				
			conn = DriverManager.getConnection(url, user, password);
			
			if(conn != null) {
				System.out.println("Successfully connected to PostgreSQL");
			} else {
				System.out.println("Unable to connect to PostgreSQL");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public Connection getConn() {
		return conn;
	}

}
