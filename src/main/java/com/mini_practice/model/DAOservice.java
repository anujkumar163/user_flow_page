package com.mini_practice.model;

import java.sql.ResultSet;

public interface DAOservice {
	public void connectDB();

	public boolean verifycredential(String email, String password);

	public void createRegistration(String name, String city, String email, String mobile);

	public ResultSet getAllReg();

	public void deleteReg(String email);

	public void updateReg(String email, String mobile);
}
