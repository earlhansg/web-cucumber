import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", 
glue= {"StepDefinitions"}, 
plugin = {"pretty", "json:target/report/cucumber.html", "json:target/report/cucumber.json"})
public class TestRunner {

}
