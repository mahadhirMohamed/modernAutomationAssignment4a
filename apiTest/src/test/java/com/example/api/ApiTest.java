package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {
	/**
	 * Technical Debt:
	 * - The POST request test lacks proper error handling.
	 * - Future improvements: Add detailed response validation, handle non-201 status codes,
	 *   and implement data-driven testing.
	 */
	@Test
	public void testGetRequest() {
		 // Temporary solution: Verifying basic attributes only
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
	    Assert.assertEquals(response.getStatusCode(), 200, "Unexpected status code!");
	    Assert.assertNotNull(response.getBody(), "Response body is null!");
	    Assert.assertTrue(response.getBody().asString().contains("userId"), "Field 'userId' not found!");
	}

	/**Adding a new test method to test all posts:*/
	@Test
	public void testAllPosts() {
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
	    Assert.assertEquals(response.getStatusCode(), 200, "Unexpected status code!");
	    Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0, "No posts found in response!");
	}

	/**Adding a test for a POST request*/
	@Test
	public void testPostRequest() {
		
		 // Adding additional assertions for response validation
	    // Known issue: This endpoint occasionally fails under load
	    Response response = RestAssured.given()
	        .contentType("application/json")
	        .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
	        .post("https://jsonplaceholder.typicode.com/posts");
	    Assert.assertEquals(response.getStatusCode(), 201, "Post creation failed!");
	}
}
