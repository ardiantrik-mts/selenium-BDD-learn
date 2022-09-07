package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

public class TransactionsStep {
	WebDriver driver = null;
	
	@Before("@TransactionsTest")
	public void setUpDriverAndScenario() {
		WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.navigate().to("https://saucedemo.com");
		
		loginPage loginPage = new loginPage(driver);
		
		loginPage.setUsername("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
	}
	
	@After("@TransactionsTest")
	public void tearDownTest() {
//		driver.close();
		driver.quit();
	}

	@Given("user is on inventory page")
	public void validateInventoryPage() {
	    //validate
	}

	@When("user clicks product {int} {string} button")
	public void inventoryProductButtonAction(Integer product_id, String button_type) {
		inventoryPage inventoryPage = new inventoryPage(driver);
		System.out.println(button_type.equals("Add to Cart"));
		
		if(button_type.equals("Add to Cart")) {
			inventoryPage.clickAddProduct(product_id);			
		} else {
			inventoryPage.clickRemoveProduct(product_id);
		}
	}

	@Then("cart counter should reflect number {int} based on the sum of products in cart")
	public void validateCartCounter(Integer productsCount) {
		inventoryPage inventoryPage = new inventoryPage(driver);
		Integer counter;
		
		counter = Integer.parseInt(inventoryPage.getCounterCart());
		Assert.assertEquals(counter, productsCount);
	}
	
	@Then("cart counter should disappear")
	public void validateDisappearCartCounter() {
		inventoryPage inventoryPage = new inventoryPage(driver);
		
		Assert.assertEquals(inventoryPage.getCounterCart(), null);
	}

}
