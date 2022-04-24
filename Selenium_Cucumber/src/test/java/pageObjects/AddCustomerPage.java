package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		// TODO Auto-generated constructor stub
		
		ldriver = rdriver ;
		PageFactory.initElements(ldriver,this);
		
	}
	
	// Add New Custome Page Locators 
	
	By lnkCustomerMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomerMenuItems = By.xpath("//a[@href='/Admin/Customer/List']");
	
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.xpath("//*[@id='Email']");

	By txtPassword = By.xpath("//*[@id='Password']");
	
	
	By txtNewLetter = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[1]");
	By lstYourstorename = By.xpath("//li[contains(text(),'Your store name')]");
	By lstTeststore2 = By.xpath("//li[contains(text(),'Test store 2')]");
	
	
	
	By txtCustomerRoles = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
		
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By lstitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	

	
	By drgMgRVendor = By.xpath("//*[@id='VendorId']");
	
	By rdGender_Male = By.xpath("//input[@id='Gender_Male']");
	
	By rdGender_Female = By.xpath("//input[@id='Gender_Female']");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By txtDoB = By.xpath("//input[@id='DateOfBirth']");
	
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave = By.xpath("//button[@name='save']");
	

	 // Action Methods 
	
	

	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
     public void clickOnCustomerMenu()
     {
    	 ldriver.findElement(lnkCustomerMenu).click();
     }
     
     public void clickOnCustomerMenuItems()
     {
    	 ldriver.findElement(lnkCustomerMenuItems).click();
     }
	
	 public void clickOnAddNew()
	 {
		 ldriver.findElement(btnAddNew).click();
	 }
	
	 public void setEmail(String email)
	 {
		 ldriver.findElement(txtEmail).sendKeys(email);
	 }
	 
	 public void setPassword(String password)
	 {
		 ldriver.findElement(txtPassword).sendKeys(password);
	 }
	 
	
		public void settxtNewLetter(String newsLetter ) throws InterruptedException
		{
						
			ldriver.findElement(txtNewLetter).click();
		    Thread.sleep(2000);
	    	WebElement listItem;
			
			if(newsLetter.equals("Your store name"))
	    	{
	    		listItem = ldriver.findElement(lstYourstorename);
	    	}
	    	else // if(role.equals("Test store 2"))
	    	{
	    		listItem = ldriver.findElement(lstTeststore2);
	    	}
			
			listItem.click();
	    	Thread.sleep(3000);
	    	
	    	//When Ever Click Action does't work go with JavascriptExecutor
	    	
	    /*	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	    	js.executeScript("arguments[0].click();", listItem); */
		}
  
	
    public void setCustomerRoles(String role)throws Exception
    {
    	// If the role is vendors should not delete register 
    	if(!role.equals("Vendors"))
    	{
    		ldriver.findElement(By.xpath("(//*[@id='SelectedCustomerRoleIds_taglist']/li/span)[2]")).click();;
    	}
    	
    	ldriver.findElement(txtCustomerRoles).click();
    	Thread.sleep(2000);
    	WebElement listItem;
    	
    	if(role.equals("Administrators"))
    	{
    		listItem = ldriver.findElement(lstitemAdministrators);
    	}
    	else if(role.equals("Guests"))
    	{
    		listItem = ldriver.findElement(lstitemGuests);
    	}
    	else if(role.equals("Registered"))
    	{
    		listItem = ldriver.findElement(lstitemRegistered);
    	}
    	else if(role.equals("Vendors"))
    	{
    		listItem = ldriver.findElement(lstitemVendors);
    	}
    	else // if(role.equals("Forum Moderators"))
    	{
    		listItem = ldriver.findElement(lstitemForumModerators);
    	}
   
    	listItem.click();
    	Thread.sleep(3000);
    	
    	//When Ever Click Action does't work go with JavascriptExecutor
    	
    /*	JavascriptExecutor js=(JavascriptExecutor)ldriver;
    	js.executeScript("arguments[0].click();", listItem); */
    	
    	
    }
    
    
    
    
    
    public void setManagerOfVendor(String value)
    {
    	Select drp=new Select(ldriver.findElement(drgMgRVendor));
    	drp.selectByVisibleText(value);
    }
    
     public void setGender(String gender)
     {
    	 if(gender.equals("Female"))
    	 {
    		 ldriver.findElement(rdGender_Female).click();
    	 }
    	 else 
    	 {
    		 ldriver.findElement(rdGender_Male).click();
    	 }
     }
     
     
     public void settxtFirstName(String fname)
 	{
 		ldriver.findElement(txtFirstName).sendKeys(fname);
 	}
 	
 	public void settxtLastName(String lname)
 	{
 		ldriver.findElement(txtLastName).sendKeys(lname);
 	}
 	
 	public void settxtDoB(String dob)
 	{
 		ldriver.findElement(txtDoB).sendKeys(dob);
 	}
 	
 	public void settxtCompanyName(String companyName)
 	{
 		ldriver.findElement(txtCompanyName).sendKeys(companyName);
 	}
 	
 	public void setttxtAdminComment(String adminComment)
 	{
 		ldriver.findElement(txtAdminComment).sendKeys(adminComment);
 	}
 	
 	public void clickBtnSave()
 	{
 		ldriver.findElement(btnSave).click();
 	}
     
     
    
     
}
