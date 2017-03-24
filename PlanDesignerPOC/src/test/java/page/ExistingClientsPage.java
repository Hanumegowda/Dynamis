package page;

import helper.WaitForElement;
import locators.ExistingClients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.pageObject.PageObject;

public class ExistingClientsPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;
	
	public ExistingClientsPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(driver);
	}
	
	public ExistingClientsPage enterEmployerName(String employer){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExistingClients.EMPLOYER_NAME)));
		driver.findElement(By.xpath(ExistingClients.EMPLOYER_NAME)).clear();
		driver.findElement(By.xpath(ExistingClients.EMPLOYER_NAME)).sendKeys(employer);
		return this;
	}
	
	public ExistingClientsPage clickOnCreateAndOpen(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ExistingClients.CREATEANDOPEN)));
		driver.findElement(By.id(ExistingClients.CREATEANDOPEN)).click();
		return this;
	}
	
	public ExistingClientsPage createAndOpenEmployer(String employer) throws Exception{
		enterEmployerName(employer);
		clickOnCreateAndOpen();
		return this;
		
	}
}
