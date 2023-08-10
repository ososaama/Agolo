import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void Test()
	{
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "2");
		map.put("petId", "2");
		map.put("quantity", "1");
		 */

		JSONObject request = new JSONObject();	  
		
		request.put("id", "5");
		request.put("username", "test14");
		request.put("firstName", "tarekk");
		request.put("lastName", "radwan");
		request.put("email", "test@1234");
		request.put("password", "rtest@12");
		request.put("phone", "01147855214");
		request.put("userStatus", "1");
		
		

		//System.out.println(request);

		given().header("Content-Type", "application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
		.when().post("https://petstore.swagger.io/v2/user").then().statusCode(200);

	}

}
