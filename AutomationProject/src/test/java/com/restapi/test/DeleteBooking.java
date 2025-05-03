package com.restapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.utils.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBooking extends BaseTest {
	
	
	@Test
	public void deleteBooking()  {
		// Create a new booking
		Response response = createBooking();
		
		// Extract the booking ID from the response
		int bookingId = response.jsonPath().getInt("bookingid");
		
		System.out.println("Booking ID 4: " + bookingId);
		
		// Send a DELETE request to delete the booking
		Response deleteResponse = RestAssured.given().auth().preemptive().basic("admin", "password123")
				.delete("https://restful-booker.herokuapp.com/booking/"+bookingId);
		
		System.out.println("Delete Response: " + deleteResponse.asString());
		
		Assert.assertEquals(deleteResponse.getStatusCode(), 201, "Status code should be 201");
		
	}

}
