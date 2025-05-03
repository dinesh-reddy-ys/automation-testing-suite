package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.utils.CreateUserAndGetUserId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.restapi.utils.BaseTest;

public class UpdateBookTest extends BaseTest {
	
	@Test
	public void updateBooking()  {
		
		// Create a new booking
		Response response = createBooking();
		
		// Extract the booking ID from the response
		int bookingId = response.jsonPath().getInt("bookingid");
		
		System.out.println("Booking ID 2: " + bookingId);
		
		// Create a JSON object for the updated booking details
		JSONObject updatedBookingDetails = new JSONObject();
		updatedBookingDetails.put("firstname", "Arya");
		updatedBookingDetails.put("lastname", "stark");
		updatedBookingDetails.put("totalprice", 1000);
		updatedBookingDetails.put("depositpaid", true);
		
		JSONObject bookingDates = new JSONObject();
		bookingDates.put("checkin", "2023-10-01");
		bookingDates.put("checkout", "2023-10-10");
		
		updatedBookingDetails.put("bookingdates", bookingDates);
		updatedBookingDetails.put("additionalneeds", "Breakfast");
		
		// Send a PUT request to update the booking
		Response updateResponse = RestAssured.given().auth().preemptive().basic("admin", "password123")
				.contentType(ContentType.JSON)
				.body(updatedBookingDetails.toString())
				.put("https://restful-booker.herokuapp.com/booking/"+bookingId);
		updateResponse.print();
		
		
		/**
		 *
		 * {
    "firstname" : "James",
    "lastname" : "Brown"
}
		 * 
		 */
		
		
		System.out.println("Update Response: " + updateResponse.asString());
		Assert.assertEquals(updateResponse.getStatusCode(), 200, "Status code should be 200");
		Assert.assertEquals(updateResponse.jsonPath().getString("firstname"), "Arya", "First name should be updated");
		Assert.assertEquals(updateResponse.jsonPath().getString("lastname"), "stark", "Last name should be updated");
		Assert.assertEquals(updateResponse.jsonPath().getInt("totalprice"), 1000, "Total price should be updated");
		Assert.assertEquals(updateResponse.jsonPath().getBoolean("depositpaid"), true, "Deposit paid should be updated");
		
	}

}
