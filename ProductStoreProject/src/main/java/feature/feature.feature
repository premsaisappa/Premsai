@Task_Management
Feature: ProductStore Website

@TC_01_Login
Scenario Outline:	Login into Demo Blaze Website
Given The user launch the Chrome application
When Clicking on LoginTab to nagivate Login Page
Then The user login using "<username>" and "<password>" with vaild and invaild deatils
Then Clicking on login button and close the browser

Examples: 
	| username   |  password   |
	| premsai    | premsai	   |
	|  bltcts	 |   123456    |
    |  shreyas	 |   123456789 |

	

@TC_02_Add_Cart
Scenario:
	Adding to cart of product
	
Given The user launches the Chrome browser of demoblaze application
When Select the product 
And Click on Add to cart
Then Accept the Alert message and close the Browser 

@TC_03_contact
Scenario:

Given User launches the product store application
When Click on the contact tab
And Enter the Contact Email as "premsaisappa@gmail.com" and Contact Name as "prem"
Then Enter the Message as "Demo blaze having good collection"
Then Accept the Alert message in contact and close the Application Browser


@TC_04_nextpage
Scenario:
To click on next page and select the product
Given User launches the demo blaze application
And Click on the next page
Then Select the product in the next page of mac
And Check the product and Close the BrowserApplication