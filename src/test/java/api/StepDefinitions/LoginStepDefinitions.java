package api.StepDefinitions;

import static org.testng.Assert.assertEquals;

import api.BaseClass.BaseClass;
import api.Payload.LoginPayload;
import api.Payload.ForgotPasswordPayload;
import api.Request.PostLoginRequest;
import api.Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends BaseClass{

	PostLoginRequest loginReq = new PostLoginRequest();
	private String scenarioType;
	Object requestBody;
	 int actualStatusCode;
	 private String sheetName;
	 private String authType;
	
	@Given("Admin sets authorization as {string}")
	public void admin_sets_authorization_as(String authType) {
		this.authType = authType;
	    }

	
//	@Given("Admin creates testData for {string}")
//	public void admin_creates_test_data_for(String scenarioType) {
//		
//		sheetName = "Login";
//		requestBody = LoginPayload.buildInvalidLoginRequest(sheetName,scenarioType);
//	}
	
	@Given("Admin creates testData for {string} and {string}")
	public void admin_creates_test_data(String scenarioType, String endpoint) {

	    if (endpoint.equalsIgnoreCase("loginEndpt")) {

	        requestBody = LoginPayload.buildInvalidLoginRequest("Login", scenarioType);

	    } else if (endpoint.equalsIgnoreCase("resetPswdEndpt")) {

	        requestBody = LoginPayload.buildInvalidLoginRequest("ResetPassword", scenarioType);

	    } else if (endpoint.equalsIgnoreCase("forgotPswdEndpt")) {

	        requestBody = ForgotPasswordPayload.buildPasswordRequest("ForgotPassword", scenarioType);
	    } else if (endpoint.equalsIgnoreCase("logoutEndpt")) {
	  	    requestBody = null;
	   } else if (endpoint.equalsIgnoreCase("invalidEndpt")) {
			requestBody = LoginPayload.buildInvalidLoginRequest("Login", scenarioType);
	}

	}
	
	 @When ("Admin sends {string} request to {string} endpoint")
	public void admin_sends_request_to_endpoint(String method, String endpoint ) {
	  
		 loginReq.sendLoginRequest(method, endpoint, requestBody, authType);
	    

	}
	@Then("Admin receives status code {int}")
	public void admin_receives_status_code(int expectedstatusCode) {
		
		  actualStatusCode = loginReq.getStatusCode();
		  
		LoggerLoad.info("Expected StatusCode: " + expectedstatusCode);
		LoggerLoad.info("Actual StausCode: " + actualStatusCode);

		assertEquals(expectedstatusCode, actualStatusCode); 
	}
	

	@Given("Admin creates valid login test data")
	public void valid_login() {

		requestBody = LoginPayload.buildValidLoginRequest();	    
	}
	

@Then("Admin receives Token with statusCode {int} in response")
public void admin_recieves_token_with_statusCode_in_response(int expectedStatusCode) {
	 actualStatusCode = loginReq.getStatusCode();
	 LoggerLoad.info("Expected StatusCode: " + expectedStatusCode);
		LoggerLoad.info("Actual StausCode: " + actualStatusCode);

		assertEquals(expectedStatusCode, actualStatusCode);
}

@Then("Admin receives statusCode {int}")
public void admin_receives_status_code_with_response_message(int expectedstatusCode) {

	actualStatusCode = loginReq.getStatusCode();

    LoggerLoad.info("Expected StatusCode: " + expectedstatusCode);
    LoggerLoad.info("Actual StatusCode: " + actualStatusCode);

    assertEquals(actualStatusCode, expectedstatusCode);

}


}
