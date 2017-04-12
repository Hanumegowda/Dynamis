package lib.page;

import lib.locators.ExistingClients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
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
		waitForElement.waitForElements(ExistingClients.EMPLOYER_NAME, "xpath");
		this.page.element_wait(ExistingClients.EMPLOYER_NAME, "xpath").waitForVisibilityOfElement();
		this.page.element(ExistingClients.EMPLOYER_NAME, "xpath").clearInputValue().sendKeys(employer);
		return this;
	}
	
	public ExistingClientsPage clickCreateAndOpen()throws Exception{
		waitForElement.waitForElement(ExistingClients.CREATEANDOPEN, "id");
		this.page.element_wait(ExistingClients.CREATEANDOPEN, "id").waitForVisibilityOfElement();
		this.page.element_wait(ExistingClients.CREATEANDOPEN, "id").waitForElementEnable();
		this.page.element(ExistingClients.CREATEANDOPEN, "id").clickUsingJSE();
		return this;
	}
	
	public ExistingClientsPage createAndOpenEmployer(String employer) throws Exception{
		enterEmployerName(employer);
		clickCreateAndOpen();
		return this;
	}
}
