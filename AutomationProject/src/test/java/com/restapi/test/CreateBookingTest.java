package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.restapi.utils.BaseTest;

public class CreateBookingTest extends BaseTest {
	
	@Test
	public void createBookingTest() {
		createBooking();
		Response response = createBooking();
		System.out.println("Response: " + response.asString());
	}

	

}
