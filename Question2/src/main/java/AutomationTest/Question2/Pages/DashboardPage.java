package AutomationTest.Question2.Pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import AutomationTest.Question2.Base.BasePage;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(welcome));
	}

	@FindBy(how = How.CSS, using = "div.dashboard-bread h2.sec__title")
	WebElement welcome;
	@FindBy(how = How.CSS, using = "h4.author__title")
	WebElement userTitle;
	@FindBy(how = How.XPATH, using = "//ul[@class=\"sidebar-menu list-items\"]//a[@href=\"https://phptravels.net/account/profile\"]")
	WebElement myProfile;

	public String getWelcomeUserText() {
		String text = welcome.getText();
		return text;
	}

	public String getUserFirstName() {
		String firstName = userTitle.getText();
		return firstName;
	}
	
	public MyProfilePage clickOnMyProfile() {
		myProfile.click();
		return new MyProfilePage(driver);
	}
}
