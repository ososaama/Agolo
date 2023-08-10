import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_Delete {

	@Test
	public void Test()
	{
		when().delete("https://petstore.swagger.io/v2/user/test14").then().statusCode(200);
	}

}
