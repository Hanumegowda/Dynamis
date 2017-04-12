package lib.navigation;

import lib.locators.SidebarNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;

public class SidebarNavigations extends PageObject{
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public SidebarNavigations(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public SidebarNavigations navigateCoveragePeriodSetup()throws Exception{
		waitForElement.waitForElements(SidebarNavigation.COVERAGEPERIODSETUP, "xpath");
		this.page.element_wait(SidebarNavigation.COVERAGEPERIODSETUP, "xpath").waitForVisibilityOfElement();
		this.page.element(SidebarNavigation.COVERAGEPERIODSETUP, "xpath").getOne().click();
		return this;
	}
	
	public SidebarNavigations navigateToPlanDesigns()throws Exception{
		waitForElement.waitForElements(SidebarNavigation.PLANDESIGNS, "xpath");
		this.page.element_wait(SidebarNavigation.PLANDESIGNS, "xpath");
		this.page.element(SidebarNavigation.PLANDESIGNS, "xpath").getOne().click();
		return this;
	}

}
