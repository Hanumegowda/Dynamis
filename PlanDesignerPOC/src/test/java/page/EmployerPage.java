package page;

import locators.Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		waitForElement = new WaitForElement(driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public EmployerPage clickOnAddNewCoveragePeriods()throws Exception{
		waitForElement.waitForElements(Employer.ADDNEWCOVERAGEPERIOD, "xpath");
		this.page.element(Employer.ADDNEWCOVERAGEPERIOD, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickOnNo()throws Exception{
		waitForElement.waitForElements(Employer.NO, "xpath");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Employer.NO)));
		this.page.element(Employer.NO, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage enterCoveragePeriodName(String coverageperiod)throws Exception{
		waitForElement.waitForElements(Employer.COVERAGEPERIODNAME, "xpath");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Employer.COVERAGEPERIODNAME)));
		this.page.element(Employer.COVERAGEPERIODNAME, "xpath").clearInputValue().sendKeys(coverageperiod);
		return this;
	}
	
	public EmployerPage clickOnCreate()throws Exception{
		waitForElement.waitForElements(Employer.CREATE, "xpath");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Employer.CREATE)));
		this.page.element(Employer.CREATE, "xpath").getOne().click();
		return this;
	}
	
	public EmployerPage clickOnFinish()throws Exception{
		waitForElement.waitForElements(Employer.FINISH, "xpath");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Employer.FINISH)));
		this.page.element(Employer.FINISH, "xpath").mouseOver();
		this.page.element(Employer.FINISH, "xpath").clickUsingJSE();
		return this;
	}
	
	public EmployerPage createCoveragePeriod(String coverageperiod)throws Exception{
		clickOnAddNewCoveragePeriods();
		clickOnNo();
		enterCoveragePeriodName(coverageperiod);
		clickOnCreate();
		clickOnFinish();
		return this;
	}

}
