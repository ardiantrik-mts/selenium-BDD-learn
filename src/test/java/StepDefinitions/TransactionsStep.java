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
	
	@When("user click cart icon")
	public void cartIconAction() {
		inventoryPage inventoryPage = new inventoryPage(driver);
		
		inventoryPage.clickCart();
	}
	
	@When("user click {string} button")
	public void cartActionButton(String button_type) {
		cartPage cartPage = new cartPage(driver);
		
		if(button_type.equals("Checkout")) {
			cartPage.clickCheckout();			
		} 

		if(button_type.equals("Continue")) {
			cartPage.clickContinue();
		}
	
		if(button_type.equals("Finish")) {
			cartPage.clickFinish();
		}
	}

	@When("^user set the recipient data with (.*), (.*), (.*)$")
	public void setRecipientData(String first_name, String last_name, String postal_code) {
		cartPage cartPage = new cartPage(driver);
		
		cartPage.setFirstName(first_name);
		cartPage.setLastName(last_name);
		cartPage.setPostalCode(postal_code);
	}

	@Then("user should see the transaction complete in the current page")
	public void validateCompletePage() {
		cartPage cartPage = new cartPage(driver);
		
		String isComplete = cartPage.getContainerComplete();
		Assert.assertEquals(isComplete, "complete");
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
