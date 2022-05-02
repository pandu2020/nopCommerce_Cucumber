Feature: Login


@sanity5
Scenario: Successul login with valid Credentials 
	Given User Launch the Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page title should be "Your store. Login"
	And close the browser 

@regression	
Scenario Outline: Llogin Data Driven 
	Given User Launch the Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter email as "<email>" and password as "<password>"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page title should be "Your store. Login"
	And close the browser 
	
Examples:
		| email | password |
		|	admin@yourstore.com |  admin |
		|	admin1@yourstore.com | admin123 |