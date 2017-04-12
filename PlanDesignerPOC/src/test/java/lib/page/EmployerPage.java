package lib.page;

import lib.locators.Employer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;

public class EmployerPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;
	
	public EmployerPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public EmployerPage navigateToAddNewCoveragePeriods()throws Exception{
		waitForElement.waitForElement(Employer.ADDNEWCOVERAGEPERIOD, "xpath");
		this.page.element_wait(Employer.ADDNEWCOVERAGEPERIOD, "xpath").waitForVisibilityOfElement();
		this.page.element(Employer.ADDNEWCOVERAGEPERIOD, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickNo()throws Exception{
		waitForElement.waitForElements(Employer.NO, "xpath");
		this.page.element_wait(Employer.NO, "xpath").waitForVisibilityOfElement();
		this.page.element(Employer.NO, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage enterCoveragePeriodName(String coverageperiod)throws Exception{
		waitForElement.waitForElements(Employer.COVERAGEPERIODNAME, "xpath");
		this.page.element_wait(Employer.COVERAGEPERIODNAME, "xpath").waitForVisibilityOfElement();
		this.page.element(Employer.COVERAGEPERIODNAME, "xpath").isElementPresent();
		this.page.element(Employer.COVERAGEPERIODNAME, "xpath").getOne().isDisplayed();
		this.page.element(Employer.COVERAGEPERIODNAME, "xpath").clearInputValue().sendKeys(coverageperiod);
		return this;
	}
	
	public EmployerPage clickCreate()throws Exception{
		waitForElement.waitForElements(Employer.CREATE, "xpath");
		this.page.element_wait(Employer.CREATE, "xpath").waitForVisibilityOfElement();
		this.page.element(Employer.CREATE, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickFinish()throws Exception{
		waitForElement.waitForElements(Employer.FINISH, "xpath");
		this.page.element(Employer.FINISH, "xpath").waitForPageToLoad();
		this.page.element_wait(Employer.FINISH, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(Employer.FINISH, "xpath").waitForElementEnable();
		this.page.element(Employer.FINISH, "xpath").clickUsingJSE();
		return this;
	}
	
	public EmployerPage createCoveragePeriod(String coverageperiod)throws Exception{
		navigateToAddNewCoveragePeriods();
		clickNo();
		enterCoveragePeriodName(coverageperiod);
		clickCreate();
		clickFinish();
		return this;
	}

}
