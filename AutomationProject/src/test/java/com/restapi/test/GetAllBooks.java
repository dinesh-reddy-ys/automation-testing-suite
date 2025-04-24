package com.restapi.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllBooks {
	
	@Test
	// Test method to fetch all books from the API
	public void getAllBooks() {
		
		// Send a GET request to the specified endpoint
		Response response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		
		// Assert that the response status code is 200 (OK)
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		
		// Extract the titles of all books from the JSON response
		Object booksTitle = response.jsonPath().getString("books.isbn");
		
		// Convert the extracted book titles to an ArrayList
		ArrayList<String> booksTitleList = (ArrayList<String>) booksTitle;
		// Print the size of the book titles list to the console		
		//System.out.println("Size of books title list: " + booksTitleList.size());
		// Print the first book title to the console
		//System.out.println("First book title: " + booksTitleList.get(0));
		
		// Assert that the size of the book titles list is greater than 0
		Assert.assertTrue(booksTitleList.size() > 0, "Book title list should not be empty");
		
		
	}

}


}
