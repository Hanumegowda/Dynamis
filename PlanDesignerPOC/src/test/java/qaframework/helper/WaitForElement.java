package qaframework.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WaitForElement {

	public By webDrivryBy;
	WebElement element;
	WebDriver driver;
	
	public WaitForElement(WebDriver driver2) {
		this.driver = driver2;
	}
	
	public WebElement getElement(String elementId, String locatorStrategy)
			throws Exception {
		WebElement element = null;
		
		/*switch (locatorStrategy) {
		case "xpath":
			element = driver.findElement(By.xpath(elementId));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(elementId));
			break;
		case "id":
			element = driver.findElement(By.id(elementId));
			break;
		case "name":
			element = driver.findElement(By.name(elementId));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(elementId));
			break;
		case "linktext":
			element = driver.findElement(By.linkText(elementId));
			break;
		}*/
		return element;
	}
	
	public void clickElement(String elementID,String locator)throws Exception{
		element=getElement(elementID, locator);
		element.isDisplayed();
		element.click();
	}
	
	public void enterData(String elementID,String locator,String value)throws Exception{
		element=getElement(elementID,locator);
		element.clear();
		element.sendKeys(value);
		assertEquals(value, element.getAttribute("value"));
	}
	
	public void verifyText(String elementId, String locator, String text)
			throws Exception {
		element = getElement(elementId, locator);
		String strPresent = element.getText();
		assertEquals(text,strPresent);
	}

	public void verifyPageTitle(String title) throws Exception {
		String pagetitle = driver.getTitle();
		assertTrue(pagetitle.contains(title));
	}
	
	public void verifyValue(String elementId, String locator, String value)
			throws Exception {
		element = getElement(elementId, locator);
		String fieldValue = element.getAttribute("value");
		assertEquals(value, fieldValue);
	}
	
	public void selectValue(String elementID, String locator, String value)
			throws Exception {
		element = getElement(elementID, locator);
		new Select(element).selectByVisibleText(value);
		String selectedVal = new Select(element).getFirstSelectedOption()
				.getText();
		assertTrue(selectedVal.equals(value));
	}
	
	public void switchToWindow(String elementId, String locator, String title)
			throws Exception {
		String mainWindowHandle = driver.getWindowHandle();
		clickElement(elementId, locator);
		Thread.sleep(4000);
		waitForPageToLoad();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> ite = win.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		String Menu = driver.getTitle();
		assertEquals(title, Menu);
	}
	
	public void waitForElement(String elementId, String locator)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				element = getElement(elementId, locator);
				element.isSelected();
				intCnt++;
			} catch (Exception e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 3);
	}

	public void waitForPageToLoad() throws Exception {
		@SuppressWarnings("unused")
		boolean blnPageLoaded;
		do {
			blnPageLoaded = ((JavascriptExecutor) driver).executeScript(
					"return document.readyState").equals("complete");
		} while (blnPageLoaded = false);
	}
	
	public boolean isElementPresent(By by) throws InvocationTargetException{
		@SuppressWarnings("unused")
		int intCnt=0;
		boolean blnFound=false;
		try{				
			try {				
				driver.findElement(by);					
				blnFound =true;
				
			} catch (NoSuchElementException e) {				
				intCnt++;
				Thread.sleep(1000);			
				blnFound=false;
				
			} catch (StaleElementReferenceException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;
				
			} catch (InvalidElementStateException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;
			}
	
		}catch(Exception E){
			
		}
		return blnFound;
	}	
	
	public boolean isElementPresent(By by, int count)
			throws InvocationTargetException{
		driver.manage().timeouts().implicitlyWait(count, TimeUnit.SECONDS);
		@SuppressWarnings("unused")
		int intCnt=0;
		boolean blnFound=false;
		try{				
			try {				
				driver.findElement(by);					
				blnFound =true;
				
			} catch (NoSuchElementException e) {				
				intCnt++;
				Thread.sleep(1000);			
				blnFound=false;
				
			} catch (StaleElementReferenceException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;
				
			} catch (InvalidElementStateException e){
				intCnt++;
				Thread.sleep(1000);
				blnFound=false;
			}
			
			
		}catch(Exception E){
			
		}
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		return blnFound;
	}	
	
	public void waitForElement(String strElement) throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.xpath(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
			
		} while (intCnt < 2);
	}
	
	public void waitForLoading(int count) {
		int intCntr = 0;
		driver.manage().timeouts().implicitlyWait(count, TimeUnit.SECONDS);
		try {
			WebElement btn = driver.findElement((By
					.xpath("//div[@id='WaitMessage']")));
			while (intCntr <= 180) {
				try {
					btn.isEnabled();
					btn.isDisplayed();
					intCntr++;
					Thread.sleep(1000);
				} catch (Exception e) {
					waitForPageToLoad();
					Thread.sleep(3000);
					break;
				}
			}
		} catch (Exception e) {

		}
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
	}
	
	public void waitForLoading() {
		int intCntr = 0;
		try {
			WebElement btn = driver.findElement((By
					.xpath("//div[@id='WaitMessage']")));
			while (intCntr <= 180) {
				try {
					btn.isEnabled();
					btn.isDisplayed();
					intCntr++;
					Thread.sleep(1000);
				} catch (Exception e) {
					waitForPageToLoad();
					Thread.sleep(3000);
					break;
				}
			}
		} catch (Exception e) {

		}
	}
	public void waitForElementBycssSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.cssSelector(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	public void waitForText(String strElementID, String strText)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				assertTrue(driver.findElement(By.xpath(strElementID)).getText().contains(strText));
				break;
			} catch (AssertionError e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	public void waitForTextByCssSelector(String strElementID, String strText)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				assertTrue(driver.findElement(By.cssSelector(strElementID)).getText().contains(strText));
				break;
			} catch (AssertionError e) {
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	public void waitForElementByxpathSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.xpath(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}

	public void waitForElementByidSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.id(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(500);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(500);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(500);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(500);
			}
		} while (intCnt < 4);
	}
	
	public void waitForElementBynameSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.name(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	public void waitForElementBylinkTextSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.linkText(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	public void waitForElementByclassNameSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.className(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt < 4);
	}
	
	
	public void waitForElementBytagNameSelector(String strElement)
			throws Exception {
		int intCnt = 0;
		do {
			try {
				driver.findElement(By.tagName(strElement)).isDisplayed();
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				Thread.sleep(1000);
			}catch (StaleElementReferenceException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch (NoSuchElementException SE) {
				intCnt++;
				Thread.sleep(1000);
			}catch(Exception e){
				intCnt++;
				Thread.sleep(1000);
			}
		} while (intCnt <4);
	}
	
	public void waitForElements(String elementName, String locatorStrategy) throws Exception{
		if(locatorStrategy.equals("css")){
			this.waitForElementBycssSelector(elementName);
		}
		else if(locatorStrategy.equals("xpath")){
			this.waitForElementByxpathSelector(elementName);
		}
		else if(locatorStrategy.equals("id")){
			this.waitForElementByidSelector(elementName);
		}
		else if(locatorStrategy.equals("name")){
			this.waitForElementBynameSelector(elementName);
		}	
		else if(locatorStrategy.equals("linkText")){
			this.waitForElementBylinkTextSelector(elementName);
		}
		else if(locatorStrategy.equals("class")){
			this.waitForElementByclassNameSelector(elementName);
		}
		else if(locatorStrategy.equals("tagName")){
			this.waitForElementBytagNameSelector(elementName);
		}
	}
}
