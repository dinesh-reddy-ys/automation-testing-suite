package com.restapi.utils;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserAndGetUserId {
	
	// Create user and get user ID
	public String createUserAndGetUserId() {
		
		AccountCreation accountCreation = new AccountCreation();
		
		// Create json body
		JSONObject body = new JSONObject();
		body.put("userName", accountCreation.createUniqueUserName());
		body.put("password", "Test@143");
		
		System.out.println("UserName: "+body.get("userName"));

		Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.post("https://demoqa.com/Account/v1/user");

		// Extract the user ID from the response
		String userID = response.jsonPath().getString("userID");
		
		return userID;
		
	}
	
	public void createUserAccount(String userName, String password) {
		
		// Create json body
		JSONObject body = new JSONObject();
		body.put("userName",userName);
		body.put("password", password);
		
		
		System.out.println("UserName: "+body.get("userName"));

		Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.post("https://demoqa.com/Account/v1/user");

		response.print();
		
	}
	
	
	
	
	
	
	

}
