package module;

import locators.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Module {

	WebDriver driver;
	WebDriverWait wait;

	public Module(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public Module clickAccountSettings(){
		driver.findElement(By.cssSelector(locators.Module.ACCOUNT_SETTINGS)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.Module.LOGOUT)));
		return this;
	}
	
	public Module clickLogout(){
		driver.findElement(By.xpath(locators.Module.LOGOUT)).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Login.EMAIL_PHONE)));
		return this;
	}
}
