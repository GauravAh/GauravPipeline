package StepDefinitionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BrowserFactory.BrowserClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MahLandingStep {
	
	WebDriver driver;

	@Given("Open url in browser")
	public void open_url_in_browser() {
		driver = BrowserClass.getBrowser();
		driver.get("https://myassignmenthelp.com/");
	}
	
	@And("Wait for page to load")
	public void wait_for_page_to_load() throws Exception {
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

	@When("I verify the title and url")
	public void i_verify_the_title_and_url() {
	    String getTitle = driver.getTitle();
	    System.out.println("Title is.." + getTitle);
	    if(getTitle.equals("MyAssignmentHelp.com - #1 Assignment Help Company [35% OFF]")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.fail();
	    }
	}
	@Then("Title with Url should match")
	public void title_with_url_should_match() {
	   String getUrl = driver.getCurrentUrl();
	   System.out.println("Url is.." + getUrl);
	   if(getUrl.equals("https://myassignmenthelp.com/")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.fail();
	    }
	}

	@When("enter valid emailid")
	public void enter_valid_emailid() throws Exception {
	   Actions actions = new Actions(driver);
	   WebElement emailField = driver.findElement(By.cssSelector("input[id='email']"));
	   actions.moveToElement(emailField).click().build().perform();
	   actions.sendKeys("gauravabsas12345@gmail.com").build().perform();
	}
	@When("valid subjects")
	public void valid_subjects() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
		WebElement subjectField = driver.findElement(By.cssSelector("div[class='__input-box']>div>div>input[name='Subject_Name']"));
		actions.moveToElement(subjectField).click().build().perform();
		js.executeScript("arguments[0].value='testing_tech-maths';",subjectField);
	}

	@When("select date datepicker")
	public void select_date_datepicker() {
	   driver.findElement(By.cssSelector(".__input-box>div>div>input#date")).click();
	   String monthAnddate = driver.findElement(By.cssSelector(".__input-box>div>div>div>div>span.dpx-title")).getText();
	   String[] arr = monthAnddate.split("\\s");
	   String month =arr[0];
	   String year =arr[1];
	   System.out.println("Month is.." + month);
	   System.out.println("Year is.." + year);
	   
	   switch (month) {
	case "July":
			driver.findElement(By.xpath("//*[@class='dpx-content-box']/span[@class='dpx-item'][25]")).click();
		break;
		
	case "August":
		driver.findElement(By.xpath("//*[@class='dpx-content-box']/span[@class='dpx-item'][25]")).click();
	break;

	default:
		break;
	}
	   
	}
	@When("select time from dropdown")
	public void select_time_from_dropdown() {
		WebElement dueTime = driver.findElement(By.id("time"));
	    Select select = new Select(dueTime);
	    select.selectByVisibleText("12:00 PM");
	}
	@When("enter assignment description")
	public void enter_assignment_description() {
	    driver.findElement(By.cssSelector(".__input-box>div>textarea#description")).sendKeys("Testing pls ignore it");
	}
	@When("attach a file")
	public void attach_a_file() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    WebElement addFiles = driver.findElement(By.cssSelector(".input-file-container>div>div>input#files1"));
	    js.executeScript("arguments[0].click();", addFiles);
	    Thread.sleep(7000);
	    String autoitFile = System.getProperty("user.dir") + "\\ExternalFiles\\MAH.exe";
	    String filePath =System.getProperty("user.dir") + "\\ExternalFiles\\TestingDoc.docx";
	    
	    String[] cmd = {autoitFile,filePath};
	    
	    Runtime.getRuntime().exec(cmd);
	}


}
