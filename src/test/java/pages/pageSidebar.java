package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageSidebar {

	WebDriver driver = null;
	WebDriverWait wait;
	
	By button_logout = By.xpath("//a[@id='logout_sidebar_link']");
	By button_resetState = By.xpath("//a[@id='reset_sidebar_link']");
	By button_sidebarMenu = By.xpath("//button[@id='react-burger-menu-btn']");
	
	public pageSidebar(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSideBar() {
		driver.findElement(button_sidebarMenu).click();
	}
	
	public void clickLogout() {
		driver.findElement(button_logout).click();
	}
	
	public void clickResetState() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_resetState));
		driver.findElement(button_resetState).click();
	}
}
