package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/Users/softsuave/IdeaProjects/leafground-table-bdd/.mvn/auth.feature",
    glue = {"stepDefinitions","hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/cucumber.json"},
        tags = "@textbox"



)

public class AuthRunner extends AbstractTestNGCucumberTests {


}
