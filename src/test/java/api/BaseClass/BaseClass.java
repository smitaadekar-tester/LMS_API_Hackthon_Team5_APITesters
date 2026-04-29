package api.BaseClass;

import api.Utilities.CommonUtility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	 protected static Response response;
	 protected static RequestSpecification requestSpec;


public void setBaseRequest() {
	            requestSpec = new RequestSpecBuilder()
	            		.setBaseUri(CommonUtility.endpoints.getString("baseURL"))
	            		.setContentType(ContentType.JSON)
	            		.log(LogDetail.ALL)
	            		.build();
	            
	        
}
	 

}
