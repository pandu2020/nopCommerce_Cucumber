package stepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{

	
		
	
	@Before
	public void setUp()throws Exception
	{
		logger = Logger.getLogger("Selenium_cucumber"); // Added Logger 
		PropertyConfigurator.configure("log4j.properties");
		configprop = new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		configprop.load(fis);
		//I we have multiple browsers use IF-Else
		System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath") );
		driver = new ChromeDriver();
	}
	
	@Given("User Launch the Chrome Browser")
	public void user_Launch_the_Chrome_Browser() {
	    
		
		logger.info("******Lanching Browser******");
		lp = new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("******Opening URL******");
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		logger.info("******Providing Login DEtails 	******");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		
		lp.clickLogIn();
		Thread.sleep(5000);
	    
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("****** Login Failed 	******");
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title,driver.getTitle() );
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	   
		logger.info("****** Login Successful 	******");
		Thread.sleep(5000);
		lp.clickLogOut();
		Thread.sleep(3000);
	}

	@Then("close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
	
		
	@Then("User can View DashBoard")
	public void user_can_View_DashBoard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
	  Thread.sleep(3000);
	  addCust.clickOnCustomerMenu();
	  
	}

	@When("Click on customer menu items")
	public void click_on_customer_menu_items() throws InterruptedException {
		Thread.sleep(2000);
		  addCust.clickOnCustomerMenuItems();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		
		  addCust.clickOnAddNew();
		  Thread.sleep(2000);
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enters cutomer info")
	public void user_enters_cutomer_info() throws Exception {
		
		String email=randomString()+"@gmail.com";
		
		addCust.setEmail(email);
		addCust.setPassword("test123");
		
		// Registred Default 
		// The Customer cant be in boht 'Guest' and 'Registred' Customer roles
		// Add the customer to 'Guest' or 'Registred' customer roles
		
		addCust.settxtFirstName("Pandu");
		addCust.settxtLastName("Ranga");
		
		addCust.setGender("Male");
		addCust.settxtDoB("7/05/1985");  // Format DD/MM/YYYY
		
		addCust.settxtCompanyName("busyQA");
		addCust.settxtNewLetter("Test store 2");
		addCust.setCustomerRoles("Guests");
		
				
		
		
		addCust.setttxtAdminComment("This is for Testing.........");
	   
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickBtnSave();
		Thread.sleep(2000);
		
	}

	@Then("user can view message like {string}")
	public void user_can_view_message_like(String msg) throws InterruptedException {
		
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

	// Step for Searching customer using email
	
	@When("Enter the Customer Email")
	public void enter_the_Customer_Email() {
	   
		searchCust = new SearchCustomerPage(driver); 
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	}
	
	// Step for Searching customer using fname and lname
	
	@When("Enter  Customer First Name")
	public void enter_Customer_First_Name() {
		searchCust = new SearchCustomerPage(driver); 
		searchCust.settxtFirstName("Victoria");
	}

	@When("Enter  Customer Last Name")
	public void enter_Customer_Last_Name() {
		searchCust.settxtLastName("Terces");
	}
	
	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		Assert.assertEquals(true,searchCust.SearchCustomerByName("Victoria Terces"));
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		Assert.assertEquals(true,searchCust.SearchCustomerByEmail("victoria_victoria@nopCommerce.com"));
	}

	@Then("close the broswer")
	public void close_the_broswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
