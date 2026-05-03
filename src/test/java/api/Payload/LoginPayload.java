package api.Payload;

import java.util.Map;

import api.Pojo.LoginPojo;
import api.Utilities.CommonUtility;
import api.Utilities.ExcelReader;


public class LoginPayload {
	public static String usePswd;
	
	public static LoginPojo buildValidLoginRequest() {
	
		LoginPojo login = new LoginPojo();
	
	login.setUserLoginEmailId(CommonUtility.username);
	if(CommonUtility.getNewPassword()!= null) {
		usePswd = CommonUtility.getNewPassword();
	}else {
		usePswd = CommonUtility.password;
	}
	login.setPassword(usePswd);
	return login;
}

public static LoginPojo buildInvalidLoginRequest(String sheetname,String scenarioType) {
	 Map<String, String> data = ExcelReader.getTestData(sheetname,scenarioType);
	 
	LoginPojo admin = new LoginPojo();
	admin.setUserLoginEmailId(data.get("Email"));
	admin.setPassword(data.get("Password"));
	
	return admin;
}
}





