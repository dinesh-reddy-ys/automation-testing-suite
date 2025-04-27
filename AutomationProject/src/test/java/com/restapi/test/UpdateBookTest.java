package com.restapi.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.utils.CreateUserAndGetUserId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateBookTest {
	
	@Test
	// Test method to update a book in the API
	public void updateBook() {
		
		// Create a new user and get the user ID
		CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
		String userID = createUser.createUserAndGetUserId();
		
		// Create json body for updating the book
		JSONObject body = new JSONObject();
		body.put("userName", "test"+System.currentTimeMillis());
		body.put("isbn", "9781449325862");
		body.put("collectionOfIsbns", new JSONArray().put("9781449325862"));
		
		System.out.println("UserName: "+body.get("userName"));
		
		// Send a PUT request to update the book
		Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.put("https://demoqa.com/Account/v1/User/" + userID);
		
		System.out.println("Response: "+response.asString());
		
		// Assert that the response status code is 200 (OK)
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		
	}

}
