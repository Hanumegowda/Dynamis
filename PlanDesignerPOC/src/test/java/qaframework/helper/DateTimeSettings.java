package qaframework.helper;

import com.thoughtworks.selenium.Selenium;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@SuppressWarnings("deprecation")
public class DateTimeSettings {

	/********************************************************************************
	 * Description	: This function is used to get the past day
	 * Date			: 25/03/2012
	 * Author		: QSG
	********************************************************************************/
	public String getPastDate(int intyear) {
		String DATE_FORMAT = "MM d yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		int yearval = 365 * intyear;
		c1.add(Calendar.DATE, -yearval);
		String strDOB = sdf.format(c1.getTime());
		return strDOB;
	}
	/********************************************************************************
	 * Description	: This function is used to get the current time
	 * Date			: 25/03/2012
	 * Author		: QSG
	********************************************************************************/
	public String timeNow(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());

	}
	
	/********************************************************************************
	 * Description	: This function is used to get the current date with date format
	 * Date			: 25/03/2012
	 * Author		: QSG
	********************************************************************************/
	public String getCurrentDate(Selenium selenium, String Dateformat) {
		String DATE_FORMAT = Dateformat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		String strCurrentDate = sdf.format(c1.getTime());
		return strCurrentDate;
	}
	
	/**************************************************************
	 * Description	: This function is used to get the current date
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getCurrentDate(String Dateformat) {
		String DATE_FORMAT = Dateformat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		String strCurrentDate = sdf.format(c1.getTime());
		return strCurrentDate;
	}
	
	/**************************************************************
	 * Description	: This function is used to get the past day
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getPastDay(int intDate,String strFormat) {
		String DATE_FORMAT = strFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		int yearval = intDate;
		c1.add(Calendar.DATE, -yearval);
		String strDOB = sdf.format(c1.getTime());
		return strDOB;
	}
		 
	/**************************************************************
	 * Description	: This function is used to get the future day
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getFutureDay(int intDate, String strFormat) {
		String DATE_FORMAT = strFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		int yearval = intDate;
		c1.add(Calendar.DATE, +yearval);
		String strDOB = sdf.format(c1.getTime());
		return strDOB;
	}
		
	/************************************************************
	 * Description	: This function is used to get the time stamp
	 * Date			: 25/03/2012
	 * Author		: QSG
	*************************************************************/
	public String GetTimeStamp(Selenium selenium) throws Exception {
		String strTimeStamp;
		// Obtain the current time as accurate as milliseconds and return it
		strTimeStamp = selenium
				.getEval("new Date().getFullYear() + new Date().getDate().toString() +  "
						+ "new Date().getDay() +  new Date().getHours() +  new Date().getMinutes() +  "
						+ "new Date().getSeconds() + new Date().getMilliseconds()");
		return strTimeStamp;
	}

	/****************************************************************
	 * Description	: This function is used to get the current month
	 * Date			: 25/03/2012
	 * Author		: QSG
	*****************************************************************/
	public String getMonth(String strMonth) {
		String[] monthName = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		String month = monthName[Integer.parseInt(strMonth) - 1];

		return month;
	}

	/***********************************************************************************
	 * Description	: This function is used to get the time difference beetween two time
	 * Date			: 25/03/2012
	 * Author		: QSG
	************************************************************************************/
	public int getTimeDiff1(String Time1, String Time2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		// Convert the user input into a date object
		Date time1 = sdf.parse(Time1);
		Date time2 = sdf.parse(Time2);

		// Get time values of the date objects
		long l1 = time1.getTime();
		long l2 = time2.getTime();
		double difference = (l1 - l2) / 1000; // Calculate the difference in
												// time (divide by 1000 as in
												// milliseconds)
		difference = (difference <= 0 ? 1 : difference); // If difference is
															// negative, make
															// positive

		int Timedifference = (int) difference;
		return Timedifference;
	}

 	/***********************************************************************************
	 * Description	: This function is used to round of the decimals upto two positions
	 * Date			: 25/03/2012
	 * Author		: QSG
	************************************************************************************/
	public double roundTwoDecimals(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
 
    /**************************************************************
	 * Description	: This function is used to get the future dates
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String FutureDate(int intAdd, String DateFormat) {
		String DATE_FORMAT = DateFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		// c1.set(2012, 0 , 26);
		// System.out.println("Date is : " + sdf.format(c1.getTime()));
		c1.add(Calendar.DATE, intAdd);
		String strNextDate = sdf.format(c1.getTime());
		return strNextDate;
	}
	
	/********************************************************************
	 * Description	: This function is used to add day to existing dates
	 * Date			: 25/03/2012
	 * Author		: QSG
	*********************************************************************/
	public String DaytoExistingDate(String strExistDate, int intdays,
			String strTimeFormat) throws ParseException {
		Date todayDate = new Date();
		DateFormat sdf = new SimpleDateFormat(strTimeFormat);
		String strDate = sdf.format(todayDate);
		String date = strExistDate;
		Date parsedDate = sdf.parse(date);
		System.out.println(strDate);
		System.out.println(parsedDate);
		Calendar now = Calendar.getInstance();
		now.setTime(parsedDate);
		now.add(Calendar.DATE, 1);
		date = sdf.format(now.getTime());
		System.out.println(date);
		return date;
	}
	
	/************************************************************
	 * Description	: This function is used to compare two dates
	 * Date			: 25/03/2012
	 * Author		: QSG
	*************************************************************/
	public String compareTwoDates(Calendar c1, Calendar c2) {
		String strRes = "";

		if (c1.before(c2)) {
			strRes = "before";
		}
		if (c1.after(c2)) {
			strRes = "after";
		}
		if (c1.equals(c2)) {
			strRes = "same";
		}

		return strRes;
	}

	/********************************************************************
	 * Description	: This function is used to add date to existing date
	 * Date			: 25/03/2012
	 * Author		: QSG
	*********************************************************************/
	public String AddDaytoExistingDate(String strExistDate,int intdays,String strDateFormat) throws ParseException{
		String dt = strExistDate; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		
		c.add(Calendar.DATE, intdays);  // number of days to add
		dt = sdf.format(c.getTime());  // dt is now the new date
		System.out.println(dt);
		return dt;	
	}
	
	/*************************************************************************************
	 * Description	: This function is used to add time to the existing minutes and hours 
	 * Date			: 25/03/2012
	 * Author		: QSG
	**************************************************************************************/
	public String AddTimeToExistingTimeHourAndMin(String strExistTime, int intHours,
			int intMin, String strTimeFormat) throws ParseException {
		String dt = strExistTime; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		c.add(Calendar.HOUR, intHours);
		c.add(Calendar.MINUTE, intMin);// number of days to add
		dt = sdf.format(c.getTime()); // dt is now the new date
		System.out.println(dt);
		return dt;
	}

	/**************************************************************************
	 * Description	: This function is used to add time to the existing minutes 
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************************/	
	public String addTimetoExisting(String strExistTime, int intMin,
			String strTimeFormat) throws ParseException {
		String dt = strExistTime; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));

		c.add(Calendar.MINUTE, intMin); // number of minutes to add
		dt = sdf.format(c.getTime()); // dt is now the new date
		System.out.println(dt);

		return dt;
	}
	
	/***********************************************************************
	 * Description	: This function is used to add time to the existing hour 
	 * Date			: 25/03/2012
	 * Author		: QSG
	************************************************************************/	
	public String addTimetoExistingHour(String strExistTime, int intHour,
			String strTimeFormat) throws ParseException {
		String dt = strExistTime; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));

		c.add(Calendar.HOUR, intHour); // number of minutes to add
		dt = sdf.format(c.getTime()); // dt is now the new date
		System.out.println(dt);
		return dt;
	}
	
	/******************************************************************
	 * Description	: This function is used to convert the date format
	 * Date			: 25/03/2012
	 * Author		: QSG
	*******************************************************************/	
	public String converDateFormat(String strExistDate, String strInputFormat,
			String strOutputFormat) throws ParseException {
		String dt = strExistDate; // Start date
		
			SimpleDateFormat sdf = new SimpleDateFormat(strInputFormat);
			SimpleDateFormat sdf1 = new SimpleDateFormat(strOutputFormat);
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));

			dt = sdf1.format(c.getTime()); // dt is now the new date
			System.out.println(dt);
		return dt;
		
	}

	/******************************************************************
	 * Description	: This function is used to get the time difference
	 * Date			: 25/03/2012
	 * Author		: QSG
	*******************************************************************/	
	public int getTimeDiff(String Time1, String Time2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		// Convert the user input into a date object
		Date time1 = sdf.parse(Time1);
		Date time2 = sdf.parse(Time2);

		// Get time values of the date objects
		long l1 = time1.getTime();
		long l2 = time2.getTime();
		double difference = (l1 - l2) / 1000; // Calculate the difference in
												// time (divide by 1000 as in
												// milliseconds)
		difference = (difference <= 0 ? 1 : difference); // If difference is
															// negative, make
															// positive

		int Timedifference = (int) difference;
		return Timedifference;
	}

	/**************************************************************
	 * Description	: This function is used to get the future year
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/	
	public String getFutureYear(int intYear, String strFormat) {
		String DATE_FORMAT = strFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		int yearval = intYear;
		c1.add(Calendar.YEAR, +yearval);
		String strDOB = sdf.format(c1.getTime());
		return strDOB;
	}

	/***********************************************************************************
	 * Description	: This function is used to get the time of the particular time zone
	 * Date			: 25/03/2012
	 * Author		: QSG
	**********************************************************************************/	
	public String getTimeOfParticularTimeZone(String strTimeZone,
			String strTimeFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(strTimeFormat);
		dateFormat.setTimeZone(TimeZone.getTimeZone(strTimeZone));
		String strDOB = dateFormat.format(new Date());
		return strDOB;
	}
	
	/***********************************************************************************
	 * Description	: This function is to get the time difference with two time formats
	 * Date			: 25/03/2012
	 * Author		: QSG
	 ***********************************************************************************/	
	public int getTimeDiffWithTimeFormat(String Time1, String Time2,
			String strTimeFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);

		// Convert the user input into a date object
		Date time1 = sdf.parse(Time1);
		Date time2 = sdf.parse(Time2);

		// Get time values of the date objects
		long l1 = time1.getTime();
		long l2 = time2.getTime();
		double difference = (l1 - l2) / 1000; // Calculate the difference in
												// time (divide by 1000 as in
												// milliseconds)
		difference = (difference <= 0 ? 1 : difference); // If difference is
															// negative, make
															// positive

		int Timedifference = (int) difference;
		return Timedifference;
	}

	/********************************************************************************
	 * Description	: This function is to add the number of years to the current year
	 * Date			: 25/03/2012
	 * Author		: QSG
	 ********************************************************************************/	
	public String AddYearToExisting(String strExistTime, int intYear,
			String strTimeFormat) throws ParseException {

		String dt = strExistTime; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));

		c.add(Calendar.YEAR, intYear);
		dt = sdf.format(c.getTime()); // dt is now the new date
		System.out.println(dt);

		return dt;
	}
	
	/******************************************************************************
	 * Description	: This function is to get the time difference between two times
	 * Date			: 25/03/2012
	 * Author		: QSG
	 ******************************************************************************/
	public int getTimeDiffWithTimeFormatInOurTime(String Time1, String Time2,
			String strTimeFormat,int Output) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(strTimeFormat);

		// Convert the user input into a date object
		Date time1 = sdf.parse(Time1);
		Date time2 = sdf.parse(Time2);

		// Get time values of the date objects
		long l1 = time1.getTime();
		long l2 = time2.getTime();
		double difference = (l1 - l2)/Output ; 
		int Timedifference = (int) difference;
		return Timedifference;
	}

	/**********************************************************************
	 * Description	: This function is to get the past day with date format
	 * Date			: 25/03/2014
	 * Author		: QSG
	 ***********************************************************************/
	public String getPastDayNew(int intDate, String strDateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				strDateFormat);
		Calendar c1 = Calendar.getInstance();
		int yearval = intDate;
		c1.add(Calendar.DATE, -yearval);
		String strDOB = sdf.format(c1.getTime());
		return strDOB;
	}
	
	 /********************************************************
	 * Description	: This function is to get the current day
	 * Date			: 25/03/2014
	 * Author		: Manasa
	 ********************************************************/
	public String getWeekDay(String strDayFormat) {
		String weekDay;
		SimpleDateFormat dayFormat = new SimpleDateFormat(strDayFormat,
				Locale.US);
		Calendar calendar = Calendar.getInstance();
		weekDay = dayFormat.format(calendar.getTime());
		return weekDay;
	}
	
	/*************************************************************
	 * Description	: This function is to generate random character
	 * Date			: 03/06/2014
	 * Author		: Arunkumar Hiremath
	 *************************************************************/
	public String generateRandomChar(int strNoOfChars) {
		StringBuffer buffer = new StringBuffer();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int N = alphabet.length();	
		for (int i = 0; i < strNoOfChars; i++) {
			double index = Math.random() * N;
			buffer.append(alphabet.charAt((int) index));
		}
	//	System.out.println(buffer.toString());
		return buffer.toString();
	}
	/****************************************************************
	 * Description	: This function is used to get the current month
	 * Date			: 25/03/2012
	 * Author		: QSG
	*****************************************************************/
	public String getMonthName(String strFormat) {
		Calendar ca1 = Calendar.getInstance();
		Date d = new Date(ca1.getTimeInMillis());
		String month = new SimpleDateFormat(strFormat).format(d);
		return month;
	}
	
	/**************************************************************
	 * Description	: This function is used to get the current date
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getCurrentYear() {
		String DATE_FORMAT = "yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(
				DATE_FORMAT);
		Calendar c1 = Calendar.getInstance();
		String strCurrentDate = sdf.format(c1.getTime());
		return strCurrentDate;
	}
	/**************************************************************
	 * Description	: This function is used to get the current date
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getPastMonth(int numberOfMonths,String monthFormat) {	
	Calendar cal =  Calendar.getInstance();
	cal.add(Calendar.MONTH ,-numberOfMonths);	
	String previousMonth  = new SimpleDateFormat(monthFormat).format(cal.getTime());	 
	return previousMonth;
	}
	
	/**************************************************************
	 * Description	: This function is used to get the future month
	 * Date			: 25/03/2012
	 * Author		: QSG
	***************************************************************/
	public String getFutureMonth(int intDate,String strDateFormat) {
		  String DATE_FORMAT = strDateFormat;
		  SimpleDateFormat sdf = new SimpleDateFormat(
		    DATE_FORMAT);
		  Calendar c1 = Calendar.getInstance();
		      int yearval = intDate;
		  c1.add(Calendar.MONTH, yearval);
		  String strDOB = sdf.format(c1.getTime());
		  return strDOB;
	}
}
