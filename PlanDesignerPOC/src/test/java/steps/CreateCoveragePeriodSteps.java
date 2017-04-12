package steps;

import java.util.List;

import lib.data.CoveragePeriodSetupData;
import lib.data.PlanDesignData;
import lib.navigation.SidebarNavigations;
import lib.page.CoveragePeriodSetupPage;
import lib.page.EmployerPage;
import lib.page.ExistingClientsPage;
import lib.page.HomePage;
import lib.page.LoginPage;
import lib.page.PlanDesignPage;

import org.openqa.selenium.WebDriver;

import qaframework.pageObject.PageObject;

public class CreateCoveragePeriodSteps extends PageObject {

	public CreateCoveragePeriodSteps(WebDriver _driver) throws Exception {
		super(_driver);		
	}
	
		PlanDesignData planDesignData = new PlanDesignData();
		PlanDesignPage plandesign = new PlanDesignPage(this.driver);
		ExistingClientsPage existingclients = new ExistingClientsPage(this.driver); 
		EmployerPage employer = new EmployerPage(this.driver);	
		LoginPage login = new LoginPage(this.driver);
		HomePage home = new HomePage(this.driver);
		CoveragePeriodSetupPage coveragePeriodSetup = new CoveragePeriodSetupPage(this.driver);
	    SidebarNavigations sidebarNavigation=new SidebarNavigations(this.driver);
    
	public CreateCoveragePeriodSteps CreateCoveragePeriod(String employeeName) throws Exception{	
		home.addNewExistingClient();
		existingclients.createAndOpenEmployer(employeeName);
		employer.createCoveragePeriod(planDesignData.coveragePeriodName);
		return this;
	}

	public CreateCoveragePeriodSteps searchSelectExistingClient(String employeeName)throws Exception{
		home.navigateToHome()
			.navigateToExistingClient()
			.searchAndSelectExistingClient(employeeName);
		return this;
	}
	
	public CreateCoveragePeriodSteps selectEnrollmentType(String coveragePeriodSetupData)throws Exception{
		sidebarNavigation.navigateCoveragePeriodSetup();
		coveragePeriodSetup.navigateToEnrollmentTypesAndClasses()
						   .selectEnrollementTypes(CoveragePeriodSetupData.EMPLOYEE_SPOUSE)
						   .selectEnrollementTypes(CoveragePeriodSetupData.EMPLOYEE_1CH);
		return this;
	}
	
	public CreateCoveragePeriodSteps createCompositePremium(String planName,List<String[]> planDetails,List<String[]>premiums,String premiumSharePercent) throws Exception{
			sidebarNavigation.navigateToPlanDesigns();
			plandesign.createCompositePremiumPlan(planName,planDetails,premiums)
					  .navigateToPremiumShare()
					  .enterPremiumSharePercent(premiumSharePercent)
					  .applyToAllEnrollementTypes();	
			return this;
		}
	
		public CreateCoveragePeriodSteps verifyPremiumShares(String premiunShares)throws Exception{
				plandesign .verifyPremiumSharesOfEmployeeAndEmployer(premiunShares);	
				return this;
		}
}
