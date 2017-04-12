package requirement;

import lib.data.LoginData;
import lib.navigation.HeaderNavigations;
import lib.page.HomePage;
import lib.page.LoginPage;

import org.testng.annotations.Test;

import configuration.Configuration;

public class Login extends Configuration{
	public Login() throws Exception{
		super();
	}
	LoginPage when;
	HomePage then;
	@Test
	public void loginAssertions() throws Exception{
		when = new LoginPage(this.driver);
		LoginPage loginPage = new LoginPage(this.driver);
		then = new HomePage(this.driver);
		HeaderNavigations headerNavigations = new HeaderNavigations(this.driver);
		
		when.login(Configuration.URL, LoginData.USERNAME, LoginData.PASSWORD);
		then.verifyHomePage();
		headerNavigations.clickLogout();
		when.login(Configuration.URL, LoginData.INVALID_UN, LoginData.INVALID_PWD);
		loginPage.verifyInvalidCredentialsError();
		then.verifyHomePageNotDisplayed();
	}

}
