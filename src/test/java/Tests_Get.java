import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Tests_Get {
	
	@Test
	public void Test()
	{
		given().get("https://petstore.swagger.io/#/pet/findPetsByStatus").then().statusCode(200).log().all();
		
		
	}

}
