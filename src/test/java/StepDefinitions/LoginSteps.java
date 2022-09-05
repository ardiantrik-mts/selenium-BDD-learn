package StepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {
	@Given("is on login page")
	public void navigateLoginPage() {
		System.out.println("Given - is on login page");

	}

	@When("user enters username and password")
	public void setUsernameAndPassword() {
		System.out.println("When - user enters username and password");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("And - clicks on login button");
	}

	@Then("user is navigated to the inventory page")
	public void user_is_navigated_to_the_inventory_page() {
		System.out.println("Then - user is navigated to the inventory page");
	}
}
