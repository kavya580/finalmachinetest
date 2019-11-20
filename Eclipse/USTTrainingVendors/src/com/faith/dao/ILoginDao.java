package com.faith.dao;

public interface ILoginDao {

	//verification of username and password for login
	public abstract boolean verifyUser(String username, String password);

}