package api.Request;
import api.BaseClass.BaseClass;
import api.Payload.ProgramPayload;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostProgRequest extends BaseClass {
    String endpoint = CommonUtility.endpoints.getString("postProgram");
    String token = "Bearer " + CommonUtility.token;
    String method = "POST";

    public Response PostProgramRequest(String Scenario) {

        LoggerLoad.info("Scenario Name: " + Scenario);

        if (Scenario.equalsIgnoreCase("invalid endpoint")) {
            endpoint = "/invalidEndpoint";
        }

        if (Scenario.equalsIgnoreCase("invalid method")) {
            method = "GET";
        }
        if (Scenario.equalsIgnoreCase("invalid token")) {
            token = "Bearer InvalidToken";

        }

        LoggerLoad.info("Endpoint: " + endpoint);
        LoggerLoad.info("Request Method: " + method);

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(ProgramPayload.ProgRequest(CommonUtility.endpoints.getString("postprogramsheetname"), Scenario))
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
            CommonUtility.programId = json.getInt("programId");
            CommonUtility.programName = json.getString("programName");
        }
        return response;
    }

    public Response createProgramForDeleteSetup(String Scenario) {

        LoggerLoad.info("Scenario Name: " + Scenario);

         endpoint = CommonUtility.endpoints.getString("postProgram");
         token = "Bearer " + CommonUtility.token;
         method = "POST";

        LoggerLoad.info("Endpoint: " + endpoint);
        LoggerLoad.info("Request Method: " + method);

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(ProgramPayload.ProgRequest(CommonUtility.endpoints.getString("programsetupsheetname"), Scenario))
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
            CommonUtility.programId = json.getInt("programId");
            CommonUtility.programName = json.getString("programName");
        }
        return response;
    }



}
