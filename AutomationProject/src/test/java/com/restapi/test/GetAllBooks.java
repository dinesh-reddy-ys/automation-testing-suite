package com.restapi.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapi.base.ApiBaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetAllBooks extends ApiBaseTest {

	@Test
	// Test method to fetch all books from the API
	public void getAllBooks() {
		
		
		
//		// Send a GET request to the specified endpoint
		//Response response = RestAssured.get("/booking");
		Response response = RestAssured.given().
				spec(requestSpec).
				when().get("/booking");
		response.prettyPrint();
		
		
		//given().spec(requestSpec).when().get("/booking").then().log().all();
		
		// Assert that the response status code is 200 (OK)
		//Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		
		// Extract the titles of all books from the JSON response
		//String booksTitle = response.jsonPath();
		//System.out.println(booksTitle);
		// Convert the extracted book titles to an ArrayList
		
		// Assert that the size of the book titles list is greater than 0
		//Assert.assertTrue(booksTitleList.size() > 0, "Book title list should not be empty");
		
	     
	}

}
