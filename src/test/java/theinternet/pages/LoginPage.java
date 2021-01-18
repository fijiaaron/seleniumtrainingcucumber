package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject
{	
	public static By heading = By.tagName("h2");
	public static By flashMessage = By.id("flash");

	static String path = "/login";
	static String baseUrl = "https://the-internet.herokuapp.com";
	
	@FindBy(id="username")
	public WebElement usernameField;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(css="button.radius")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public LoginPage(WebDriver driver, String baseURL)
	{
		super(driver, baseURL);
	}
	
	public WebElement getUsername()
	{
		return usernameField;
	}
	
	public void setUsername(String username)
	{
		usernameField.sendKeys(username);
	}
	
	public WebElement getPassword()
	{
		return passwordField;
	}
	
	public void setPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public String getHeading()
	{
		 return driver.findElement(heading).getText();
	}

	public String getFlashMessage()
	{
		return driver.findElement(flashMessage).getText();
	}
	
	public static LoginPage load(WebDriver driver)
	{
		return new LoginPage(driver).open();
	}
	
	public void login(String username, String password)
	{
		setUsername(username);
		setPassword(password);	
		clickLoginButton();
	}
	
	public LoginPage open()
	{
		driver.get(baseUrl + path);
		return this;
	}
	
	public boolean isLoaded()
	{
		if (getHeading().equals("Login Page"))
		{
			return true;
		}
		
		return false;
	}
}
