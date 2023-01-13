package AutomationTest.Question2.TestCases;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import AutomationTest.Question2.Base.BaseTest;
import AutomationTest.Question2.Pages.DashboardPage;
import AutomationTest.Question2.Pages.LoginPage;
import AutomationTest.Question2.Pages.MyProfilePage;

public class LoginTest extends BaseTest{

	@Test
	public void testLoginCorrectUser() {
		String email = "user@phptravels.com";
		String pw = "demouser";
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboard = loginPage.loginSuccess(email, pw);
		String actualWelcome = dashboard.getWelcomeUserText();
		
		MyProfilePage profile = dashboard.clickOnMyProfile();
		String expWelcome = "^Hi, " + profile.getUserFirstName() + " " + profile.getUserLastName();
		Pattern pat = Pattern.compile(expWelcome);
		Matcher matcher = pat.matcher(actualWelcome);
		assertTrue("User name is incorrect", matcher.find());
	}
	
	@Test
	public void testLoginFieldsStatus() {
		String expEmailPH = "Email";
		String expPasswordPH = "Password";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.tickRememberMe();

		assertThat("Email placeholder is incorrect", loginPage.getEmailPlaceHolder(), is(expEmailPH));
		assertThat("Password placeholder is incorrect", loginPage.getPasswordPlaceHolder(), is(expPasswordPH));
		assertThat("Remember me checkbox is not ticked after clicking on it", loginPage.isRememberMe(), is(true));
	}
}
