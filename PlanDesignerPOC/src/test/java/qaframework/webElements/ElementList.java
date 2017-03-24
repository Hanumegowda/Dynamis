package qaframework.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementList {
	
	public WebDriver driver;

	public ElementList(WebDriver _driver) {
		this.driver = _driver;
	}

	public WebElements element(String elementName, String locatorStrategy)
			throws Exception {
		return new WebElements(this, this.getWebDriverBy(elementName,
				locatorStrategy));
	}
	
	public WebElements dynamicElement(String elementName, String locator,String locatorStrategy)
			throws Exception {
		return new WebElements(this, this.getWebDriverBy(elementName, locator,
				locatorStrategy));
	}
	
	/**
	 * Functions fetch element and returns WebdriverWait element
	 * @param elementName
	 * @param locatorStrategy
	 * @return
	 * @throws Exception
	 */
	public WebdriverWait element_wait(String elementName, String locatorStrategy)
			throws Exception {
		return new WebdriverWait(this, this.getWebDriverBy(elementName,
				locatorStrategy));
	}
	
	public enum type {
		xpath, css, id, name, tagName, linktext, Class;
	}

	public By getWebDriverBy(String elementName, String locatorStrategy)
			throws Exception {
		By webdriverby = null;
		
		switch (type.valueOf(locatorStrategy)) {
		case xpath:
			webdriverby = By.xpath(elementName);
			break;
		case css:
			webdriverby = By.cssSelector(elementName);
			break;
		case id:
			webdriverby = By.id(elementName);
			break;
		case name:
			webdriverby = By.name(elementName);
			break;
		case tagName:
			webdriverby = By.tagName(elementName);
			break;
		case linktext:
			webdriverby = By.linkText(elementName);
			break;
		case Class:
			webdriverby = By.className(elementName);
			break;
		}
		return webdriverby;
	}
	
	public By getWebDriverBy(String elementName, String locator,String locatorStrategy)
			throws Exception {
		
		By webdriverby = null;
	
		switch (type.valueOf(locatorStrategy)) {
		case xpath:
			webdriverby = By.xpath(locator);
			break;
		case css:
			webdriverby = By.cssSelector(locator);
			break;
		case id:
			webdriverby = By.id(locator);
			break;
		case name:
			webdriverby = By.name(locator);
			break;
		case tagName:
			webdriverby = By.tagName(locator);
			break;
		case linktext:
			webdriverby = By.linkText(locator);
			break;
		}
		return webdriverby;
	}
}


