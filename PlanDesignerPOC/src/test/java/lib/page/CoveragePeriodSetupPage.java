package lib.page;

import lib.locators.CoveragePeriodSetup;
import lib.locators.PlanDesign;

import org.openqa.selenium.WebDriver;

import qaframework.helper.WaitForElement;
import qaframework.pageObject.PageObject;

public class CoveragePeriodSetupPage extends PageObject{
	
	WebDriver driver;
	WaitForElement waitForElement;
	
	public CoveragePeriodSetupPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public CoveragePeriodSetupPage navigateToEnrollmentTypesAndClasses() throws Exception{
		waitForElement.waitForElement(CoveragePeriodSetup.ENROLLMENTTYPEANDCLASSES,"xpath");
		waitForElement.waitForElements(CoveragePeriodSetup.ENROLLMENTTYPEANDCLASSES,"xpath");
		this.page.element_wait(CoveragePeriodSetup.ENROLLMENTTYPEANDCLASSES, "xpath").waitForVisibilityOfElement();
		this.page.element(CoveragePeriodSetup.ENROLLMENTTYPEANDCLASSES, "xpath").getOne().click();
		return this;
	}
	
	public CoveragePeriodSetupPage selectEnrollementTypes(String enrollmenttype) throws Exception{
		String enrollmentType = CoveragePeriodSetup.TDCONTAINSTEXT+enrollmenttype+PlanDesign.CLOSEBRACKET+CoveragePeriodSetup.PRECEDINGSIBLINGTDIMG;
		waitForElement.waitForElements(enrollmentType,"xpath");
		this.page.element_wait(enrollmentType, "xpath").waitForVisibilityOfElement();
		this.page.element(enrollmentType, "xpath").getOne().click();
		return this;
	}

}
