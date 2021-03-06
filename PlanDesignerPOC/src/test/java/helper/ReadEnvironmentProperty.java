package helper;

import java.io.InputStream;
import java.util.Properties;

public class ReadEnvironmentProperty {

	public Properties ReadEnvironment() throws Exception {
		Properties environmentProps = new Properties();
		String propertiesFilename = System.getProperty("environment.file", "/Properties Files/environment.properties");
		InputStream is = this.getClass().getResourceAsStream(propertiesFilename);
		environmentProps.load(is);

		// bamboo sauce
		if (System.getProperty("bamboo.SELENIUM_HOST") != null) {
		    environmentProps.setProperty("Server", System.getProperty("bamboo.SELENIUM_HOST"));
		}
		if (System.getProperty("bamboo.SELENIUM_PORT") != null) {
		    environmentProps.setProperty("ServerPort", System.getProperty("bamboo.SELENIUM_PORT"));
		}
		if (System.getProperty("bamboo.SELENIUM_BROWSER") != null) {
		    environmentProps.setProperty("Browser", System.getProperty("bamboo.SELENIUM_BROWSER"));
		}

		return environmentProps;
	}

}
