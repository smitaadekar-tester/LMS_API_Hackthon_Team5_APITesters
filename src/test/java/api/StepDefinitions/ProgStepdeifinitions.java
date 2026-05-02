package api.StepDefinitions;

import api.Request.*;
import api.Utilities.CommonUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ProgStepdeifinitions {

    PostLoginRequest loginReq = new PostLoginRequest();
    GetProgRequest progReq = new GetProgRequest();
    PostProgRequest postProgReq = new PostProgRequest();
    DeleteProgRequest deleteProgReq = new DeleteProgRequest();
    UpdateProgRequest updateProgReq = new UpdateProgRequest();
    Response response;


    @Given("Admin sets Authorization to Bearer Token")
    public void adminSetsAuthorizationToBearerToken() {
        if (CommonUtility.token == null || CommonUtility.token.isEmpty()) {
            loginReq.postLoginrequest();
        }
    }

   /* @When("Admin sends GET request to get all programs")
    public void admin_sends_get_request_to_get_all_programs() {
        response = progReq.GetProgRequest();

    }

    @Then("Admin receives 200 OK status with list of programs")
    public void admin_receives_200_ok_status_with_list_of_programs() {
        response.then().statusCode(200);

    }*/

    @When("Admin sends POST request to create new program using {string}")
    public void adminSendsPOSTRequestToCreateNewProgramUsing(String Scenario) {
        response = postProgReq.PostProgramRequest(Scenario);
    }

    @Then("Admin receives {int} status code")
    public void adminReceivesCreatedStatusWithResponseBody(int StatusCode) {

        response.then().statusCode(StatusCode);
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
