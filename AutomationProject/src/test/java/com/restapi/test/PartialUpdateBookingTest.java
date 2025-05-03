package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.utils.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdateBookingTest extends BaseTest {
	
	//Create a new booking
	Response response = createBooking();
	//Extract the booking ID from the response
	//Create a JSON object for the updated booking details
	@Test
	public void partialUpdateBooking()  {
		//Create a new booking
		Response response = createBooking();
		//Extract the booking ID from the response
		int bookingId = response.jsonPath().getInt("bookingid");
		
		System.out.println("Booking ID 3: " + bookingId);
		//Create a JSON object for the updated booking details
		JSONObject updatedBookingDetails = new JSONObject();
		updatedBookingDetails.put("firstname", "Arya");
		updatedBookingDetails.put("lastname", "reddy");
		
		// Send a PATCH request to partially update the booking
		Response updateResponse = RestAssured.given().auth().preemptive().basic("admin", "password123")
				.contentType(ContentType.JSON)
				.body(updatedBookingDetails.toString())
				.patch("https://restful-booker.herokuapp.com/booking/"+bookingId);
		
		System.out.println("Partial Update Response: " + updateResponse.asString());
		
		Assert.assertEquals(updateResponse.getStatusCode(), 200, "Status code should be 200");
		// Verify the updated details
		String updatedFirstName = updateResponse.jsonPath().getString("firstname");
		String updatedLastName = updateResponse.jsonPath().getString("lastname");
		Assert.assertEquals(updatedFirstName, "Aryaa", "First name should be updated to Arya");
		Assert.assertEquals(updatedLastName, "reddys", "Last name should be updated to reddy");
		
	}
	

}
