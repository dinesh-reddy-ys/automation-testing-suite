package com.restapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.utils.CreateUserAndGetUserId;
import com.restapi.utils.GenerateToken;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserTest {
	
	@Test
	// Test method to get user details
	public void getUser() {
		
		// Create a new user and get the user ID
		CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
		String userID = createUser.createUserAndGetUserId();
		//String userID = "6fff30c3-064e-4169-a259-63e516518211"; // Example user ID, replace with actual ID
		//get token from the response
		GenerateToken generateToken = new GenerateToken();
		
		String token = generateToken.getToken();
		System.out.println("UserID: "+userID);
		
		// Send a GET request to fetch user details
		Response response = RestAssured.given().header("Authorization","Bearer "+token).get("https://demoqa.com/Account/v1/User/" + userID);
		
		System.out.println("Response: "+response.asString());
		
		// Assert that the response status code is 200 (OK)
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		
	}

}
