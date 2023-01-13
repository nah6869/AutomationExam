package AutomationTest.Question2.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

	protected WebDriver driver;
	private String url = "https://phptravels.net/login";

	public BaseTest() {

	}

	@Before
	public void startBrowser() {
		String webDriverPath = System.getProperty("user.dir").concat(File.separator).concat("driver")
				.concat(File.separator).concat("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", webDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
