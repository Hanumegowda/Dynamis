package lib.page;

import lib.locators.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;
import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;

public class LoginPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public LoginPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public LoginPage lauchUrl(String url){
		driver.get(url);
		return this;
	}
	
	public LoginPage clickLoginButton()throws Exception{
		waitForElement.waitForElements(Login.LOGIN, "xpath");
		this.page.element_wait(Login.LOGIN, "xpath").waitForElementEnable();
		this.page.element(Login.LOGIN, "xpath").getOne().click();
		return this;
	}
	
	public LoginPage enterUserName(String username)throws Exception{
		waitForElement.waitForElements(Login.USERNAME, "id");
		this.page.element(Login.USERNAME, "id").clearInputValue().sendKeys(username);
		assertEquals(this.page.element(Login.USERNAME, "id").getOne().getAttribute("value"),username);
		return this;
	}
	
	public LoginPage enterPassword(String password)throws Exception{
		waitForElement.waitForElements(Login.PASSWORD, "id");
		this.page.element(Login.PASSWORD, "id").clearInputValue().sendKeys(password);
		assertEquals(this.page.element(Login.PASSWORD, "id").getOne().getAttribute("value"),password);
		return this;
	}
	
	public LoginPage login(String url,String username,String password)throws Exception{
		lauchUrl(url);
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
		return this;
	}
	public LoginPage verifyInvalidCredentialsError()throws Exception{
		waitForElement.waitForElements(Login.AUTHENTICATIONERROR, "xpath");
		assertTrue((this.page.element(Login.AUTHENTICATIONERROR, "xpath").isElementPresent()));
		return this;
	}
}