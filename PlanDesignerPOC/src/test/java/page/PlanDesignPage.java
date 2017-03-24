package page;

import java.util.List;

import helper.WaitForElement;
import locators.PlanDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	}
	
	public PlanDesignPage clickOnAddPlanDesign()throws Exception{
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
	
	public PlanDesignPage enterPlanDetails(String tier, String value, String rs)throws Exception{
		String str = "//td[text()='"+tier+"']/following-sibling::td/input[@name='"+value+"']";
		waitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		this.page.element(str, "xpath").getOne().sendKeys(rs);
		
/*		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
		driver.findElement(By.xpath(str)).click();
		driver.findElement(By.xpath(str)).sendKeys(rs);*/
		return this;
	}
	
	public PlanDesignPage clickOnNextRxPlan()throws Exception{
		waitForElement.waitForElements(PlanDesign.NEXTRXPLAN, "xpath");
		this.page.element(PlanDesign.NEXTRXPLAN, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnNextPremium()throws Exception{
		waitForElement.waitForElements(PlanDesign.NEXTPREMIUM, "xpath");
		this.page.element(PlanDesign.NEXTPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnCommunityRatedPremium()throws Exception{
		waitForElement.waitForElements(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath");
		this.page.element(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickOnApply()throws Exception{
		waitForElement.waitForElements(PlanDesign.APPLY, "xpath");
		this.page.element(PlanDesign.APPLY, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage createCommunityRatedPlanDesign(String planname,List<String[]> str)throws Exception{
		clickOnAddPlanDesign();
		clickOnAddNew();
		enterPlanName(planname);
		clickOnTraditional();
		selectCarrier();
		for(int i=0;i<str.size();i++){
		  String[] value = str.toArray(new String[i]);
		  enterPlanDetails(value[0],value[1],value[2]);
		}
		clickOnNextRxPlan();
		clickOnNextPremium();
		clickOnCommunityRatedPremium();
		clickOnApply();
		return this; 	
	}
	
	public PlanDesignPage verifyPlan(String plan){
		String str = "//div[contains(text(),'"+plan+"')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
		assertTrue((driver.findElement(By.xpath(str))).isDisplayed());
		return this;
	}

}
