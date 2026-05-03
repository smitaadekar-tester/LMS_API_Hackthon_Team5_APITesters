package api.Payload;

import java.util.Map;
import api.Pojo.ForgotPasswordPojo;
import api.Utilities.ExcelReader;



public class ForgotPasswordPayload {
	
	public static ForgotPasswordPojo buildPasswordRequest(String sheetname, String scenarioType) {
		Map<String, String> data = ExcelReader.getTestData(sheetname, scenarioType);
		
		ForgotPasswordPojo pswd = new ForgotPasswordPojo();
		pswd.setUserLoginEmailId(data.get("Email"));
		
	return pswd;
}

	
}




