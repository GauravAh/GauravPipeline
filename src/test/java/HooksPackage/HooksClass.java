package HooksPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import BrowserFactory.BrowserClass;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksClass {
	
	WebDriver driver;
	
	@Before
	public void setUpBrowser() {
		BrowserClass.setBrowser("chrome");
		driver = BrowserClass.getBrowser();
	}

}
