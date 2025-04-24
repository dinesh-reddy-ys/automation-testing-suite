package com.restapi.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserTest {

	@Test
	public void createUser() {
		// Create json body
		JSONObject body = new JSONObject();
		body.put("userName", "test1129");
		body.put("password", "Test@143");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.post("https://demoqa.com/Account/v1/user");

		//response.print();
		String userID = response.jsonPath().getString("userID");

		System.out.println(userID);
		// Assert the response code
		 Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		

	}

}
