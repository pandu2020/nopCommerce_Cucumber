package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class WaitHelper 

{
	public WebDriver ldriver;
	
public WaitHelper(WebDriver rdriver) 
{
	ldriver = rdriver ;
}

public void WaitForElement(WebElement element,long TimeunitsInSEconds)
{
  WebDriverWait wait=new WebDriverWait(ldriver,TimeunitsInSEconds);
  wait.until(ExpectedConditions.visibilityOf(element));
}
}	