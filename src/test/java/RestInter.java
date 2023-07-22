import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.hamcrest.core.StringContains;
public class RestInter {

	public static void main(String[] args) {
		
		baseURI="https://rahulshettyacademy.com";
		
		Response resp= given().
								header("Content-Type","application/json").
								body("{\r\n"
										+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
										+ "\"isbn\":\"sdgfg\",\r\n"
										+ "\"aisle\":\"23926\",\r\n"
										+ "\"author\":\"John foer\"\r\n"
										+ "}\r\n"
										+ "").
						when().
								post("/Library/Addbook.php").
						then().
								statusCode(200).
								body("Msg", StringContains.containsString("added")).
								extract().response();
		
		String r= resp.asPrettyString();
		System.out.println(r);
		
		JsonPath js= new JsonPath(r);
		System.out.println(js.get("Msg"));
		
		//assertEquals(js.get("Msg"), "Book Already Exists");
		
								
		
	}
	
}
