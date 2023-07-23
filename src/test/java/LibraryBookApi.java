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
public class LibraryBookApi extends LibraryAllMethods{
	
	public static void main(String[] args) {
		
		LibraryBookApi book = new LibraryBookApi();
		
		Response resp= book.addBook("adf123");
		JsonPathReuse js = new JsonPathReuse();
		System.out.println(resp.asPrettyString());
		String ID= js.readRespJson(resp,"ID");
		
		
	}
	
}

