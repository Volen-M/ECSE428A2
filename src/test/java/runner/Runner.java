package runner;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/feature"},
    glue = {"stepdefinitions"}
)

public class Runner {

}
