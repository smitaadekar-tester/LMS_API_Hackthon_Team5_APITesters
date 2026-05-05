package api.StepDefinitions;

import api.BaseClass.BaseClass;
import api.Payload.LoginPayload;
import api.Pojo.LoginPojo;
import api.Request.*;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class ProgStepdeifinitions extends BaseClass {

    PostLoginRequest loginReq = new PostLoginRequest();
    GetProgRequest progReq = new GetProgRequest();
    PostProgRequest postProgReq = new PostProgRequest();
    DeleteProgRequest deleteProgReq = new DeleteProgRequest();
    UpdateProgRequest updateProgReq = new UpdateProgRequest();

    @Given("Admin generates valid token")
    public void admin_generates_valid_token() {

        if (CommonUtility.getToken() == null) {

            LoginPojo requestBody = LoginPayload.buildValidLoginRequest();
            loginReq.sendLoginRequest("POST", "loginEndpt", requestBody, "NoAuth");
        }
    }


    @When("Admin sends POST request to create new program using {string}")
    public void adminSendsPOSTRequestToCreateNewProgramUsing(String Scenario) {
        response = postProgReq.PostProgramRequest(Scenario);
    }

    @Then("Admin receives {int} status code")
    public void adminReceivesCreatedStatusWithResponseBody(int expectedStatusCode) {

        int actualStatusCode = response.getStatusCode();
        LoggerLoad.info("Expected StatusCode: " + expectedStatusCode);
        LoggerLoad.info("Actual StausCode: " + actualStatusCode);
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @When("Admin sends {string} request to get all programs with {string} endpoint and {string} token")
    public void adminSendsRequestToGetAllProgramsWithEndpointAndToken(String Method, String EndpointType, String TokenType) {
        response = progReq.GetProgramRequest(Method, EndpointType, TokenType, false);
    }

    @When("Admin sends {string} request to get all programs with Users {string} endpoint and {string} token")
    public void adminSendsRequestToGetAllProgramsWithUsersEndpointAndToken(String Method, String EndpointType, String TokenType) {
        response = progReq.GetProgramRequest(Method, EndpointType, TokenType, true);
    }

    @When("Admin sends GET request to retrieve program by program id using {string}")
    public void adminSendsGETRequestToRetrieveProgramByProgramIdUsing(String Scenario) {
         response = progReq.getProgramById(Scenario);
    }

    @When("Admin sends DELETE request to delete program by program id using {string}")
    public void adminSendsDELETERequestToDeleteProgramByProgramIdUsing(String Scenario) {
        response = deleteProgReq.deleteProgramById(Scenario);
    }

    @When("Admin sends DELETE request to delete program by ProgramName using {string}")
    public void adminSendsDELETERequestToDeleteProgramByProgramNameUsing(String Scenario) {
        response = deleteProgReq.deleteProgramByName(Scenario);
    }

    @When("Admin sends PUT request to update program by program id using {string}")
    public void adminSendsPUTRequestToUpdateProgramUsing(String Scenario) {
         response = updateProgReq.updateProgramById(Scenario);

    }

    @When("Admin sends PUT request to update program by ProgramName using {string}")
    public void adminSendsPUTRequestToUpdateProgramByProgramNameUsing(String Scenario) {
            response = updateProgReq.updateProgramByName(Scenario);
    }
}
