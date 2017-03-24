package requirement;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import page.EmployerPage;
import page.ExistingClientsPage;
import page.HomePage;
import page.LoginPage;
import page.PlanDesignPage;
import module.Module;
import configuration.Configuration;
import data.ExistingClientsData;
import data.LoginData;
import data.PlanDesignData;

public class CoveragePeriod extends Configuration{
	public CoveragePeriod() throws Exception{
		super();
	}
	@Test
	public void CreateCoveragePeriod() throws Exception{
		LoginPage login = new LoginPage(this.driver);
		HomePage home = new HomePage(this.driver);
		Module module = new Module(super.driver, super.wait);
		ExistingClientsPage existingclients = new ExistingClientsPage(this.driver); 
		EmployerPage employer = new EmployerPage(this.driver);
		PlanDesignPage plandesign = new PlanDesignPage(this.driver);
		ExistingClientsData existingClientsData = new ExistingClientsData();
		
		login.loginAsAdmin(LoginData.URL,LoginData.USERNAME,LoginData.PASSWORD);
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
		plandesign.createCommunityRatedPlanDesign(PlanDesignData.PLANNAME, plandetails);
		
		/*plandesign
				.clickOnAddPlanDesign()
				.clickOnAddNew()
				.enterPlanName(
						PlanDesignData.PLANNAME);
		Thread.sleep(3000);
				plandesign.selectCarrier();
				Thread.sleep(3000);
				plandesign.clickOnTraditional();
				Thread.sleep(3000);
				plandesign.enterPlanDetails(PlanDesignData.TIER, "deductible",
						PlanDesignData.DEDUCTIBLE)
				.enterPlanDetails(PlanDesignData.TIER, "eeCoinsurance",
						PlanDesignData.CARRIER_COINS)
				.enterPlanDetails(PlanDesignData.TIER, "maxOutOfPocket",
						PlanDesignData.MAXOOP)
				.enterPlanDetails(PlanDesignData.TIER1, "deductible",
						PlanDesignData.DEDUCTIBLE1)
				.enterPlanDetails(PlanDesignData.TIER1, "maxOutOfPocket",
						PlanDesignData.MAXOOP1)
				.enterPlanDetails(PlanDesignData.TIER2, "deductible",
						PlanDesignData.DEDUCTIBLE2)
				.enterPlanDetails(PlanDesignData.TIER2, "maxOutOfPocket",
						PlanDesignData.MAXOOP2);
				Thread.sleep(3000);
		employer.clickOnCreate();
		Thread.sleep(3000);
		plandesign.clickOnNextRxPlan();
		Thread.sleep(3000);
		plandesign.clickOnNextPremium();
		Thread.sleep(3000);
		plandesign.clickOnCommunityRatedPremium();
		Thread.sleep(3000);
		Thread.sleep(10000);
		plandesign.clickOnApply();
		Thread.sleep(3000);*/
		
		
		
		plandesign.verifyPlan(PlanDesignData.PLANNAME + System.currentTimeMillis());

		module.clickAccountSettings().clickLogout();
	}
	@Test
	public void a() throws Exception{
		List<String[]> l = new ArrayList<String[]>();
		String[] s = {"aa","bb","cc"};
		String[] s1 = {"aaa","bbb","ccc"};
		l.add(s);
		l.add(s1);
		System.out.println(l.size());
		String[] n3 = l.toArray(new String[l.size()]);
		String[] n = l.toArray(new String[0]);
		String[] n1 = l.toArray(new String[0]);
		System.out.println(n[0]);
		System.out.println(n[2]);
		System.out.println(n[1]);
		System.out.println(n1[0]);
		System.out.println(n1[2]);
		System.out.println(n1[1]);
		
		
	}

}
