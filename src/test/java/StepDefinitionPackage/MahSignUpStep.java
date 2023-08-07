package StepDefinitionPackage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import BrowserFactory.BrowserClass;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.deser.DataFormatReaders;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MahSignUpStep {
	
	WebDriver driver;

	@Given("Open signup url in browser")
	public void open_signup_url_in_browser() {
		driver = BrowserClass.getBrowser();
		driver.get("https://myassignmenthelp.com/Home/signup.php");
	}
	@Given("Wait for signup page to load")
	public void wait_for_signup_page_to_load() throws Exception {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(2000);
	}
	@When("i enter valid details")
	public void i_enter_valid_details(DataTable dataTable) {
		List<Map<String, String>> DataF = dataTable.asMaps(String.class,String.class);
		for( Map<String, String> namess : DataF) {
			String ffString = namess.get("Name");
			driver.findElement(By.cssSelector(".p-relative>input#Student_Name")).sendKeys(ffString);
			System.out.println("Name is.." + ffString);
			
			String ffString1 = namess.get("Emailid");
			driver.findElement(By.cssSelector(".p-relative>input#Email")).sendKeys(ffString1);
			System.out.println("Emailid is.." + ffString1);
			
			String ffString2 = namess.get("PhoneNo");
			driver.findElement(By.cssSelector(".p-relative>input#Phone_No")).sendKeys(ffString2);
			System.out.println("PhoneNo is.." + ffString2);
		}
	}

}
