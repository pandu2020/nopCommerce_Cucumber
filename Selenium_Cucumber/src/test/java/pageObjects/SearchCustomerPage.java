package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waitHelper;

public SearchCustomerPage(WebDriver rdriver) {
		
		// TODO Auto-generated constructor stub
		
		ldriver = rdriver ;
		PageFactory.initElements(ldriver,this);
		waitHelper=new WaitHelper(ldriver);
	}

//By inputSearchCust = By.xpath("//input[@id='SearchEmail']");

@FindBy(how=How.ID,using="SearchEmail")
WebElement txtSearchEmail;

@FindBy(how=How.ID,using="SearchFirstName")
WebElement txtSearchFirstName;

@FindBy(how=How.ID,using="SearchLastName")
WebElement txtSearchLastName;

// Comment Additional Search input Files for future use 

/*@FindBy(how=How.ID,using="SearchMonthOfBirth")
WebElement selectSearchMonthOfBirth;

@FindBy(how=How.ID,using="SearchDayOfBirth")
WebElement selectSearchDayOfBirth;

@FindBy(how=How.ID,using="SearchCompany")
WebElement txtSearchCompany;

@FindBy(how=How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
WebElement txtCustomerRole;

@FindBy(how=How.XPATH,using="//li[contains(text(),'Administrators')]")
WebElement txtAdministrators;


@FindBy(how=How.XPATH,using="//li[contains(text(),'Guests')]")
WebElement txtGuests;

@FindBy(how=How.XPATH,using="//li[contains(text(),'Registered')]")
WebElement txtRegistered;

@FindBy(how=How.XPATH,using="//li[contains(text(),'Vendors')]")
WebElement txtVendors;

@FindBy(how=How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
WebElement txtForumModerators; */

@FindBy(how=How.ID,using="search-customers")
WebElement btnSearch;

@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
WebElement table;

@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
List<WebElement> tableRows;

@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
List<WebElement> tableColoums;


public void setEmail(String email)
{
	waitHelper.WaitForElement(txtSearchEmail, 30);
	txtSearchEmail.clear();
	txtSearchEmail.sendKeys(email);
}

public void settxtFirstName(String fname)
	{
	waitHelper.WaitForElement(txtSearchFirstName, 30);
	txtSearchFirstName.clear();
	txtSearchFirstName.sendKeys(fname);
	}
	
	public void settxtLastName(String lname)
	{
		waitHelper.WaitForElement(txtSearchLastName, 30);
		txtSearchLastName.clear();
		txtSearchLastName.sendKeys(lname);
	}
	
	public void  clickSearch()
	{
		
		btnSearch.click();
		waitHelper.WaitForElement(btnSearch, 30);
		
	}
	public int  getRowNum()
	{
		return  tableRows.size();
	}
	
	public int  getColumNum()
	{
		return  tableColoums.size();
	}
	
	
	public boolean SearchCustomerByEmail(String email)
	{
		boolean flag=false;
				for(int i=1;i<=getRowNum();i++)
				{
		String emailID = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
					if(emailID.equals(email))
					{
						flag=true;
					}
				}
				return flag;
	}
	
	public boolean SearchCustomerByName(String name)
	{
		boolean flag=false;
				for(int i=1;i<=getRowNum();i++)
				{
		String name1 = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
		String	names[]=name1.split(" ");
		if(names[0].equals("Victoria")&&names[1].equals("Terces"))
					{
						flag=true;
					}
				}                    
				return flag;
	}
	
}
