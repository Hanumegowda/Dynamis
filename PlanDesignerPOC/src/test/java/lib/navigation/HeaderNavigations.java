package lib.navigation;

import lib.locators.HeaderNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;

public class HeaderNavigations extends PageObject{

	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public HeaderNavigations(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public HeaderNavigations clickLogout()throws Exception{
		waitForElement.waitForElements(HeaderNavigation.LOGOUT, "xpath");
		this.page.element(HeaderNavigation.LOGOUT, "xpath").waitForPageToLoad();
		this.page.element_wait(HeaderNavigation.LOGOUT, "xpath").waitForElementEnable();
		this.page.element_wait(HeaderNavigation.LOGOUT, "xpath").waitForInvisibilityOfElement();
		this.page.element(HeaderNavigation.LOGOUT, "xpath").getOne().click();
		return this;
	}
}
