package SDET;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import java.util.HashMap;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.core.StringContains;
import org.testng.annotations.*;
import Pojo.LocalPojo;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HashMapBody {
/*to activate local host, go to the json file location
cmd> json-server file.json
pre req, npm, node, json server
*/
		@Test (priority = 2)
		void getData() {
		
		//Send body as hashmap
		
		given().
				baseUri("http://localhost:3000")
		.when()
				.get("/data")
		.then()
				.log().all().statusCode(200).assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("localSchema.json"));
		
		}
		//Using Hashmap
		@Test (priority = 1)
		void createDataHashMap() {
			
			LocalPojo respObj= new LocalPojo();
			
			String [] talents= {"Dance", "Sing", "Cook", "Act", "Sing", "OrBohotKuch"};
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("name", "Nidhi Pandey");
			data.put("age", 29);
			data.put("email", "nidhi.pandey@gmail.com");
			data.put("hobbies", talents);
			
			LocalPojo resp= given()
					.baseUri("http://localhost:3000")
					.contentType("application/json")
					.body(data).
			when()
					.post("/data").
			then().log().body()
					.statusCode(201)
					.body("name", containsString("Nidhi"))
					.body("age",equalTo(29))
					.body("hobbies[0]", equalTo("Dance"))
					.extract().response().as(LocalPojo.class);
			
			System.out.println(resp.getHobbies()[0]);
			
			//JsonPath js= new JsonPath(resp);
			//System.out.println(js.getString("email"));
			//assertEquals(js.getString("email"), contains("nidhi"));
			
			
		}
		
		//using org.json
		
		@Test
		void createDataOrgJson() {
			String [] talents= {"Dance", "Sing", "Cook", "Act", "Sing", "OrBohotKuch"};
			JsonObject data = new JsonObject();
			data.addProperty("name", "Vivek");
			data.addProperty("name", "Nidhi Pandey");
			data.addProperty("age", 29);
			data.addProperty("email", "nidhi.pandey@gmail.com");
			//data.add("hobbies", talents);
			
			String resp= given()
					.baseUri("http://localhost:3000")
					.contentType("application/json")
					.body(data.toString()).
			when()
					.post("/data").
			then().log().body()
					.statusCode(201)
					.body("name", containsString("Nidhi"))
					.body("age",equalTo(29))
					.extract().response().asPrettyString();
			
			JsonPath js= new JsonPath(resp);
			System.out.println(js.getString("email"));
			//assertEquals(js.getString("email"), contains("nidhi"));
			
			
		}
		
	
}
