package api.StepDefinitions;



import api.BaseClass.BaseClass;
import api.Utilities.CommonUtility;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void initializeRequestSpec() {
		setBaseRequest();

	}

	@AfterAll
	public static void afterAll() {
		System.out.println("Program ID: " + CommonUtility.programId);
		System.out.println("Program Name: " + CommonUtility.programName);
	}
	
//	 @AfterAll
//    public static void tearDown() {
//        LogoutService.logout();
//    }
}
	


