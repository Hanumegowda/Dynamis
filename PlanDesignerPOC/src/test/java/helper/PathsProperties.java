package helper;

import java.io.InputStream;
import java.util.Properties;

public class PathsProperties {
	
	public Properties Read_FilePath() throws Exception {
		Properties autoitProps = new Properties();
		InputStream is = this.getClass().getResourceAsStream(System.getProperty("path.file","/Properties Files/path.properties"));
		autoitProps.load(is);
		return autoitProps;
	}

	/**********************************
	  Function to read the auto it path
	 **********************************/
	 public Properties ReadAutoit_FilePath() throws Exception {
	  Properties autoitProps = new Properties();
	  InputStream is = this.getClass().getResourceAsStream(
	    System.getProperty("autoit.file",
	      "/Properties Files/AutoitPath.properties"));
	  autoitProps.load(is);
	  return autoitProps;
	 }
}
