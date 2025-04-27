package com.restapi.utils;

public class AccountCreation {
	
	//Method to create a unique user name
		public String createUniqueUserName() {
			String userName = "test" + System.currentTimeMillis();
			return userName;
		}
		
		public String createUniquePassword() {
			String password = "Test@" + System.currentTimeMillis();
			return password;
		}

}
