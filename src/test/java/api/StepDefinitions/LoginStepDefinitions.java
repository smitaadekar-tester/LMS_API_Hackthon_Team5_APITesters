package api.StepDefinitions;

import api.Request.PostLoginRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	PostLoginRequest loginReq = new PostLoginRequest();
	

@Given("Admin creates login request with valid credentials")
public void admin_creates_login_request_with_valid_credentials() {
    
}
@When("Admin send Post request with valid endpoints")
public void admin_send_post_request_with_valid_endpoints() {
  loginReq.postLoginrequest(); 
}
@Then("Admin recieves Token in response")
public void admin_recieves_token_in_response() {
   
}
	
}
