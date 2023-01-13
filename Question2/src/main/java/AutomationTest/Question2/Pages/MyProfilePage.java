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

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(txtFirstname));
	}

	@FindBy(how = How.CSS, using = "div.dashboard-bread h2.sec__title")
	WebElement welcome;
	@FindBy(how = How.NAME, using = "firstname")
	WebElement txtFirstname;
	@FindBy(how = How.NAME, using = "lastname")
	WebElement txtLastname;
	@FindBy(how = How.XPATH, using = "//ul[@class=\"sidebar-menu list-items\"]//a[@href=\"https://phptravels.net/account/profile\"]")
	WebElement myProfile;

	public String getUserLastName() {
		String text = txtLastname.getAttribute("value");
		return text;
	}

	public String getUserFirstName() {
		String firstName = txtFirstname.getAttribute("value");
		return firstName;
	}
}
