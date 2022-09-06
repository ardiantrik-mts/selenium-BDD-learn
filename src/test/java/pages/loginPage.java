package pages;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class loginPage {
	WebDriver driver = null;
	WebDriverWait wait;
	String alert_text;
	
	By field_username = By.xpath("//input[@id='user-name']");
	By field_password = By.xpath("//input[@id='password']");
	By button_login = By.xpath("//input[@id='login-button']");
	By alert_failedLogin = By.xpath("//div[@class='error-message-container error']");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String username) {
		driver.findElement(field_username).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(field_password).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(button_login).click();
	}
	
	public String getAlertFailedLogin() {
		try {
	        driver.findElement(alert_failedLogin);
	    } catch (NoSuchElementException e) {
	        return null;
	    }
		alert_text = driver.findElement(alert_failedLogin).getText();
		return alert_text;
	}
}
