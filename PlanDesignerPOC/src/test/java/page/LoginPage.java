package page;

import helper.WaitForElement;
import locators.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import qaframework.pageObject.PageObject;

public class LoginPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;

	public LoginPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public LoginPage lauchUrl(String url){
		driver.get(url);
		return this;
	}
	
	public LoginPage clickOnLoginButton()throws Exception{
		waitForElement.waitForElements(Login.LOGIN, "xpath");
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
		assertEquals(this.page.element(Login.PASSWORD, "css").getOne().getAttribute("value"),password);
		return this;
	}
	
	public LoginPage loginAsAdmin(String url,String username,String password)throws Exception{
		lauchUrl(url);
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		return this;
	}
}