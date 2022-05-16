package com.mini_practice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOserviceImp implements DAOservice {
	private Connection con;
	private Statement stmt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","anujabhay");
			stmt=con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public boolean verifycredential(String email, String password) {
		try {
			ResultSet result = stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void createRegistration(String name, String city, String email, String mobile) {
		try {
			stmt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stmt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void deleteReg(String email) {
		try {
			stmt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateReg(String email, String mobile) {
		try {
			stmt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
