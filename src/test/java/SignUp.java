import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;


public class SignUp {
	JSONObject request = new JSONObject();	
	@Test
	public void SignUp_With_NOData()
	{
		  
		request.put("sign-username", "");
		request.put("sign-password", "");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void SignUp_With_NO_Username()
	{  
		request.put("sign-username", "");
		request.put("sign-password", "test@123");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void SignUp_With_NO_Password()
	{ 
		request.put("sign-username", "test1");
		request.put("sign-password", "");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400); //400 for invalid input/missing parameters
	}
	
	@Test
	public void SignUp_With_weak_Password()
	{  
		request.put("sign-username", "test1");
		request.put("sign-password", "12345");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void SignUp_With_invalid_Username()
	{ 
		request.put("sign-username", "12345");
		request.put("sign-password", "testP#123");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(400);
	}
	
	@Test
	public void SignUp_With_correct_input()
	{	  
		request.put("sign-username", "test12");
		request.put("sign-password", "testP123!");
		
		//insert the api endpoint before executing
		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("").then().statusCode(201); //could also be 200
	}

}
