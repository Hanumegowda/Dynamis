package data;

import java.util.ArrayList;
import java.util.List;

public class PlanDesignData {
	public  static final String TIER          = "Employee",
                                TIER1         = "Employee + 1",
                                TIER2         = "Employee + 2 or more",
                                DEDUCTIBLE    = "1000",
                                DEDUCTIBLE1   = "2000",
                                DEDUCTIBLE2   = "3000",
                                CARRIER_COINS = "80",
                                MAXOOP        = "2000",
                                MAXOOP1       = "3000",
                            	MAXOOP2       = "4000";
	
	public List<String[]> planDetails = new ArrayList<String[]>();
	String[] deductible 	= {TIER, "deductible", DEDUCTIBLE};
	String[] carrierCoins 	= {TIER, "eeCoinsurance", CARRIER_COINS};
	String[] maxOop 		= {TIER, "maxOutOfPocket", MAXOOP};
	String[] deductible1 	= {TIER1, "deductible", DEDUCTIBLE1};
	String[] maxOop1 		= {TIER1, "maxOutOfPocket", MAXOOP1};
	String[] deductible2	= {TIER2, "deductible", DEDUCTIBLE2};
	String[] maxOop2		= {TIER2, "maxOutOfPocket", MAXOOP2};	
	
	public String   planName             = "AutoPlan"+System.currentTimeMillis(),
			        coveragePeriodName   = "CoveragePeriod"+System.currentTimeMillis();
	
	public List<String[]> planDesignDetais(){
		planDetails.add(deductible);
		planDetails.add(carrierCoins);
		planDetails.add(maxOop);
		planDetails.add(deductible1);
		planDetails.add(maxOop1);
		planDetails.add(deductible2);
		planDetails.add(maxOop2);
		return planDetails;
	}
}