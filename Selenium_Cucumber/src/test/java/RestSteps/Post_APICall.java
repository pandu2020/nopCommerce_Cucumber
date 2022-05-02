package RestSteps;


import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONObject;

import org.junit.Assert;  // We use one only because need to intergrate with reports 


public class Post_APICall {
	
	
	Response response;
	RequestSpecification httpRequet;
	ResponseBody body;
	String PayLoad,responseBodyAsString;
	int countOfHeader ;
	Headers header;
	
	@Given("Mentioned The post Service URL")
	public void mentioned_The_post_Service_URL() {
		  RestAssured.baseURI = "https://bookstore.toolsqa.com";
	}

	@When("Provide The Headera and JSON Request Body")
	public void provide_The_Headera_and_JSON_Request_Body() throws IOException {
		
		httpRequet = RestAssured.given();
		
	PayLoad = new String(Files.readAllBytes(Paths.get("src/test/java/RestSteps/sample.json")));
		
/*		JSONObject obj = new JSONObject();
		
        obj.put("userName", RandomStringUtils.randomAlphabetic(5)+"@"+RandomStringUtils.randomAlphabetic(5));
        
        obj.put("password", RandomStringUtils.randomAlphabetic(5)+"@"+RandomStringUtils.randomAlphabetic(5));  */
        
     //   PayLoad = obj.toString();
        
		System.out.println(" PayLoad is "+PayLoad);	
		
		
		
		response = httpRequet.body(PayLoad).post("/Account/v1/User");
		 
		 
	}

	@Then("Validate The Response")
	public void validate_The_Response() {
		int statusCode = response.getStatusCode();
		System.out.println(" Response Status Code is "+statusCode);
	}

	@Then("Validate The Headers")
	public void validate_The_Headers() {
		body = response.getBody();
		
		body.prettyPeek();   // It will print Status Code Heander & Json Response 
		
		body.prettyPrint();  // It will print Only Json Response 
		
		header = response.getHeaders();
		
		System.out.println(" Reponse Headers "+header);
		
		System.out.println(" Header content-type is "+header.getValue("content-type"));
		
		System.out.println(" Header content-type is "+response.getHeader("content-type"));
		
		 countOfHeader = header.asList().size();
		
		System.out.println("  countOfHeader is "+header);
		
		// Print reponse body As String
				System.out.println(" Response body is "+body.asString());
				
				 responseBodyAsString		 = response.getBody().asString();
			
		
		//Assert.assertEquals(200,response.getStatusCode());  // (Expected,Actual)  -- We can check status code 
		//Assert.assertEquals("application/json",header.getValue("content-type"));  // (Expected,Actual)  -- we can check header values
	
	}

	@Then("Validate The Response Codes")
	public void validate_The_Response_Codes() {
		Assert.assertEquals(400,response.getStatusCode()); 
		Assert.assertTrue(responseBodyAsString.contains("message"));
	}

}
