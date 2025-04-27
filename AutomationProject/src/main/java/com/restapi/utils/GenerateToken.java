package com.restapi.utils;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenerateToken {
	
	// Method to generate a token
	public String getToken() {
		AccountCreation accountCreation = new AccountCreation();
		//print user name and password
		System.out.println("username: "+accountCreation.createUniqueUserName());
		System.out.println("password:"+ accountCreation.createUniquePassword());
				
		//json body
		JSONObject body = new JSONObject();
		body.put("userName", accountCreation.createUniqueUserName());
		body.put("password", accountCreation.createUniquePassword());
		
		//post request to generate token
	    Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.post("https://demoqa.com/Account/v1/GenerateToken");
	    
	    // Extract the token from the response
	    String token = response.jsonPath().getString("token");
		
		System.out.println("Token: "+token);
		return token;
		
		
	}
	
	public static void main(String[] args) {
		GenerateToken generateToken = new GenerateToken();
		generateToken.getToken();
	}

}
