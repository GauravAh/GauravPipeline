package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(
		features = "src/test/java/FeaturePackage/",
		glue = {"StepDefinitionPackage","HooksPackage"},
		tags = "@sanity", 
		/* dryRun = true, */
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/report.html"}
		)
public class RunnerClass extends AbstractTestNGCucumberTests {

}
