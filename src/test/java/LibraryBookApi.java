import io.restassured.RestAssured;
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
		JsonPathReuse js = new JsonPathReuse();

		
		//Add book to library
		Response addResp= book.addBook("addBook","adf123");
		System.out.println(addResp.asPrettyString());
		String ID= js.readRespJson(addResp,"ID");
		
		//Get book from library
		
		Response getResp=book.getBook("getBook",ID);
		System.out.println(getResp.asPrettyString());
		
		//Delete book
		Response deleteResp=book.deleteBook("deleteBook",ID);
		System.out.println(deleteResp.asPrettyString());
	}
	
}

