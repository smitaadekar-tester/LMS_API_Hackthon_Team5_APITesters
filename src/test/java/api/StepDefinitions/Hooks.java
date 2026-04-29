package api.StepDefinitions;



import api.BaseClass.BaseClass;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	 @Before
	    public void initializeRequestSpec() {
	        setBaseRequest();  
	    }
	}
	


