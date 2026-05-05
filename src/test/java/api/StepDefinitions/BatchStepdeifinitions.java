package api.StepDefinitions;

import api.BaseClass.BaseClass;
import api.Request.*;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BatchStepdeifinitions extends BaseClass {
    GetBatchRequest batchReq = new GetBatchRequest();
    PostBatchRequest postBatchReq = new PostBatchRequest();
    UpdateBatchRequest updatebatchReq = new UpdateBatchRequest();
    DeleteBatchRequest deletebatchReq = new DeleteBatchRequest();


    @When("Admin sends {string} request to get all batches with {string} endpoint and {string} token")
    public void adminSendsRequestToGetAllProgramsWithEndpointAndToken(String Method, String EndpointType, String TokenType) {
        response = batchReq.GetAllBatches(Method, EndpointType, TokenType);
    }

    @When("Admin sends POST request to create new batch using {string}")
    public void adminSendsPOSTRequestToCreateNewBatchUsing(String Scenario) {
        response = postBatchReq.PostNewBatchRequest(Scenario);
    }

    @When("Admin sends GET request to get batch {string} using {string}")
    public void adminSendsGETRequestToGetBatchUsing(String RequestType, String Scenario) {
        response = batchReq.getBatch(RequestType, Scenario);
    }

    @When("Admin sends PUT request to update Batch by BatchId using {string}")
    public void adminSendsPUTRequestToUpdateBatchByBatchIdUsing(String Scenario) {
        response = updatebatchReq.updateBatchByBatchId(Scenario);
    }

    @When("Admin sends DELETE request to delete batch by batch id using {string}")
    public void adminSendsDELETERequestToDeleteBatchByBatchIdUsing(String Scenario) {
        response = deletebatchReq.deleteBatchByBatchId(Scenario);
    }
}
