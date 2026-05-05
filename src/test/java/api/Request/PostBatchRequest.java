package api.Request;
import api.BaseClass.BaseClass;
import api.Payload.BatchPayload;
import api.Payload.ProgramPayload;
import api.Utilities.CommonUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostBatchRequest extends BaseClass {
    String endpoint = CommonUtility.endpoints.getString("postBatches");
    String token = "Bearer " + CommonUtility.token;
    String method = "POST";

    public Response PostNewBatchRequest(String Scenario) {

        if (Scenario.toLowerCase().contains("invalid endpoint")) {
            endpoint = "/invalidEndpoint";
        }

        if (Scenario.toLowerCase().contains("invalid method")) {
            method = "PUT";
        }
        if (Scenario.toLowerCase().contains("invalid token")) {
            token = "Bearer InvalidToken";

        }

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(BatchPayload.BatchRequest(CommonUtility.endpoints.getString("postbatchsheetname"), Scenario))
                .when()
                .request(method, endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        //response.prettyPrint();
        response.getStatusLine();
        if (response.getStatusCode() == 201) {
            JsonPath json = response.jsonPath();
            CommonUtility.batchId = json.getInt("batchId");
            CommonUtility.batchName = json.getString("batchName");
         //   CommonUtility.programId = json.getInt("programId");
            System.out.println("Batch ID: " + CommonUtility.batchId);
            System.out.println("Batch Name: " + CommonUtility.batchName);
        }
        return response;
    }


    }




