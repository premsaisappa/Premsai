package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.*;
import pageObjectModel.NextpageProduct;

public class StepsForNextPage
{
	//Declaration of driver element 
	public WebDriver driver;
	//Declaration of nextstep page
	public NextpageProduct NPP;

	//Method to launch the chrome browser and intilization of nextstep page
	@Given("^User launches the demo blaze application$")
	public void user_launches_the_demo_blaze_application() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_v80.exe");
		driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		NPP = new NextpageProduct();
		NPP = PageFactory.initElements(driver, NextpageProduct.class);


	}

	//Method to click the next button to go to the next page
	@Given("^Click on the next page$")
	public void click_on_the_next_page() 
	{
		NPP.NextButton();
	}

	//Method to select the product 
	@Then("^Select the product in the next page of mac$")
	public void select_the_product_in_the_next_page_of_mac() throws InterruptedException, IOException 
	{
		NPP.ProductMac();

		//Screenshot of product store application
		File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("C:\\Users\\Shreyas\\git\\SaiPremSappa\\ProductStoreProject\\Screenshots\\product.jpg"));
	}

	//Method to close the browser
	@Then("^Check the product and Close the BrowserApplication$")
	public void check_the_product_and_Close_the_BrowserApplication() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.close();
	}
}
