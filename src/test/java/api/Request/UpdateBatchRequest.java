package api.Request;

import api.BaseClass.BaseClass;
import api.Payload.BatchPayload;
import api.Utilities.CommonUtility;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateBatchRequest extends BaseClass {

    public Response updateBatchByBatchId(String Scenario) {

        String endpoint = CommonUtility.endpoints.getString("updateBatchByBatchId") + CommonUtility.batchId;
        String token = "Bearer " + CommonUtility.token;
        String method = "PUT";
        ContentType contentType = ContentType.JSON;

        if (Scenario.toLowerCase().contains("invalid batch id")) {
            endpoint = CommonUtility.endpoints.getString("updateBatchByBatchId") + "999999";
        }

        if (Scenario.toLowerCase().contains("invalid endpoint")) {
            endpoint = "/invalidBatchEndpoint/" + CommonUtility.batchId;
        }

        if (Scenario.toLowerCase().contains("invalid method")) {
            method = "GET";
        }

        if (Scenario.toLowerCase().contains("invalid token")) {
            token = "Bearer InvalidToken";
        }

        if (Scenario.equalsIgnoreCase("invalid content type")) {
            contentType = ContentType.TEXT;
        }

        response = given()
                .spec(requestSpec)
                .contentType(contentType)
                .header("Authorization", token)
                .body(BatchPayload.BatchRequest(CommonUtility.endpoints.getString("updatebatchsheetname"), Scenario))
                .when()
                .request(method, endpoint)
                .then()
                .log().all()
                .extract()
                .response();
        if (response.getStatusCode() == 200) {
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
