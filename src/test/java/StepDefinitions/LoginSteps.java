package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginPage;

public class LoginSteps {
	WebDriver driver = null;
	
	
	@Given("user is on login page")
	public void navigateLoginPage() {
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
		System.out.println("Given - is on login page - SUCCESS");

	}

	@When("^user enters (.*) and (.*)$")
	public void setUsernameAndPassword(String username, String password) {
		loginPage loginPage = new loginPage(driver);
		
		loginPage.setUsername(username);
		loginPage.setPassword(password);

		System.out.println("When - user enters username and password");
	}

	@When("clicks on login button")
	public void clickLogin() {
		loginPage loginPage = new loginPage(driver);
		
		loginPage.clickLogin();
		
		System.out.println("And - clicks on login button");
	}

	@Then("user is navigated to the inventory page")
	public void navigatedToInventoryPage() {
		System.out.println("Then - user is navigated to the inventory page");
		driver.close();
	}
	
	@Then("^user should see a failed login alert (.*)$")
	public void failedLoginAlertAppear(String alert_text_expected) {
		loginPage loginPage = new loginPage(driver);
		String alert_text;
		
		alert_text = loginPage.getAlertFailedLogin();
		Assert.assertEquals(alert_text, alert_text_expected);
		System.out.println("Then - user should see a failed login alert");
		driver.close();
	}
}
