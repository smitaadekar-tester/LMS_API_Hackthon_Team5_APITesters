package api.Request;

import api.BaseClass.BaseClass;
import api.Payload.LoginPayload;
import api.Utilities.CommonUtility;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class PostLoginRequest extends BaseClass {

	
	public void postLoginrequest() {
		response = given()
				   .spec(requestSpec)
				   .body(LoginPayload.setLoginRequest())
				   .when().post(CommonUtility.endpoints.getString("post"))
				   .then()
				   .log().all()
				   .extract().response();
		
		response.prettyPrint();		
		response.getStatusLine();
		//response.then().statusLine(CommonUtility.endpoints.getString("OK"));
		JsonPath json = response.jsonPath();
		 CommonUtility.token = json.getString("token");
				   
	}
}
