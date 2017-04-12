package lib.page;

import lib.locators.HeaderNavigation;
import lib.locators.Home;
import lib.locators.PlanDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	public HomePage addNewExistingClient()throws Exception{
		waitForElement.waitForElements(Home.ADDNEWEXISTINGCLIENT, "xpath");
		this.page.element_wait(Home.ADDNEWEXISTINGCLIENT, "xpath").waitForVisibilityOfElement();
		this.page.element(Home.ADDNEWEXISTINGCLIENT, "xpath").getOne().click();
		return this;
	}
	
	public HomePage navigateToExistingClient()throws Exception{
		waitForElement.waitForElements(Home.EXISTINGCLIENT, "xpath");
		this.page.element_wait(Home.EXISTINGCLIENT, "xpath").waitForVisibilityOfElement();
		this.page.element(Home.EXISTINGCLIENT, "xpath").getOne().click();
		return this;
	}
	
	public HomePage searchEmployer(String employer)throws Exception{
		waitForElement.waitForElements(Home.EMPLOYERNAMESEARCHFIELD, "xpath");
		this.page.element_wait(Home.EMPLOYERNAMESEARCHFIELD, "xpath").waitForVisibilityOfElement();
		this.page.element(Home.EMPLOYERNAMESEARCHFIELD, "xpath").getOne().sendKeys(employer);
		return this;
	}
	public HomePage selectEmployer(String employer)throws Exception{
		String selEmployer = PlanDesign.DIVTEXT+employer+PlanDesign.SQUREBRACKET;
		this.page.element_wait(selEmployer, "xpath").waitForVisibilityOfElement();
		this.page.element(selEmployer, "xpath").getOne().click();
		return this;
	}
	
	public HomePage searchAndSelectExistingClient(String employer)throws Exception{
		  searchEmployer(employer);
		  selectEmployer(employer);
		  return this;
		 }
	
	public HomePage clickSearch()throws Exception{
		waitForElement.waitForElements(Home.SEARCH, "xpath");
		this.page.element_wait(Home.SEARCH, "xpath").waitForVisibilityOfElement();
		this.page.element(Home.SEARCH, "xpath").getOne().click();
		return this;
	}
	
	public HomePage navigateToHome()throws Exception{
		waitForElement.waitForElement(Home.HOME, "xpath");
		this.page.element_wait(Home.HOME, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(Home.HOME, "xpath").waitForElementEnable();
		this.page.element(Home.HOME, "xpath").getOne().click();
		return this;
	}
	
	public HomePage verifyHomePage()throws Exception{
		waitForElement.waitForElements(Home.AGENCYADMIN, "xpath");
		Assert.assertTrue((this.page.element(Home.AGENCYADMIN, "xpath")).isElementPresent());
		Assert.assertTrue((this.page.element(HeaderNavigation.LOGOUT, "xpath")).isElementPresent());
		return this;
	}
	
	public HomePage verifyHomePageNotDisplayed()throws Exception{
		waitForElement.waitForElements(Home.AGENCYADMIN, "xpath");
		Assert.assertFalse((this.page.element(HeaderNavigation.LOGOUT, "xpath")).getOne().isDisplayed());
		return this;
	}

}
