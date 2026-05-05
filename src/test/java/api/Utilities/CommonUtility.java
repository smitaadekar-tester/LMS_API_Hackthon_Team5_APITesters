package api.Utilities;

import java.util.ResourceBundle;

import api.Pojo.LoginPojo;
import io.restassured.response.Response;

public class CommonUtility {
	
	
	
	 public static ResourceBundle endpoints = ResourceBundle.getBundle("endPoints");
	    public static ResourceBundle filePath = ResourceBundle.getBundle("jsonFiles");
	    public static String username = endpoints.getString("userName");
	    public static String password = endpoints.getString("password");
	  
	    public static Response response;
	    public static LoginPojo login = new LoginPojo();
		public static String token;

		public static String newPassword;

		public static int programId;
		public static String programName;
	    public static int batchId;
	    public static String batchName;
	    public static int inactiveBatchId= 5627;

		public static String getNewPassword() {
			return newPassword;
		}
		public static void setNewPassword(String newPassword) {
			CommonUtility.newPassword = newPassword;
		}
		public static String getToken() {
			return token;
		}
		public static void setToken(String token) {
			CommonUtility.token = token;
		}
	}




