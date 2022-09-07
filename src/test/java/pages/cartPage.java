package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class cartPage {
	
	WebDriver driver = null;
	String counter;
	
	//INTITIALIZE ELEMENT
	//Cart Main Page
	By button_removeProduct1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	By button_removeProduct2 = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
	By button_backMainToInventory = By.xpath("//button[@id='continue-shopping']");
	By button_checkout = By.xpath("//button[@id='checkout']");
	
	//Cart Checkout Recipient Page
	By field_firstName = By.xpath("//input[@id='first-name']");
	By field_lastName = By.xpath("//input[@id='last-name']");
	By field_postalCode = By.xpath("//input[@id='postal-code']");
	By button_continue = By.xpath("//input[@id='continue']");
	By button_cancel = By.xpath("//button[@id='cancel']");
	By alert_fieldRequired = By.xpath("//div[@class='error-message-container error']");
	
	//Cart Checkout Overview Page
	By button_finish = By.xpath("//button[@id='finish']");
	
	//Cart Checkout Complete Page
	By container_checkoutComplete = By.xpath("//div[@id='checkout_complete_container']");
	By button_backCompleteToInventory = By.xpath("//button[@id='back-to-products']");
	
	public cartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCheckout() {
		driver.findElement(button_checkout).click();
	}
	
	public void setFirstName(String firstName) {
		driver.findElement(field_firstName).sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		driver.findElement(field_lastName).sendKeys(lastName);
	}
	
	public void setPostalCode(String postalCode) {
		driver.findElement(field_postalCode).sendKeys(postalCode);
	}
	
	public void clickContinue() {
		driver.findElement(button_continue).click();
	}
	
	public void clickFinish() {
		driver.findElement(button_finish).click();
	}
	
	public String getContainerComplete() {
		try {
	        driver.findElement(container_checkoutComplete);
	    } catch (NoSuchElementException e) {
	        return null;
	    }
		return "complete";
	}

}
