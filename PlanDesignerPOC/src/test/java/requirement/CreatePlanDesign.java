package requirement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib.data.CoveragePeriodSetupData;
import lib.data.ExistingClientsData;
import lib.data.LoginData;
import lib.data.PlanDesignData;
import lib.page.LoginPage;
import steps.CreateCoveragePeriodSteps;
import steps.CreatePlanDesignSteps;
import configuration.Configuration;

public class CreatePlanDesign extends Configuration {

	public CreatePlanDesign() throws Exception {
		super();
	}
	
	LoginPage when;
	CreateCoveragePeriodSteps then ;
	CreateCoveragePeriodSteps given ;
	ExistingClientsData existingClientsData = new ExistingClientsData();;
	PlanDesignData planDesignData = new PlanDesignData();
	
	@Test
	public void createCoveragePeriod() throws Exception {
		when = new LoginPage(this.driver);
		then = new CreateCoveragePeriodSteps(this.driver);
	
		when.login(Configuration.URL, LoginData.USERNAME, LoginData.PASSWORD);
		then.CreateCoveragePeriod(existingClientsData.employer);
	}
	
	@Test(dependsOnMethods="createCoveragePeriod", groups = "HappyDay",description = "Verify if user can add Plan Design for a Coverage Period")
	public void CreatePlanDesignForCoveragePeriod() throws Exception{	
		CreatePlanDesignSteps then=new CreatePlanDesignSteps(driver);

		then.CreatePlanDesignForCoveragePeriod(planDesignData.planName, planDesignData.planDesignDetails());
	}
	
	@Test(dependsOnMethods="CreatePlanDesignForCoveragePeriod", groups = "HappyDay",description = "Update the enrollement and create qualified HDHP plan in it")
	public void updateEnrollmentAndCreateQualified()throws Exception{
		given = new CreateCoveragePeriodSteps(this.driver);
		then = new CreateCoveragePeriodSteps(this.driver);
		
		given.searchSelectExistingClient(existingClientsData.employer);
			then.selectEnrollmentType(CoveragePeriodSetupData.EMPLOYEE_SPOUSE)
			.createCompositePremium(planDesignData.planName1,planDesignData.planDesignDetails(),planDesignData.premiums(),PlanDesignData.PREMIUMSHARE50PERCENT);		
	}
	
	@DataProvider
	public Object[][] premiumShares(){
		return new Object[][]{{PlanDesignData.EMPLOYEE_ONLY},{PlanDesignData.EMPLOYEE_SPOUSE},{PlanDesignData.EMPLOYEE_1CH},{PlanDesignData.FAMILY}};
	}
	
	@Test(dependsOnMethods="updateEnrollmentAndCreateQualified", groups = "HappyDay",dataProvider="premiumShares")
	public void verifyPremiums(String premiumShares)throws Exception{
		then = new CreateCoveragePeriodSteps(this.driver);
		
		then.verifyPremiumShares(premiumShares);			
	}
}
