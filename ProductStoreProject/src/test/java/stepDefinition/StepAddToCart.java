package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.*;
import pageObjectModel.AddToCartPage;

public class StepAddToCart 
{
	//Declaration of driver element 
	public WebDriver driver;
	//Declaration of AddToCart page
	public AddToCartPage addcart;
	
	//Method to launch the chrome browser and intilization of add to cart page
	@Given("^The user launches the Chrome browser of demoblaze application$")
	public void the_user_launches_the_Chrome_browser_of_demoblaze_application() throws IOException  
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_v80.exe");
		driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		addcart = new AddToCartPage();
		addcart = PageFactory.initElements(driver, AddToCartPage.class);
		
		//Screenshot of product store application
		File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screen, new File("C:\\Users\\Shreyas\\git\\SaiPremSappa\\ProductStoreProject\\Screenshots\\demoblaze.jpg"));
	}

	//Method to select the product using addcart object
	@When("^Select the product$")
	public void select_the_product() throws InterruptedException 
	{
		addcart.product();		
	}
	//Method to select the Add to cart of selected producr using addcart object
	@When("^Click on Add to cart$")
	public void click_on_Add_to_cart() throws InterruptedException 
	{
		addcart.ToCart();		
	}

	
	//Method to accept the alert of the add to cart product andto close the browser
	@Then("^Accept the Alert message and close the Browser$")
	public void accept_the_Alert_message_and_close_the_Browser() throws InterruptedException 
	{
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		driver.close();
		
	}


}
