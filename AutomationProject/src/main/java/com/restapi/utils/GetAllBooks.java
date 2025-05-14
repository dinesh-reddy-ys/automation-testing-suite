package com.restapi.utils;



import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllBooks {
	
	
		
		// Get all books
		public String getAllBooks() {
			Response response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
			
			// Assert the response code
			//Assert.assertEquals(response.getStatusCode(), 200,"Status code should be 200, but it's not");
			
			String booksTitle = response.jsonPath().getString("books.title");
			
			// Convert the extracted book titles to an ArrayList
			List<Object> booksTitleList = response.jsonPath().getList("books.title");
			System.out.println(booksTitleList);
			//Print first 5 book titles
			for (int i = 0; i < 5; i++) {
				System.out.println(booksTitleList.get(i));
			}
			return booksTitle;
		}
		
		
	

}
