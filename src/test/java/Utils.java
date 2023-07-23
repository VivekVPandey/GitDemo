import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	
	public static String globalProperty(String key) throws IOException   {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src//main//resources//GlobalProperty.properties");
		prop.load(file);
		String value= prop.getProperty(key);
		return value;
		
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(globalProperty("baseUrl"));
//	}

}
