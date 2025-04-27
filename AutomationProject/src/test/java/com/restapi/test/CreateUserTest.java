package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.restapi.utils.CreateUserAndGetUserId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserTest {

	@Test
	public void createUser() {
		
		CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
		// Extract the user ID from the response
		String userID = createUser.createUserAndGetUserId();
		// Print the user ID
		System.out.println("User ID: " + userID);
		
	
		
		

		
		// Assert the response code
		 //Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		

	}

}
