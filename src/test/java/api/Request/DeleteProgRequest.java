package api.Request;

import api.BaseClass.BaseClass;
import api.Payload.ProgramPayload;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteProgRequest extends BaseClass {

    public Response deleteProgramById(String Scenario) {
        LoggerLoad.info("Scenario Name: " + Scenario);
        String endpoint = CommonUtility.endpoints.getString("deleteProgramById") + CommonUtility.programId;
        String token = "Bearer " + CommonUtility.token;
        String method = "DELETE";

        switch (Scenario.toLowerCase()) {

            case "invalid programid":
                endpoint = CommonUtility.endpoints.getString("deleteProgramById") + "999999";
                break;

            case "invalid endpoint":
                endpoint = "/invalidProgramEndpoint/" + CommonUtility.programId;
                break;

            case "invalid token":
                token = "Bearer InvalidToken";
                break;

            case "invalid method":
                method = "GET";  //wrong request method
                break;

            case "valid programid":
                endpoint = CommonUtility.endpoints.getString("deleteProgramById") + CommonUtility.programId;
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
    //***************************************************************************************
    public Response deleteProgramByName(String Scenario) {
        LoggerLoad.info("Scenario Name: " + Scenario);

        String endpoint = CommonUtility.endpoints.getString("deleteProgramByName") + CommonUtility.programName;
        String token = "Bearer " + CommonUtility.token;
        String method = "DELETE";

        switch (Scenario.toLowerCase()) {

            case "invalid programname":
                endpoint = CommonUtility.endpoints.getString("deleteProgramByName") + "999999";
                break;

            case "invalid endpoint":
                endpoint = "/invalidProgramEndpoint/" + CommonUtility.programName;
                break;

            case "invalid token":
                token = "Bearer InvalidToken";
                break;

            case "invalid method":
                method = "GET";  //wrong request method
                break;

            case "valid programname":
                response = new PostProgRequest().createProgramForDeleteSetup(Scenario);
                endpoint = CommonUtility.endpoints.getString("deleteProgramByName") + CommonUtility.programName;
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
        System.out.println(CommonUtility.programName);
        return response;

    }


}
