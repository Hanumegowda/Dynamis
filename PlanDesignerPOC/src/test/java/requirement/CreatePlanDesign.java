package requirement;

import org.testng.annotations.Test;

import page.EmployerPage;
import page.ExistingClientsPage;
import page.HomePage;
import page.LoginPage;
import page.PlanDesignPage;
import configuration.Configuration;
import data.ExistingClientsData;
import data.LoginData;
import data.PlanDesignData;

public class CreatePlanDesign extends Configuration{
	
	public CreatePlanDesign() throws Exception{
		super();
	}
	
	@Test(groups = "HappyDay", description = "Verify if user can create Coverage Period")
	public void CreateCoveragePeriod() throws Exception{
		
		LoginPage login = new LoginPage(this.driver);
		HomePage home = new HomePage(this.driver);
		ExistingClientsPage existingclients = new ExistingClientsPage(this.driver); 
		EmployerPage employer = new EmployerPage(this.driver);
		ExistingClientsData existingClientsData = new ExistingClientsData();
		PlanDesignData planDesignData = new PlanDesignData();
		
		login.loginAsAdmin(Configuration.URL,LoginData.USERNAME,LoginData.PASSWORD);
		home.clickAddNewExistingClient();
		existingclients.createAndOpenEmployer(existingClientsData.employer);
		employer.createCoveragePeriod(planDesignData.coveragePeriodName);
	}
	
	@Test(dependsOnMethods={"CreateCoveragePeriod"}, groups = "HappyDay", description = "Verify if user can add Plan Design for a Coverage Period")
	public void CreatePlanDesignForCoveragePeriod() throws Exception{
		
		PlanDesignPage plandesign = new PlanDesignPage(this.driver);
		PlanDesignData planDesignData = new PlanDesignData();
		
		plandesign.createCommunityRatedPlanDesign(planDesignData.planName, planDesignData.planDetails);
		plandesign.verifyPlan(planDesignData.planName);
	}
}