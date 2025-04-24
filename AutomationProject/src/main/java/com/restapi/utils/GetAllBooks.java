package com.restapi.utils;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllBooks {
	
	
		
		// Get all books
		public String getAllBooks() {
			Response response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
			
			// Assert the response code
			//Assert.assertEquals(response.getStatusCode(), 200,"Status code should be 200, but it's not");
			
			String booksTitle = response.jsonPath().getString("books.title");
			
			return booksTitle;
		}
		
		
	

}
