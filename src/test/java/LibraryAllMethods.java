import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import Pojo.bookRespPojo;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LibraryAllMethods {
	
	
	RequestSpecification reqGiven= new RequestSpecBuilder().
											setBaseUri("https://rahulshettyacademy.com").
											setContentType(ContentType.JSON).build();
	
	ResponseSpecification respThen= new ResponseSpecBuilder().expectStatusCode(200).build();
	
		//Add book
		public Response addBook(String resource, String isbn) {
		ApiResources apiResource= ApiResources.valueOf(resource);
		HashMap<String, Object>  map = new HashMap<>();
		map.put("name", "This is test data");
		map.put("isbn", isbn);
		map.put("aisle", "132");
		map.put("author", "Vivek Pandey");	
		
		Response resp= 		given().spec(reqGiven).
									body(map).
							when().
									post(apiResource.getResource()).
							then().
									spec(respThen).
									body("ID", StringContains.containsString((String) map.get("isbn")+(String) map.get("aisle"))).
									extract().response();

		return resp;
	}
	
	//Get data
	public Response getBook(String resource, String id) {
		ApiResources apiResource= ApiResources.valueOf(resource);
		
		Response resp= 		given().
								spec(reqGiven).
								queryParam("ID", id).
							when()
								.get(apiResource.getResource()).
							then()
								.spec(respThen)
								.extract().response();
		return resp;
		
	}
	
	//Delete book
	public Response deleteBook(String resource,String id) {
		
		ApiResources apiResource= ApiResources.valueOf(resource);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("ID", id);
		
		Response resp= 		given()
									.spec(reqGiven)
									.body(map).
							when()
									.delete(apiResource.getResource()).
							then()
									.spec(respThen)
									.extract().response();
		return resp;
	}
}
