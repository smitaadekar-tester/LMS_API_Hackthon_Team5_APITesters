package api.Payload;

import api.Pojo.LoginPojo;
import api.Utilities.CommonUtility;

public class LoginPayload {
	
	public static LoginPojo setLoginRequest() {
		
		//LoginPojo login = new LoginPojo()
		CommonUtility.login.setUserLoginEmailId(CommonUtility.username);
		CommonUtility.login.setPassword(CommonUtility.password);
		return CommonUtility.login;
	}
	

}




