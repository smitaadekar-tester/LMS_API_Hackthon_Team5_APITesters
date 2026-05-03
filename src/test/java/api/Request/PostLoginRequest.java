package api.Request;

import api.BaseClass.BaseClass;
import api.Payload.LoginPayload;
import api.Pojo.LoginPojo;
import api.Utilities.CommonUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostLoginRequest extends BaseClass {
	String endpt;

	
	public void sendLoginRequest(String method, String endpoint, Object payload, String authType) {
		
		endpt = CommonUtility.endpoints.getString(endpoint);
		
		RequestSpecification request = given()
				              .spec(requestSpec);
		
		if (authType.equalsIgnoreCase("BearerToken")) {
		    request.header("Authorization", "Bearer " + CommonUtility.token);

		} else if (authType.equalsIgnoreCase("InvalidToken")) {
		    request.header("Authorization", "Bearer invalid_token");

		} else if (authType.equalsIgnoreCase("EmptyToken")) {
		    request.header("Authorization", "Bearer ");

		} else if (authType.equalsIgnoreCase("ExpiredToken")) {
		    request.header("Authorization", "Bearer expired_token");
		}
		request.body(payload);
		switch (method.toUpperCase()) {
		
		case "POST":
			  response= request.when().post(endpt);
				 
			break;
		case "GET":
			  response= request.when().get(endpt);
			break;
		 }
        response.then().log().all();
        
        //response.prettyPrint();		
    JsonPath json = response.jsonPath();
//	    String newToken = json.getString("token");
	    if (endpoint.equalsIgnoreCase("loginEndpt")) {
	        String newToken = json.getString("token");

	        if (newToken != null && !newToken.isEmpty()) {
	            CommonUtility.token = newToken;
	        }
	    }
	    
//	    if (endpoint.equalsIgnoreCase("loginEndpt")) {
//	        CommonUtility.token = json.getString("token");
//	    }
	   // CommonUtility.token = json.getString("token");
     
	}

	public int getStatusCode() {
		int sCode = response.getStatusCode();
		return sCode ;
	}
	
	
	
	
	
	
	
	
	

	

}