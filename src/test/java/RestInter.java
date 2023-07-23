import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.hamcrest.core.StringContains;
public class RestInter {

	public static void main(String[] args) {
		
		baseURI="https://rahulshettyacademy.com";
		
		HashMap<String, Object>  map = new HashMap<>();
		map.put("name", "This is test data");
		map.put("isbn", "asff");
		map.put("aisle", "234324");
		map.put("author", "VIvek Pandey");	
		
		Response resp= given().log().all().
								header("Content-Type","application/json").
								body(map).
						when().log().all().
								post("/Library/Addbook.php").
						then().log().all().
								statusCode(200).
								body("ID", StringContains.containsString((String) map.get("isbn")+(String) map.get("aisle"))).
								extract().response();
		
		String res= resp.asPrettyString();
		JsonPath js= new JsonPath(res);
		System.out.println(js.get("Msg"));
				
								
		
	}
	
}
