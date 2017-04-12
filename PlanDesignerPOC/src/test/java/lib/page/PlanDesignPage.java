package lib.page;

import java.util.List;

import lib.data.PlanDesignData;
import lib.locators.CoveragePeriodSetup;
import lib.locators.PlanDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	public PlanDesignPage navigateToPlanDesignTab()throws Exception{
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").waitForPageToLoad();
		waitForElement.waitForElements(PlanDesign.PLANDESIGNTAB, "xpath");
		this.page.element_wait(PlanDesign.PLANDESIGNTAB, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.PLANDESIGNTAB, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.PLANDESIGNTAB, "xpath").clickUsingJSE();
		return this;
	}
	
	public PlanDesignPage clickAddPlanDesign()throws Exception{
		waitForElement.waitForElements(PlanDesign.ADDPLANDESIGN, "xpath");
		this.page.element_wait(PlanDesign.ADDPLANDESIGN, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.ADDPLANDESIGN, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.ADDPLANDESIGN, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickAddNew()throws Exception{
		waitForElement.waitForElements(PlanDesign.ADDNEW, "xpath");
		this.page.element_wait(PlanDesign.ADDNEW, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.ADDNEW, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage enterPlanName(String planname)throws Exception{
		waitForElement.waitForElements(PlanDesign.PLANNAME, "xpath");
		this.page.element(PlanDesign.PLANNAME, "xpath").waitForPageToLoad();
		this.page.element_wait(PlanDesign.PLANNAME, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.PLANNAME, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.PLANNAME, "xpath").clearInputValue().sendKeys(planname);
		return this;
	}
	
	public PlanDesignPage clickOnTraditional()throws Exception{
		waitForElement.waitForElements(PlanDesign.TRADITIONAL, "xpath");
		this.page.element(PlanDesign.TRADITIONAL, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage selectCarrier()throws Exception{
		String carrierPlan = PlanDesign.DIV_CONTAINS+PlanDesignData.CARRIERPLANHUMANA+PlanDesign.CLOSEBRACKET;
		waitForElement.waitForElements(PlanDesign.SELECTCARRIER, "xpath");
		this.page.element(PlanDesign.SELECTCARRIER, "xpath").getOne().click();
		waitForElement.waitForElements(carrierPlan, "xpath");
		waitForElement.waitForElement(carrierPlan, "xpath");
		this.page.element(carrierPlan, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage enterPlanDetails(String tier, String value, String rupees)throws Exception{
		String planDetailes = PlanDesign.TDTEXT+tier+PlanDesign.FOLLOWINGSIBLING+value+PlanDesign.SQUREBRACKET;
		waitForElement.waitForElements(planDetailes, "xpath");
		this.page.element(planDetailes, "xpath").getOne().click();
		this.page.element(planDetailes, "xpath").getOne().sendKeys(rupees);
		return this;
	}
	
	public PlanDesignPage clickNextCreate()throws Exception{
		waitForElement.waitForElements(PlanDesign.CREATE, "xpath");
		this.page.element_wait(PlanDesign.CREATE, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.CREATE, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickNextRxPlan()throws Exception{
		waitForElement.waitForElements(PlanDesign.NEXTRXPLAN, "xpath");
		this.page.element_wait(PlanDesign.NEXTRXPLAN, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.NEXTRXPLAN, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.NEXTRXPLAN, "xpath").clickUsingJSE();
		return this;
	}
	
	public PlanDesignPage clickNextPremium()throws Exception{
		waitForElement.waitForElement(PlanDesign.NEXTPREMIUM, "xpath");
		this.page.element_wait(PlanDesign.NEXTPREMIUM, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.NEXTPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickCommunityRatedPremium()throws Exception{
		waitForElement.waitForElement(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath");
		this.page.element(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").waitForPageToLoad();
		this.page.element_wait(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.COMMUNITYRATEDPREMIUM, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickApply()throws Exception{
		waitForElement.waitForElement(PlanDesign.APPLY, "xpath");
		waitForElement.waitForElements(PlanDesign.APPLY, "xpath");
		this.page.element(PlanDesign.APPLY, "xpath").waitForPageToLoad();
		this.page.element_wait(PlanDesign.APPLY, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.APPLY, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.APPLY, "xpath").clickUsingJSE();
		return this;
	}
	
	public PlanDesignPage clickApplySecond()throws Exception{
		waitForElement.waitForElements(PlanDesign.APPLY1, "xpath");
		this.page.element(PlanDesign.APPLY1, "xpath").waitForPageToLoad();
		this.page.element_wait(PlanDesign.APPLY1, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.APPLY1, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.APPLY1, "xpath").clickUsingJSE();
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
		navigateToPlanDesignTab();
		clickAddPlanDesign();
		clickAddNew();
		enterPlanName(planname);
		clickOnTraditional();
		selectCarrier();
		addPlanDetails(plans);
		clickNextCreate();
		clickNextRxPlan();
		clickNextPremium();
		clickCommunityRatedPremium();
		clickApply();
		return this; 	
	}
	
	public PlanDesignPage verifyPlanIsDisplayed(String plan) throws Exception{
		String PlanDesignName = PlanDesign.DIV_CONTAINS+plan+PlanDesign.CLOSEBRACKET;
		waitForElement.waitForElements(PlanDesignName, "xpath");
		this.page.element_wait(PlanDesignName, "xpath").waitForVisibilityOfElement();
		assertTrue((driver.findElement(By.xpath(PlanDesignName))).isDisplayed());
		System.out.println("plan is verified");
		return this;
	}
	
	public PlanDesignPage clickSkip()throws Exception{
		waitForElement.waitForElement(PlanDesign.SKIP, "xpath");
		this.page.element_wait(PlanDesign.SKIP, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.SKIP, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.SKIP, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickQualifiedHDHP()throws Exception{
		waitForElement.waitForElements(PlanDesign.QUALIFIEDHDHP, "xpath");
		this.page.element(PlanDesign.QUALIFIEDHDHP, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickNextPremiums()throws Exception{
		waitForElement.waitForElement(PlanDesign.NEXTPREMIUMS, "xpath");
		waitForElement.waitForElements(PlanDesign.NEXTPREMIUMS, "xpath");
		this.page.element(PlanDesign.NEXTPREMIUMS, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickCompositePremium()throws Exception{
		waitForElement.waitForElement(PlanDesign.COMPOSITEPREMIUM, "xpath");
		waitForElement.waitForElements(PlanDesign.COMPOSITEPREMIUM, "xpath");
		this.page.element_wait(PlanDesign.COMPOSITEPREMIUM, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.COMPOSITEPREMIUM, "xpath").mouseOver();
		this.page.element(PlanDesign.COMPOSITEPREMIUM, "xpath").clickUsingJSE();
		return this;
	}
	
	public PlanDesignPage enterPremium(String enrollment,String premium)throws Exception{
		String premiums = CoveragePeriodSetup.TDCONTAINSTEXT+enrollment+PlanDesign.FOLLOWINGSIBLINGINPUT;
		waitForElement.waitForElements(premiums, "xpath");
		this.page.element(premiums, "xpath").clearInputValue().sendKeys(premium);
		return this;
	}
	
	public PlanDesignPage addPremiums(List<String[]> plans) throws Exception{
		for(int i=0;i<plans.size();i++){
			 String[] value = plans.get(i);
			 enterPremium(value[0],value[1]);
		}
		return this;	
	}
	
	public PlanDesignPage clickNextEnrollement()throws Exception{
		waitForElement.waitForElement(PlanDesign.NEXTENROLLEMENT, "xpath");
		waitForElement.waitForElements(PlanDesign.NEXTENROLLEMENT, "xpath");
		this.page.element_wait(PlanDesign.NEXTENROLLEMENT, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.NEXTENROLLEMENT, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage clickFinish()throws Exception{
		waitForElement.waitForElement(PlanDesign.FINISH, "xpath");
		waitForElement.waitForElements(PlanDesign.FINISH, "xpath");
		this.page.element_wait(PlanDesign.FINISH, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.FINISH, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage createCompositePremiumPlan(String planname,List<String[]> plans,List<String[]> premium) throws Exception{
		clickAddPlanDesign();
		clickSkip();
		clickAddNew();
		enterPlanName(planname);
		clickOnTraditional();
		selectCarrier();
		addPlanDetails(plans);
		clickNextCreate();
		clickNextRxPlan();
		clickNextPremiums();
		clickCompositePremium();
		addPremiums(premium);
		clickApplySecond();
		clickNextEnrollement();
		clickFinish();
		return this;
	}
	
	public PlanDesignPage navigateToPremiumShare()throws Exception{
		waitForElement.waitForElement(PlanDesign.PREMIUMSHARE, "xpath");
		waitForElement.waitForElements(PlanDesign.PREMIUMSHARE, "xpath");
		this.page.element(PlanDesign.PREMIUMSHARE, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage enterPremiumSharePercent(String premiumPercent)throws Exception{
		waitForElement.waitForElements(PlanDesign.PREMIUMSHAREPERCENT, "xpath");
		this.page.element_wait(PlanDesign.PREMIUMSHAREPERCENT, "xpath").waitForVisibilityOfElement();
		this.page.element(PlanDesign.PREMIUMSHAREPERCENT, "xpath").clearInputValue().sendKeys(premiumPercent);
		return this;
	}
	
	public PlanDesignPage applyToAllEnrollementTypes()throws Exception{
		waitForElement.waitForElements(PlanDesign.APPLYALLENROLLTYPE, "xpath");
		this.page.element_wait(PlanDesign.APPLYALLENROLLTYPE, "xpath").waitForVisibilityOfElement();
		this.page.element_wait(PlanDesign.APPLYALLENROLLTYPE, "xpath").waitForElementEnable();
		this.page.element(PlanDesign.APPLYALLENROLLTYPE, "xpath").getOne().click();
		return this;
	}
	
	public PlanDesignPage verifyPremiumSharesOfEmployeeAndEmployer(String enrollmentType)throws Exception{
		String EE = "//td[text()='"+enrollmentType+"']/following-sibling::td[2]//span[1]";
		String ER = "//td[text()='"+enrollmentType+"']/following-sibling::td[5]//span[1]";
		waitForElement.waitForElement(EE, "xpath");
		waitForElement.waitForElements(EE, "xpath");
		this.page.element_wait(EE, "xpath").waitForVisibilityOfElement();
		Assert.assertEquals((this.page.element(EE, "xpath").getOne().getText()), (this.page.element(ER, "xpath").getOne().getText()));
		return this;
	}
}