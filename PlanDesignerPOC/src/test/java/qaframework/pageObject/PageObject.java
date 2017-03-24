package qaframework.pageObject;

import org.openqa.selenium.WebDriver;

import qaframework.webElements.ElementList;

public abstract class PageObject {
	
	protected WebDriver driver;
	public ElementList page;
	
	public PageObject(WebDriver _driver) throws Exception{
		this.driver = _driver;
		this.page = new ElementList(this.driver);
	}
	
	public String getTitle() throws Exception {
		return this.driver.getTitle();
	}

}
