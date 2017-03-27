package requirement;

import java.util.ArrayList;
import java.util.List;
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
	@Test
	public void CreateCoveragePeriod() throws Exception{
		LoginPage login = new LoginPage(this.driver);
		HomePage home = new HomePage(this.driver);
		ExistingClientsPage existingclients = new ExistingClientsPage(this.driver); 
		EmployerPage employer = new EmployerPage(this.driver);
		PlanDesignPage plandesign = new PlanDesignPage(this.driver);
		ExistingClientsData existingClientsData = new ExistingClientsData();
		PlanDesignData planDesignData = new PlanDesignData();
		
		login.loginAsAdmin(Configuration.URL,LoginData.USERNAME,LoginData.PASSWORD);
		home.clickAddNewExistingClient();
		existingclients.createAndOpenEmployer(existingClientsData.EMPLOYER);
		employer.createCoveragePeriod();
		List<String[]> plandetails = new ArrayList<String[]>();
		String[] str = {PlanDesignData.TIER, "deductible",PlanDesignData.DEDUCTIBLE};
		String[] str1 = {PlanDesignData.TIER, "eeCoinsurance",PlanDesignData.CARRIER_COINS};
		String[] str2 = {PlanDesignData.TIER, "maxOutOfPocket",PlanDesignData.MAXOOP};
		String[] str3 = {PlanDesignData.TIER1, "deductible",PlanDesignData.DEDUCTIBLE1};
		String[] str4 = {PlanDesignData.TIER1, "maxOutOfPocket",PlanDesignData.MAXOOP1};
		String[] str5= {PlanDesignData.TIER2, "deductible",PlanDesignData.DEDUCTIBLE2};
		String[] str6= {PlanDesignData.TIER2, "maxOutOfPocket",PlanDesignData.MAXOOP2};		
		plandetails.add(str);
		plandetails.add(str1);
		plandetails.add(str2);
		plandetails.add(str3);
		plandetails.add(str4);
		plandetails.add(str5);
		plandetails.add(str6);
		plandesign.createCommunityRatedPlanDesign(planDesignData.PLANNAME, plandetails);
		plandesign.verifyPlan(planDesignData.PLANNAME);
	}
	
}
