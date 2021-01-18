package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends PageObject
{
	public static By logoutButton = By.id("logout");
	public static By heading = By.tagName("h2");
	public static By flashMessage = By.id("flash");
	
	public SecurePage(WebDriver driver)
	{
		super(driver);
	}

	public SecurePage(WebDriver driver, String baseUrl)
	{
		super(driver, baseUrl);
	}
	
	public String getHeading()
	{
		 return driver.findElement(heading).getText();
	}

	public String getFlashMessage()
	{
		return driver.findElement(flashMessage).getText();
	}
	
	
	public boolean isLoaded()
	{
		if (getHeading().equals("Secure Area"))
		{
			return true;
		}
		
		return false;
	}
}
