package steps;

import java.util.List;

import lib.data.PlanDesignData;
import lib.page.PlanDesignPage;

import org.openqa.selenium.WebDriver;

import qaframework.pageObject.PageObject;

public class CreatePlanDesignSteps extends PageObject{

	public CreatePlanDesignSteps(WebDriver _driver) throws Exception {
		super(_driver);
	}
	PlanDesignPage plandesign = new PlanDesignPage(this.driver);
	PlanDesignData planDesignData = new PlanDesignData();
	
	public void CreatePlanDesignForCoveragePeriod(String planName,List<String[]>  planDesignDetails) throws Exception{	
		plandesign.createCommunityRatedPlanDesign(planName, planDesignDetails);
		plandesign.verifyPlanIsDisplayed(planName);
	}
}
