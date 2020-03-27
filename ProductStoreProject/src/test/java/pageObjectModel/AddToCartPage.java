package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddToCartPage 
{
	
	//Data driven elements of the Nokia product and the add to cart button
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
	public WebElement nokia1520;
	
	@FindBy(partialLinkText="Add to cart")
	public WebElement addToCart;
	
	//Method functions of the WebElements of Add To Cart Page
	public void product() throws InterruptedException
	{
		Thread.sleep(1000);
		nokia1520.click();
	}
	
	public void ToCart() throws InterruptedException
	{
		Thread.sleep(5000);
		addToCart.click();
	}
}
