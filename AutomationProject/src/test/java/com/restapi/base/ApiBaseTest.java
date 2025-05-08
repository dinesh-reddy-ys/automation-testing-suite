package com.restapi.base;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiBaseTest {
	protected RequestSpecification requestSpec;
	
	@BeforeMethod
	public void setup() {
		
	requestSpec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
			
	}

}
