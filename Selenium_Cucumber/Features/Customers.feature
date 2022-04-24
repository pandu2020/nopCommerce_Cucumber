Feature: Customers 

Background: Bellow are the common steps for Each scenario 
    Given User Launch the Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then User can View DashBoard

@sanity
Scenario: Add new Customer
    When user click on customer menu
	And Click on customer menu items 
	And Click on add new button
	Then user can view add new customer page
	When user enters cutomer info 
	And click on save button
	Then user can view message like "The new customer has been added successfully"
	And close the browser 

@regression
Scenario: Search Customer by Name
  	When user click on customer menu
	And Click on customer menu items 
	And Enter  Customer First Name
	And Enter  Customer Last Name
	When  Click on search button
	Then User should found name in the search table
	And close the broswer 

@regression	
Scenario: Search Customer by EamiID
   	When user click on customer menu
	And Click on customer menu items 
	And Enter the Customer Email
	When  Click on search button
	Then User should found email in the search table
	And close the broswer 
	
 