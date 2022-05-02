package stepDefinitions;

import cucumber.api.java.en.*;


public class Rest_API_Steps {
	   
	
	@Given("Launch the Base URL")
	public void launch_the_Base_URL() {
	   System.out.println("HI Im in Given");
	}

	@When("User Provide Service Details")
	public void user_Provide_Service_Details() {
		 System.out.println("HI Im in When");
	}

	@When("Provide the Method Name with All Inputs")
	public void provide_the_Method_Name_with_All_Inputs() {
		 System.out.println("HI Im in When");
	}

	@Then("Print The Response Body")
	public void print_The_Response_Body() {
		 System.out.println("HI Im in Then");
	}

	@Then("Validdate Status Codes")
	public void validdate_Status_Codes() {
		 System.out.println("HI Im in Then");
	}
	
}
