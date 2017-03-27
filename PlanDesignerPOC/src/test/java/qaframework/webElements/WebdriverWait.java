package qaframework.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitTimeConstants;

public class WebdriverWait {
	
	public By webDriverBy;
	WebDriver driver;

	public WebdriverWait(ElementList elementList, By by) {
		this.driver = elementList.driver;
		this.webDriverBy = by;
	}

	public boolean waitForInvisibilityOfElement(){
		boolean condition = true;
		try{
			WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_SMALL);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(this.webDriverBy));
		}catch(Exception e){
			condition = false;
		}
		
		return condition;
	}
	
	public boolean waitForElementEnable(){
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.COUNT);
		wait.until(ExpectedConditions.elementToBeClickable(this.webDriverBy));
		return false;
	}
	
	public boolean waitForVisibilityOfElement(){
		boolean condition = true;
		try{
			WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.COUNT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(this.webDriverBy));
		}catch(Exception e){
			condition = false;
		}
		
		return condition;
	}
	
}



