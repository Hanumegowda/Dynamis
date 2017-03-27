package qaframework.helper;

import jxl.CellType;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class OfficeCommonFunctions{
	public Properties EnvDetails;
	@SuppressWarnings("unused")
	private static WritableCellFormat courier;

	/**
	 * This function is used to write data into the Excel file
	 * 
	 * @throws Exception
	 */
	public void WriteResultdb_Excel(String strTCId, String strTO,
			String strResult, String strReason, double dbTimeTaken,
			String FILE_PATH, boolean blnwrite, String strstarttime,
			String strDate, long lDateTime, String strbrowser,
			String strversion, String StrSessionId) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		// strDate = date.toString();

		ReadEnvironmentProperty objReadEnvironment = new ReadEnvironmentProperty();
		EnvDetails = objReadEnvironment.ReadEnvironment();

		// WRITE RESULTS TO EXCEL UNDER ANY CONDITION WITHOUT CHECKING ANY FLAG.

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));

		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(FILE_PATH), wb);

		// Total number of rows in the sheet
		int intRowCount = wwb.getSheet(0).getRows();
		for (int intRow = 4; intRow <= intRowCount; intRow++) {
			// Target cell
			WritableCell cell = wwb.getSheet(0).getWritableCell(1, intRow);

			if (cell.getType() == CellType.EMPTY) {
				WritableCellFormat wcf = new WritableCellFormat();
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf.setWrap(true);

				WritableFont courier10pt = new WritableFont(
						WritableFont.COURIER, 10);
				// Define the cell format
				courier = new WritableCellFormat(courier10pt);
				wcf.setFont(courier10pt);

				Label label0 = new Label(0, intRow, "", wcf);
				wwb.getSheet(0).addCell(label0);

				// Enter the TC ID
				Label label1 = new Label(1, intRow, strTCId, wcf);
				wwb.getSheet(0).addCell(label1);
				// Enter Test Objective
				Label label2 = new Label(2, intRow, strTO, wcf);
				wwb.getSheet(0).addCell(label2);
				// Enter Result
				Label label3 = new Label(3, intRow, strResult, wcf);
				wwb.getSheet(0).addCell(label3);
				// Enter Reason
				Label label4 = new Label(4, intRow, strReason, wcf);
				wwb.getSheet(0).addCell(label4);
				// Enter Time taken
				String strTime = String.valueOf(dbTimeTaken);
				Label label5 = new Label(5, intRow, strTime, wcf);
				wwb.getSheet(0).addCell(label5);

				String strRes = RunON();
				Label label6 = new Label(6, intRow, strRes, wcf);
				wwb.getSheet(0).addCell(label6);
				
				// Enter Date
				Label label7 = new Label(7, intRow, strDate, wcf);
				wwb.getSheet(0).addCell(label7);
				// Write the data
				wwb.write();
				intRow = intRowCount + 1;
			}
		}
		wwb.close();

		// WRITE RESULTS TO QNET WHEN THE FLAG IS SET AS TRUE IN THE PROPERTY
		// FILE.
		if (blnwrite == true) {

			// Enters this loop when results should be written to Qnet
			// Fetch the Build ID and Cycle Environment Map ID from Property file
			String strBuild = EnvDetails.getProperty("Build");
			String strCycleEnviMapID = EnvDetails.getProperty("CycleEnviMapID");
		
			// Converts time taken value from Seconds to Minutes
			dbTimeTaken = dbTimeTaken / 60;			
			strReason=strReason+"";
			strReason = strReason.replace("'", "''");
			// Write Results to Qnet Database.
			writeToDB(strCycleEnviMapID, strTCId, strBuild, strResult,
					strReason, dbTimeTaken, FILE_PATH, strDate + " "
							+ strstarttime, strbrowser);

		}

	}
	
	// Function to write result to DB table
	
	public void writeToDB(String strCycleEnviMapID, String strTestCaseID,
			String strBuildID, String strResult, String strComments,
			double dblTimeTaken, String strFilePath, String strExecutedDate,
			String strBrowserName) throws Exception {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // Start JDBC
		String strSqlURL = "jdbc:sqlserver://192.168.27.7;DatabaseName=QNET";
		String strUsername = "autoaccess";
		String strPassword = "admin@456";
		String strInsertSQL;

		try {
			Class.forName(driverName); // LOAD THE DATABASE DRIVER
			Connection conn = DriverManager.getConnection(strSqlURL,strUsername, strPassword);
			// ESTABLISH THE CONNECTION TO THE DATABASE

			Statement stmt = conn.createStatement(); // GET A STATEMENT FOR THE CONNECTION
			strInsertSQL = "Insert into tblAutomationResults "
					+ "(CycleEnviMapID,TestCaseID,BuildID,Result,Comments,TimeTaken,FilePath,ExecutedDate,BrowserName) values "
					+ "('" + strCycleEnviMapID + "','" + strTestCaseID + "','"
					+ strBuildID + "','" + strResult + "','" + strComments
					+ "','" + dblTimeTaken + "','" + strFilePath + "','"
					+ strExecutedDate + "','" + strBrowserName + "')"; // Insert
																		// a
																		// record*/

			stmt.executeUpdate(strInsertSQL); // EXECUTE THE SQL QUERY AND STORE IN RESULTS SET
			// CLOSE THE RESULT, STATEMENT AND CONNECTION
			stmt.close();
			conn.close();
			System.out.println("Insert to Table was successful");
		
		}catch (SQLException se) {//// HANDLE THE SQL EXCEPTION
			System.out.println("SQL Exception:");
			// PRINT TILL ALL THE ECEPTIONS ARE RAISED
			while (se != null) {
				System.out.println("State : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error : " + se.getErrorCode());
				se = se.getNextException();
			}
			
		}catch (Exception e) {//// CATCH THE CLASS EXCEPTION	
			System.out.println(e);
		}
	}
	

	/**
	 * This function is used calculate the Time taken for test case execution
	 */
	public double TimeTaken(Date dtStartDate) {
		Date dtEndDate = new Date();
		double dtTimeTaken = dtEndDate.getTime() - dtStartDate.getTime();
		dtTimeTaken = dtTimeTaken / 1000;
		return dtTimeTaken;

	}

	public String RunON() throws Exception {
		String strResult = "";
		ReadEnvironmentProperty objReadEnvironment = new ReadEnvironmentProperty();
		EnvDetails = objReadEnvironment.ReadEnvironment();
		if (EnvDetails.getProperty("Server").equals("saucelabs.com")) {
			strResult = "Sauce Labs";
		} else {
			strResult = "Local System";
		}
		return strResult;
	}
	
}
