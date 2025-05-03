package com.restapi.utils;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {
	
	protected Response createBooking() {
		//Create JSON body for booking
		JSONObject body = new JSONObject();
		body.put("firstname", "dinesh");
		body.put("lastname", "Doe");
		body.put("totalprice", 150);
		body.put("depositpaid", false);
		//body.put("bookingdates", new JSONObject().put("checkin", "2023-10-01").put("checkout", "2023-10-10"));
		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2023-10-01");
		bookingdates.put("checkout", "2023-10-10");
		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Breakfast");
		
		// Send POST request to create booking
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(body.toString())
				.post("https://restful-booker.herokuapp.com/booking");
		
		// Assert that the response status code is 200 (OK)
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code should be 200, but it's not");
		
		// Extract the booking ID from the response
		int bookingId = response.jsonPath().getInt("bookingid");
		System.out.println("Booking ID 1: " + bookingId);
		Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");
		return response;
	}

}
