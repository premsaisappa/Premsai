package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.*;
import pageObjectModel.LoginPage;

public class StepLoginPage 
{
	//Declaration of driver element 
		public WebDriver driver;
		//Declaration of login page
	public LoginPage loginpage;
	
	//Method to launch the chrome browser and intilization of Login page
	@Given("^The user launch the Chrome application$")
	public void the_user_launch_the_Chrome_application() 
	{
		System.out.println("launching chrome browser"); 
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_v80.exe");
		driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		
	}
	//Method to select the login tab
	@When("^Clicking on LoginTab to nagivate Login Page$")
	public void clicking_on_LoginTab_to_nagivate_Login_Page() 
	{
		loginpage.LoginTab();		
		
	}

	//Method to enter the username and password to login the page 
	@Then("^The user login using \"([^\"]*)\" and \"([^\"]*)\" with vaild and invaild deatils$")
	public void the_user_login_using_and_with_vaild_and_invaild_deatils(String arg1, String arg2) throws InterruptedException  
	{
		
		Thread.sleep(1000);
		loginpage.UsernameAndPassword(arg1, arg2);
		
		
	}

	//Method to login and close the browser
	@Then("^Clicking on login button and close the browser$")
	public void clicking_on_login_button_and_close_the_browser() throws InterruptedException 
	{
		loginpage.LoginButton();
		Thread.sleep(15000);
		
		driver.close();		
		
		
	}

}
