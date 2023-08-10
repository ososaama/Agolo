import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;


public class Login {
	
	JSONObject request = new JSONObject();	
	
	
	@Test
	public void Login_With_NOData()
	{
		  
		request.put("loginusername", "");
		request.put("loginpassword", "");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void Login_With_NO_Username()
	{
		  
		request.put("loginusername", "");
		request.put("loginpassword", "test@123P");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void Login_With_NO_Password()
	{
		  
		request.put("loginusername", "test1");
		request.put("loginpassword", "");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}

	@Test
	public void Login_With_invalid_Credentials()
	{
		  
		request.put("loginusername", "test12");
		request.put("loginpassword", "qeoiusad");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void Login_With_valid_Credentials()
	{
		  
		request.put("loginusername", "test12");
		request.put("loginpassword", "testP123!");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
}
