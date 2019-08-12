package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(features = {"src/test/java/features"}, plugin = "json:target/cucumber.json", glue = "steps")
    public class TestRunnerIT extends AbstractTestNGCucumberTests
    {

    }

