package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserClass {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> Tdriver = new ThreadLocal<WebDriver>();
	
	public static void setBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("start-maximized");
			Tdriver.set(new ChromeDriver(options));
			System.out.println("Thread Id is.." + Thread.currentThread().getId());
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("incognito");
			options.addArguments("start-maximized");	
			driver= new FirefoxDriver(options);
		}
	}
	
	public static WebDriver getBrowser() {
		return Tdriver.get();
		
	}

}
