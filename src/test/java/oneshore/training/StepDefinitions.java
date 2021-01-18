package oneshore.training;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theinternet.pages.LoginPage;
import theinternet.pages.SecurePage;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions
{
	WebDriver driver;
	LoginPage loginPage;
	SecurePage securePage;

	@Given("I am on the login page")
	public void i_am_on_the_login_page()
	{
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		securePage = new SecurePage(driver);
		loginPage.open();
	}

	@When("I enter my username and password")
	public void i_enter_my_username_and_password()
	{
		loginPage.login("tomsmith", "SuperSecretPassword!");
	}

	@Then("I should be able to access the secure area")
	public void i_should_be_able_to_access_the_secure_area()
	{
		String heading = securePage.getHeading();
		String flashMessage = securePage.getFlashMessage();
		
		assertThat(heading).isEqualTo("Secure Area");
		assertThat(flashMessage).contains("You logged into a secure area");
	}
}
