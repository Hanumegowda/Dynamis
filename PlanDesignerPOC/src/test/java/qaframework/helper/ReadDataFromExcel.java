package qaframework.helper;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.Properties;

public class ReadDataFromExcel {
	
	public static String readDataFromTestDataDetails(String SheetName, int intRow,
			int intColumn) throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty("TestData_Path");
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		Sheet ws = null;

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		ws = wb.getSheet(SheetName);

		// Read content of the cell
		String strCellContent = ws.getCell(intColumn - 1, intRow - 1)
				.getContents();
		wb.close();

		return strCellContent;
	}
	
	public static String readDataFromMatrixDataExcel(String SheetName,
			int intRow, int intColumn) throws Exception {
		String FILE_PATH = "/src/test/resources/SupportFiles/MatrixResults.xls";
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		Sheet ws = null;

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		ws = wb.getSheet(SheetName);

		// Read content of the cell
		String strCellContent = ws.getCell(intColumn - 1, intRow - 1)
				.getContents();
		wb.close();

		return strCellContent;
	}

    public static String readCompanyNameFromDownloadedFile(String SheetName, int intColumn, String pastDate) throws Exception {
        PathsProperties objAP = new PathsProperties();
        Properties pathProps = objAP.Read_FilePath();
        String FILE_PATH = pathProps.getProperty("Result_path");
        String[] fileName = FILE_PATH.split("/");
        File file = new File(fileName[fileName.length - 1]);
        String path = file.getAbsolutePath();
        FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
        Sheet ws = null;

        // Read the existing file
        Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
        ws = wb.getSheet(SheetName);

        String strCellContent = null;
        int intRow = 1;
        while(ws.getCell(intColumn - 1, intRow - 1).getContents()!= null){
            @SuppressWarnings("unused")
			String content ;
            content = ws.getCell(intColumn - 1, intRow - 1).getContents();
        }

        // Read content of the cell
        //String strCellContent = null;
        //String strCellContent = ws.getCell(intColumn - 1, intRow - 1).getContents();
        wb.close();

        return strCellContent;
    }


}
