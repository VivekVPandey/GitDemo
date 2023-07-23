import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathReuse  {
	
	public String readRespJson(Response resp, String key) {
	
	String res= resp.asPrettyString();
	JsonPath js= new JsonPath(res);
	String value = js.get(key);
	return value;
	}
}
