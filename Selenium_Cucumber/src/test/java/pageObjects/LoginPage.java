package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		// TODO Auto-generated constructor stub
		
		ldriver = rdriver ;
		PageFactory.initElements(ldriver,this);
		
	}
	
	
	@FindBy(how=How.ID,using="Email")
  	WebElement txtEmail;
	
	@FindBy(how=How.ID,using="Password")
    WebElement txtPassword;

	@FindBy(how=How.XPATH,using="//button[@type='submit']")
   	WebElement btnLogIn;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"navbarText\"]/ul/li[3]/a")
    WebElement btnLogOut;

	  public void setUserName(String uname)
	  {
		  txtEmail.clear();
		  txtEmail.sendKeys(uname);
	  }
	  
	  public void setPassword(String pwd)
	  {
		  txtPassword.clear();
		  txtPassword.sendKeys(pwd);
	  }
	  
	  
      public void clickLogIn()
      {
    	  btnLogIn.click();
      }
      
      public void clickLogOut()
      {
    	  btnLogOut.click();
      }
	

}
