package cp.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cp.helpers.*;
public class ControlUser {
	
	
	PropertiesReader prop = new PropertiesReader(); 
	ConnectionDB conn = new ConnectionDB();
	Connection con = conn.getConn();

	public String registerUser(String name, int age, int ci, String username, String email, String pass) throws IOException {
		String query = prop.getValue("db.register.user");
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, ci);
			pstmt.setString(4, username);
			pstmt.setString(5, email);
			pstmt.setString(6, pass);
			int rowsInserted = pstmt.executeUpdate();
			if(rowsInserted > 0) {
				System.out.println("Usuario creado");
				return "registrado";
			} else {
				System.out.println("Error");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	public String loginUser(String user, String pass) throws IOException {
		String query = prop.getValue("db.login.user");
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("User successfully logged");
				return "accessed";
			} else {
				System.out.println("Error");
				System.out.println("soy un error en el login");
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return query;		
	}
	
}
