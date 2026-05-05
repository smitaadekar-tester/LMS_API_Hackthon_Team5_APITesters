package api.Request;

import api.BaseClass.BaseClass;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBatchRequest extends BaseClass {

    public Response deleteBatchByBatchId(String Scenario) {
        LoggerLoad.info("Scenario Name: " + Scenario);
        String endpoint = CommonUtility.endpoints.getString("deleteBatchByBatchId") + CommonUtility.batchId;
        String token = "Bearer " + CommonUtility.token;
        String method = "DELETE";

        switch (Scenario.toLowerCase()) {

            case "invalid batchid":
                endpoint = CommonUtility.endpoints.getString("deleteBatchByBatchId") + "999999";
                break;

            case "invalid endpoint":
                endpoint = "/invalidProgramEndpoint/" + CommonUtility.batchId;
                break;

            case "invalid token":
                token = "Bearer InvalidToken";
                break;

            case "invalid method":
                method = "GET";  //wrong request method
                break;

            case "valid batchid":
                endpoint = CommonUtility.endpoints.getString("deleteBatchByBatchId") + CommonUtility.batchId;
                break;

            default:
                throw new RuntimeException("Unknown scenario: " + Scenario);
        }

        LoggerLoad.info("Endpoint: " + endpoint);
        LoggerLoad.info("Request Method: " + method);

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .when()
                .request(method, endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        //response.prettyPrint();
        response.getStatusLine();
        return response;

    }
}
