package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class inventoryPage {
	WebDriver driver = null;
	String counter;
	
	By container_inventoryList = By.xpath("//div[@class=\"inventory_list\"]");
	
	By button_addProduct1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By button_removeProduct1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	
	By button_addProduct2 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	By button_removeProduct2 = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
	
	By badge_counterCart = By.xpath("//span[@class='shopping_cart_badge']");
	By button_cart = By.xpath("//a[@class='shopping_cart_link']");
	
	public inventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCart() {
		driver.findElement(button_cart).click();
	}
	
	public String getCounterCart() {
		try {
	        driver.findElement(badge_counterCart);
	    } catch (NoSuchElementException e) {
	        return null;
	    }
		counter = driver.findElement(badge_counterCart).getText();
		return counter;
	}
	
	public void clickAddProduct(Integer product_id) {
		By element_button;
		if(product_id == 1) {
			element_button = button_addProduct1;		
		} else {
			element_button = button_addProduct2;
		}
		driver.findElement(element_button).click();	
	}
	
	public void clickRemoveProduct(Integer product_id) {
		By element_button;
		if(product_id == 1) {
			element_button = button_removeProduct1;		
		} else {
			element_button = button_removeProduct2;
		}
		driver.findElement(element_button).click();	
	}
}
