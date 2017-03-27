package page;

import helper.WaitForElement;
import helper.WaitTimeConstants;
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
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public ExistingClientsPage enterEmployerName(String employer) throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExistingClients.EMPLOYER_NAME)));
		waitForElement.waitForElements(ExistingClients.EMPLOYER_NAME, "xpath");
		this.page.element(ExistingClients.EMPLOYER_NAME, "xpath").clearInputValue().sendKeys(employer);
		return this;
	}
	
	public ExistingClientsPage clickOnCreateAndOpen()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ExistingClients.CREATEANDOPEN)));
		waitForElement.waitForElements(ExistingClients.CREATEANDOPEN, "id");
		this.page.element(ExistingClients.CREATEANDOPEN, "id").getOne().click();
		return this;
	}
	
	public ExistingClientsPage createAndOpenEmployer(String employer) throws Exception{
		enterEmployerName(employer);
		clickOnCreateAndOpen();
		return this;
		
	}
}
