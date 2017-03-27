package page;

import java.util.List;

import locators.PlanDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.helper.WaitForElement;
import qaframework.helper.WaitTimeConstants;
import qaframework.pageObject.PageObject;
import  static org.testng.Assert.assertTrue;
public class PlanDesignPage extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement waitForElement;
	
	public PlanDesignPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public PlanDesignPage clickOnPlanDesignTab()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.PLANDESIGNTAB)));
		waitForElement.waitForElements(PlanDesign.PLANDESIGNTAB, "xpath");
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").getOne().isDisplayed();
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").isElementPresent();
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").clickUsingJSE();
		return this;
	}
	
	public PlanDesignPage clickOnAddPlanDesign()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.ADDPLANDESIGN)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PlanDesign.ADDPLANDESIGN)));
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").getOne().isDisplayed();
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").isElementPresent();
		waitForElement.waitForElements(PlanDesign.ADDPLANDESIGN, "xpath");
		this.page.element(PlanDesign.ADDPLANDESIGN, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnAddNew()throws Exception{
		waitForElement.waitForElements(PlanDesign.ADDNEW, "xpath");
		this.page.element(PlanDesign.ADDNEW, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage enterPlanName(String planname)throws Exception{
		waitForElement.waitForElements(PlanDesign.PLANNAME, "xpath");
		this.page.element(PlanDesign.PLANNAME, "xpath").getOne().click();
		this.page.element(PlanDesign.PLANNAME, "xpath").clearInputValue().sendKeys(planname);
		return this;
	}
	
	public PlanDesignPage clickOnTraditional()throws Exception{
		waitForElement.waitForElements(PlanDesign.TRADITIONAL, "xpath");
		this.page.element(PlanDesign.TRADITIONAL, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage selectCarrier()throws Exception{
		waitForElement.waitForElements(PlanDesign.SELECTCARRIER, "xpath");
		this.page.element(PlanDesign.SELECTCARRIER, "xpath").getOne().click();
		waitForElement.waitForElements(PlanDesign.HUMANACARRIER, "xpath");
		this.page.element(PlanDesign.HUMANACARRIER, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage enterPlanDetails(String tier, String value, String rupees)throws Exception{
		String planDetailes = PlanDesign.TDTEXT+tier+PlanDesign.FOLLOWINGSIBLING+value+PlanDesign.CLOSEBRACKET;
		waitForElement.waitForElements(planDetailes, "xpath");
		this.page.element(planDetailes, "xpath").getOne().click();
		this.page.element(planDetailes, "xpath").getOne().sendKeys(rupees);
		return this;
	}
	
	public PlanDesignPage clickOnNextCreate()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.CREATE)));
		waitForElement.waitForElements(PlanDesign.CREATE, "xpath");
		this.page.element(PlanDesign.CREATE, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnNextRxPlan()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.NEXTRXPLAN)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PlanDesign.NEXTRXPLAN)));
		waitForElement.waitForElements(PlanDesign.NEXTRXPLAN, "xpath");
		this.page.element(PlanDesign.NEXTRXPLAN, "xpath").getOne().isDisplayed();
		this.page.element(PlanDesign.NEXTRXPLAN, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnNextPremium()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.NEXTPREMIUM)));
		waitForElement.waitForElements(PlanDesign.NEXTPREMIUM, "xpath");
		this.page.element(PlanDesign.NEXTPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnCommunityRatedPremium()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.COMMUNITYRATEDPREMIUM)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PlanDesign.COMMUNITYRATEDPREMIUM)));
		waitForElement.waitForElements(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath");
		this.page.element(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnApply()throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesign.APPLY)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PlanDesign.APPLY)));
		waitForElement.waitForElements(PlanDesign.APPLY, "xpath");
		this.page.element(PlanDesign.APPLY, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage addPlanDetails(List<String[]> plans) throws Exception{
		for(int i=0;i<plans.size();i++){
			 String[] value = plans.get(i);
			  enterPlanDetails(value[0],value[1],value[2]);
		}
		return this;	
	}
	
	public PlanDesignPage createCommunityRatedPlanDesign(String planname,List<String[]> plans)throws Exception{
		clickOnPlanDesignTab();
		clickOnAddPlanDesign();
		clickOnAddNew();
		enterPlanName(planname);
		clickOnTraditional();
		selectCarrier();
		addPlanDetails(plans);
		clickOnNextCreate();
		clickOnNextRxPlan();
		clickOnNextPremium();
		clickOnCommunityRatedPremium();
		clickOnApply();
		return this; 	
	}
	
	public PlanDesignPage verifyPlan(String plan){
		String PlanDesignName = PlanDesign.DIV_CONTAINS+plan+PlanDesign.CLOSEBRACKET;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesignName)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PlanDesignName)));
		assertTrue((driver.findElement(By.xpath(PlanDesignName))).isDisplayed());
		return this;
	}
}