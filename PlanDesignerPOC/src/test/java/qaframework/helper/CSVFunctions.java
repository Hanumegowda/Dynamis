package qaframework.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

public class CSVFunctions {
	
    public String[] readCompanyNameFromDownloadedFile(String SheetName, String pastDate) throws Exception {
        PathsProperties objAP = new PathsProperties();
        Properties pathProps = objAP.Read_FilePath();
        String FILE_PATH = pathProps.getProperty("Result_path");
        String[] fileName = FILE_PATH.split("/");
        File file = new File(fileName[fileName.length - 1]);
        String path = file.getAbsolutePath();
        FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);

        String line;
        @SuppressWarnings("unused")
		String Line = "";
        @SuppressWarnings("unused")
		int count = 1;
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        ArrayList<String> companyName = new ArrayList<String>();

        while ((line = br.readLine()) != null ) {

            Line = line;

            String[] values = line.split(",");
            int arrayLength = values.length;
            if(arrayLength > 3){
                if(values[3]!= null){
                    if(values[3].contains(pastDate)) {
                        companyName.add(values[2]);
                    }
                }
            }
            
            count++;
        }
        String[] companyNames = companyName.toArray(new String[companyName.size()]);
        br.close();

        return companyNames;
    }
}
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		

