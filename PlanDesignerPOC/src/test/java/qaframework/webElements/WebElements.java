package qaframework.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebElements {
	
	public By webDrivryBy;
	WebDriver driver;

	public WebElements(ElementList elementList, By by) {
		this.driver = elementList.driver;
		this.webDrivryBy = by;
	}

	/**
	 * Verifies whether element present or not
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public WebElement getOne() throws Exception {
		WebElement element = this.driver.findElement(this.webDrivryBy);
		return element;
	}
	
	public List<WebElement> get() throws Exception {
		return this.driver.findElements(webDrivryBy);
	}
	
	/**
	 * Function finds the element and clear the input value and returns the
	 * WebElement
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return WebElements
	 * @throws Exception
	 */
	public List<WebElement> clearInputsValue() throws Exception {
		List<WebElement> element = this.get();
		for (WebElement _element : element) {
			_element.clear();
			if (!_element.getAttribute("value").equals("")) {
				throw new Exception("Input value is not cleared");
			}
		}
		return element;
	}
	
	/**
	 * Function finds the element and clear the input value and returns the
	 * WebElement
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public WebElement clearInputValue() throws Exception {
		WebElement element = this.getOne();
		element.clear();
		if (!element.getAttribute("value").equals("")) {
			throw new Exception("Input value is not cleared");
		}
		return element;
	}
	
	/**
	 * Refreshes the page 
	 * @throws Exception 
	 */
	public void pageRefresh() throws Exception {
		this.driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
	}
	
	public void waitForPageToLoad() throws Exception {
		@SuppressWarnings("unused")
		boolean blnPageLoaded;
		do {
			blnPageLoaded = ((JavascriptExecutor) driver).executeScript(
					"return document.readyState").equals("complete");
		} while (blnPageLoaded = false);
	}

	/**
	 * Performs mouse over action
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void mouseOver()	throws Exception {
		WebElement element = this.getOne();
		Actions action = new Actions(this.driver);
		action.moveToElement(element).build().perform();
//		action.keyUp(Keys.ENTER);
	}

	/**
	 * Function to convert element of type WebElement to Select
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return Select
	 * @throws Exception
	 */
	public Select webElementToSelect() throws Exception {
		WebElement element = this.getOne();
		return new Select(element);
	}

	/**
	 * Double click action on web element
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void doubleClick()throws Exception {
		Actions actions = new Actions(this.driver);
		actions.doubleClick(this.getOne()).build().perform();
	}
	
	// Drag and Drop action
	public void dragAndDrop(WebElement target) throws Exception {
		WebElement source = this.getOne();
		Actions action = new Actions(this.driver);
		action.dragAndDrop(source, target).build().perform();
	}

	/**
	 * Verifies whether element present or not
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public boolean isElementPresent()throws Exception {
		boolean present = true;
		if(this.get().size() == 0){
			present = false;
		}
		return present;
	}
	
	/**
	 * Verifies whether element present or not
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public boolean isElementPresent(int count) throws Exception {
		driver.manage().timeouts().implicitlyWait(count, TimeUnit.SECONDS);
		boolean present = true;
		if (this.get().size() == 0) {
			present = false;
		}
		/*driver.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);*/
		return present;
	}
	
	public void scrollDownTillElement(WebElement element) throws Exception {
		//WebElement element = this.getOne();
		((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public int getXpathCount() throws Exception {
		return this.get().size();
	}
	
	public int getCssCount() throws Exception {
		return this.get().size();
	}
	
	public void clickEnter()	throws Exception {
		Actions action = new Actions(this.driver);
		action.keyUp(Keys.ENTER);
	}
	
	public void clickUjse() throws Exception {
		WebElement element = this.getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].click();", element);
	}
	
	public void sendkeysUJSE(String text) throws Exception {
		WebElement element = this.getOne();
		element.clear();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+text+"';", element);
	}
}


