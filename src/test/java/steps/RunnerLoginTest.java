package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue={"steps"}
        ,plugin = {"junit:target/cucumber-reports/CucumberTestReport.xml", "json:target/cucumber-reports/CucumberTestReport.json"}
)
public class RunnerLoginTest {

}
