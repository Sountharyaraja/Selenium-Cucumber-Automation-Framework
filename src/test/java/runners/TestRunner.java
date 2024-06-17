package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests", glue = { "stepDefinitions" }, plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/cucumber.json" })

public class TestRunner {

}