package api.Request;

import api.BaseClass.BaseClass;
import api.Utilities.CommonUtility;
import api.Utilities.LoggerLoad;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBatchRequest extends BaseClass {

    public Response GetAllBatches(String Method, String EndpointType, String TokenType) {

    String endpoint;
    String token;

        if (EndpointType.equalsIgnoreCase("valid")) {
            endpoint = CommonUtility.endpoints.getString("getBatches");
        }
     else {
        endpoint = "/invalidEndpoint";
    }

        if (TokenType.equalsIgnoreCase("valid")) {
        token = "Bearer " + CommonUtility.token;
    } else {
        token = "Bearer InvalidToken";
    }

        LoggerLoad.info("Endpoint: " + endpoint);
        LoggerLoad.info("Request Method: " + Method);

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

    public Response getBatch(String requestType, String scenario) {

        LoggerLoad.info("Scenario: " + scenario);

        String endpoint = "";
        String token = "Bearer " + CommonUtility.token;
        String method = "GET";

        switch (requestType.toLowerCase()) {

            case "by batchid":
                endpoint = CommonUtility.endpoints.getString("getBatchByBatchId") + CommonUtility.batchId;

                if (scenario.equalsIgnoreCase("invalid batchid")) {
                    endpoint = CommonUtility.endpoints.getString("getBatchByBatchId") + "999999";
                }

                if (scenario.equalsIgnoreCase("inactive batchid")) {
                    endpoint = CommonUtility.endpoints.getString("getBatchByBatchId") + CommonUtility.inactiveBatchId;
                }
                break;

            case "by batchname":
                endpoint = CommonUtility.endpoints.getString("getBatchByBatchName") + CommonUtility.batchName;

                if (scenario.equalsIgnoreCase("invalid batchname")) {
                    endpoint = CommonUtility.endpoints.getString("getBatchByBatchName") + "InvalidBatchName";
                }
                break;

            case "by programid":
                endpoint = CommonUtility.endpoints.getString("getBatchByProgramId") + CommonUtility.programId;

                if (scenario.equalsIgnoreCase("invalid programid")) {
                    endpoint = CommonUtility.endpoints.getString("getBatchByProgramId") + "999999";
                }
                break;

            default:
                throw new RuntimeException("Invalid RequestType: " + requestType);
        }

        if (scenario.equalsIgnoreCase("invalid endpoint")) {
            endpoint = "/invalidBatchEndpoint";
        }

        if (scenario.equalsIgnoreCase("invalid token")) {
            token = "Bearer InvalidToken";
        }

        if (scenario.equalsIgnoreCase("invalid method")) {
            method = "POST";
        }

        System.out.println("Method: " + method);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Token: " + token);

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

        return response;
    }


}
