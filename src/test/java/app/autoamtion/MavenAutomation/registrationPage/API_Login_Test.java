package app.autoamtion.MavenAutomation.registrationPage;

import org.openqa.selenium.remote.JsonException;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

/*import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
 
/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;*/

public class API_Login_Test {
	
	/*public void API_Test() throws JsonException,InterruptedException{
		
		String url="http://10.15.21.164/Saba/api/login";
		
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
		
		RequestSpecification requestSpec = builder.build();
		
		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic({username}, {password})
					.spec(requestSpec).when().post(APIUrl);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		  builder.addHeader("user", "uone");
		  builder.addHeader("password", "welcome");
		  builder.addHeader("site", "QA006");
		  RequestSpecification requestSpec = builder.build();
		  Response response = httpRequest.spec(requestSpec).when().get("http://10.15.21.164/Saba/api/login");
	}
*/
	
	@Test(priority = 0)
	 public void TestAPICreateGroup() throws JsonException, IOException {
	  // Specify the base URL to the RESTful web service
	  RestAssured.baseURI = "https://qadb02.sabacloud.com";

	  // Get the RequestSpecification of the request that you want to sent
	  // to the server. The server is specified by the BaseURI that we have
	  // specified in the above step.
	  RequestSpecification httpRequest = RestAssured.given();

	  // Make a request to the server by specifying the method Type and the method
	  // URL.
	  // This will return the Response from the server. Store the response in a
	  // variable.
	  RequestSpecBuilder builder = new RequestSpecBuilder();
	  builder.addHeader("user", "uone");
	  builder.addHeader("password", "Welcome1");
	  builder.addHeader("site", "QADB02");
	  RequestSpecification requestSpec = builder.build();
	  //Response response = httpRequest.spec(requestSpec).when().get("https://qadb02.sabacloud.com/Saba/api/login/");

	  //int statusCode = response.getStatusCode();

	  // Now let us print the body of the message to see what response
	  // we have received from the server
	  //String responseBody = resp...
	}
}
