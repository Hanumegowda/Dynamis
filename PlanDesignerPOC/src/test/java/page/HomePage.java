package page;

import helper.WaitForElement;
import locators.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaframework.pageObject.PageObject;

public class HomePage extends PageObject{

	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public HomePage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		
	}
	
	public HomePage clickAddNewExistingClient()throws Exception{
		waitForElement.waitForElements(Home.ADDNEW_EXISTINGCLIENT, "xpath");
		this.page.element(Home.ADDNEW_EXISTINGCLIENT, "xpath").getOne().click();
		return this;
	}
}
