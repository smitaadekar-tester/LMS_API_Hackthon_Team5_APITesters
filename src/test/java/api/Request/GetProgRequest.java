package api.Request;

import api.BaseClass.BaseClass;
import api.Utilities.CommonUtility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetProgRequest extends BaseClass {

    public Response GetProgramRequest(String Method, String EndpointType, String TokenType, boolean withUsers) {

    /*    response = given()
                   .spec(requestSpec)
                   .header("Authorization", "Bearer " + CommonUtility.token)
                   .when().get(CommonUtility.endpoints.getString("getPrograms"))
                   .then()
                   .log().all()
                   .extract().response();

      //  response.prettyPrint();*/
        String endpoint;
        String token;

        if (EndpointType.equalsIgnoreCase("valid")) {
            if (withUsers) {
                endpoint = CommonUtility.endpoints.getString("getProgramsWithUsers");
            } else {
                endpoint = CommonUtility.endpoints.getString("getPrograms");
            }
        } else {
            endpoint = "/invalidEndpoint";
        }

        if (TokenType.equalsIgnoreCase("valid")) {
            token = "Bearer " + CommonUtility.token;
        } else {
            token = "Bearer InvalidToken";
        }

        response = given()
                    .spec(requestSpec)
                    .header("Authorization", token)
                    .when()
                    .request(Method , endpoint)
                    .then()
                    .log().all()
                    .extract().response();


        response.getStatusLine();
        return response;
    }

    public Response getProgramById(String Scenario) {
        String endpoint = CommonUtility.endpoints.getString("getProgramById") + CommonUtility.programId;
        String token = "Bearer " + CommonUtility.token;

        switch (Scenario.toLowerCase()) {

            case "invalid program id":
                endpoint = CommonUtility.endpoints.getString("getProgramById") + "999999";
                break;

            case "invalid endpoint":
                endpoint = "/invalidProgramEndpoint/" + CommonUtility.programId;
                break;

            case "without authorization":
                token = "Bearer InvalidToken";
                break;

            case "valid program id":
                endpoint = CommonUtility.endpoints.getString("getProgramById") + CommonUtility.programId;
                break;

            default:
                throw new RuntimeException("Unknown scenario: " + Scenario);
        }

        response = given()
                .spec(requestSpec)
                .header("Authorization", token)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        return response;
    }

}
