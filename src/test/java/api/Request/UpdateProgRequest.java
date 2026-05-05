package api.Request;

import api.BaseClass.BaseClass;
import api.Payload.ProgramPayload;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateProgRequest extends BaseClass {

    public Response updateProgramById(String Scenario) {
        String endpoint = CommonUtility.endpoints.getString("updateProgramById") + CommonUtility.programId;
        String token = "Bearer " + CommonUtility.token;
        String method = "PUT";

        LoggerLoad.info("Scenario Name: " + Scenario);

        if (Scenario.toLowerCase().contains("no request body")) {
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
        if (Scenario.equalsIgnoreCase("invalid endpoint")) {
            endpoint = "/invalidEndpoint/" + CommonUtility.programId;
        }

        if (Scenario.equalsIgnoreCase("invalid method")) {
            method = "GET";
        }
        if (Scenario.equalsIgnoreCase("invalid token")) {
            token = "Bearer InvalidToken";

        }
        if (Scenario.toLowerCase().contains("invalid program id")) {
            endpoint = CommonUtility.endpoints.getString("updateProgramById") + "99999";
        }

        LoggerLoad.info("Endpoint: " + endpoint);
        LoggerLoad.info("Request Method: " + method);

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(ProgramPayload.ProgRequest(CommonUtility.endpoints.getString("updatepgmbyIdsheetname"), Scenario))
                .when()
                .request(method, endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        //response.prettyPrint();
        response.getStatusLine();
        if (response.getStatusCode() == 200) {
            JsonPath json = response.jsonPath();
            CommonUtility.programId = json.getInt("programId");
            CommonUtility.programName = json.getString("programName");
        }
        return response;

    }

    //***************************************************************************************
    public Response updateProgramByName(String Scenario) {
        String endpoint = CommonUtility.endpoints.getString("updateProgramByName") + CommonUtility.programName;
        String token = "Bearer " + CommonUtility.token;
        String method = "PUT";

        if (Scenario.toLowerCase().contains("invalid token")) {
            token = "Bearer InvalidToken";

        }
        if (Scenario.toLowerCase().contains("invalid program name")) {
            endpoint = CommonUtility.endpoints.getString("updateProgramByName") + "99999";
        }


        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .body(ProgramPayload.ProgRequest(CommonUtility.endpoints.getString("updatepgmbyNamesheetname"), Scenario))
                .when()
                .request(method, endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        //response.prettyPrint();
        response.getStatusLine();
        if (response.getStatusCode() == 200) {
            JsonPath json = response.jsonPath();
            CommonUtility.programId = json.getInt("programId");
            CommonUtility.programName = json.getString("programName");
        }
        return response;

    }


}
