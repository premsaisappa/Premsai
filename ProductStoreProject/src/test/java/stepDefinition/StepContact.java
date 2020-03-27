package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.*;
import pageObjectModel.ContactPage;

public class StepContact
{
	//Declaration of driver element 
	public WebDriver driver;
	//Declaration of contact page
	public ContactPage contact;
	
	//Method to launch the chrome browser and intilization of contact page
	@Given("^User launches the product store application$")
	public void user_launches_the_product_store_application() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_v80.exe");
		driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		contact = new ContactPage();
		contact = PageFactory.initElements(driver, ContactPage.class);
	}
	//Method to select the contact tab
	@When("^Click on the contact tab$")
	public void click_on_the_contact_tab() throws InterruptedException 
	{
	 contact.ContactTab();  
	}
	//Method to enter the contact details of the user i.e Email and Name
	@When("^Enter the Contact Email as \"([^\"]*)\" and Contact Name as \"([^\"]*)\"$")
	public void enter_the_Contact_Email_as_and_Contact_Name_as(String arg1, String arg2) throws InterruptedException 
	{
		Thread.sleep(1000);
	    contact.ContactEmailAndName(arg1, arg2);		
	}

	//Method to send the message  
	@Then("^Enter the Message as \"([^\"]*)\"$")
	public void enter_the_Message_as(String arg1) throws InterruptedException 
	{
		Thread.sleep(1000);
		contact.ContactMessage(arg1);
	}
	//Method to accept the alert message of the contact page and close the browser
	@Then("^Accept the Alert message in contact and close the Application Browser$")
	public void accept_the_Alert_message_in_contact_and_close_the_Application_Browser() throws InterruptedException 
	{
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		driver.close();
	}


}
