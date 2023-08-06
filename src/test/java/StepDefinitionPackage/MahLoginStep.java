package StepDefinitionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import BrowserFactory.BrowserClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MahLoginStep {
	
	WebDriver driver;
	
	@Given("Open login url in browser")
	public void open_login_url_in_browser() {
		driver = BrowserClass.getBrowser();
		driver.get("https://myassignmenthelp.com/Home/login.php");
	}
	
	@And("Wait for login page to load")
	public void wait_for_login_page_to_load() throws Exception {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(2000);
	/*	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		 wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.cssSelector("div[class$='ing']>h1[class='homepage-subheading']"));
		     }
		   }); */
	}

	@When("enter valid emailid as {string}")
	public void enter_valid_emailid_as(String emailid) {
	    driver.findElement(By.cssSelector(".p-relative>input#txtEmail")).sendKeys(emailid);
	}
	@And("enter valid password as {string}")
	public void enter_valid_password_as(String password) {
		  driver.findElement(By.cssSelector(".p-relative>input#password")).sendKeys(password);
	}

	@When("enter emailid as {string}")
	public void enter_emailid_as(String emailid) {
		 driver.findElement(By.cssSelector(".p-relative>input#txtEmail")).sendKeys(emailid);
	}
	@When("enter password as {string}")
	public void enter_password_as(String password) {
		 driver.findElement(By.cssSelector(".p-relative>input#password")).sendKeys(password);
	}





}
