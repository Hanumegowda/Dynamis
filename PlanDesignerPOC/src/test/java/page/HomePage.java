package page;

import locators.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;

public class HomePage extends PageObject{

	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public HomePage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public HomePage clickAddNewExistingClient()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home.ADDNEW_EXISTINGCLIENT)));
		waitForElement.waitForElements(Home.ADDNEW_EXISTINGCLIENT, "xpath");
		this.page.element(Home.ADDNEW_EXISTINGCLIENT, "xpath").getOne().click();
		return this;
	}
}
