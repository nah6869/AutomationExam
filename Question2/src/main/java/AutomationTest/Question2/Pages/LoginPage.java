package AutomationTest.Question2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import AutomationTest.Question2.Base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "email")
	WebElement txtEmail;
	@FindBy(how = How.NAME, using = "password")
	WebElement txtPw;
	@FindBy(how = How.XPATH, using = "//input[@id = 'rememberchb']/following-sibling::label")
	WebElement lblRememberMe;
	@FindBy(how = How.ID, using = "rememberchb")
	WebElement ckbRememberMe;
	@FindBy(how = How.CSS, using = "button.btn-lg")
	WebElement btnLogin;
	
	public DashboardPage loginSuccess(String email, String pw) {
		txtEmail.sendKeys(email);
		txtPw.sendKeys(pw);
		btnLogin.click();		
		return new DashboardPage(driver);
	}
	
	public void tickRememberMe() {
		lblRememberMe.click();
	}
	
	public String getEmailPlaceHolder() {
		String emailHolder = getPlaceHolderOf(txtEmail);
		return emailHolder;
	}
	
	public String getPasswordPlaceHolder() {
		String emailHolder = getPlaceHolderOf(txtPw);
		return emailHolder;
	}
	
	public boolean isRememberMe() {
		return ckbRememberMe.isSelected();
	}
	
	private String getPlaceHolderOf(WebElement element) {
		String placeHolder = element.getAttribute("placeholder");
		return placeHolder;
	}
}
