package page;

import helper.WaitForElement;
import locators.Employer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.pageObject.PageObject;

public class EmployerPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;
	
	public EmployerPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(driver);
	}
	
	public EmployerPage clickOnAddNewCoveragePeriods()throws Exception{
		waitForElement.waitForElements(Employer.ADDNEW_COVERAGEPERIOD, "xpath");
		this.page.element(Employer.ADDNEW_COVERAGEPERIOD, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickOnCreate()throws Exception{
		waitForElement.waitForElements(Employer.CREATE, "xpath");
		this.page.element(Employer.CREATE, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickOnFinish()throws Exception{
		waitForElement.waitForElements(Employer.FINISH, "xpath");
		this.page.element(Employer.FINISH, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage createCoveragePeriod()throws Exception{
		clickOnAddNewCoveragePeriods();
		clickOnCreate();
		clickOnFinish();
		return this;
	}

}
