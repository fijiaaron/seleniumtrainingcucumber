package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject
{
	protected String url;
	protected String baseUrl = "https://the-internet.herokuapp.com";
	protected WebDriver driver;
	
	public PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PageObject(WebDriver driver, String baseUrl)
	{
		this.driver = driver;
		this.baseUrl = baseUrl;
		PageFactory.initElements(driver, this);
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	abstract boolean isLoaded();
}
