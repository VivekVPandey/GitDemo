package SDET;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetCreatePostDelete {

	static String baseURL="https://reqres.in";
	String createResp="";
	static String id="";
	public static void main(String[] args) {
		
		GetCreatePostDelete ra = new GetCreatePostDelete();
		ra.getusr();
		ra.createUser();
		ra.updateUser();
		ra.deleteUser();

	}
	
	void getusr(){
		
		given()
				.baseUri(baseURL)
		.when()
				.get("api/users/")
		.then()
				.statusCode(200)
				.log().all();
	}
	
	void createUser() {
		
		HashMap<String, Object> data= new HashMap<String, Object>();
		data.put("name", "Vivek");
		data.put("job", "BCI");

		
	createResp=	
		given()
				.baseUri(baseURL)
				.body(data)
		.when()
				.post("/api/users")
		.then()
				.statusCode(201)
				.log().all().
				extract().response().asString();
		
		JsonPath js= new JsonPath(createResp);
		id= js.getString("id");
		
		System.out.println("===============ID:>>>>>>>"+id);
	}
	
void updateUser() {
		
		HashMap<String, Object> data= new HashMap<String, Object>();
		data.put("name", "UpdatedName");
		data.put("job", "BCI");

		
		String updateResp=
		given()
				.baseUri(baseURL)
				.pathParam("id", id)
				.body(data)
		.when()
				.patch("/api/users/{id}")
		.then()
				.statusCode(200)
				.log().all().
				extract().response().asString();
		
		JsonPath js= new JsonPath(updateResp);
		String updatedAt= js.getString("updatedAt");
		
		System.out.println("===============updatedAt:>>>>>>>"+updatedAt);
	}

	
	void deleteUser() {
		
		given()
				.baseUri(baseURL)
				.pathParam("id", id)
		.when().log().all()
			.delete("/api/users/{id}")
		.then().log().status()
			.statusCode(204);
	}
		
		
	}
	
