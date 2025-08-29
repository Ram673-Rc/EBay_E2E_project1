package testRunnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/features",   // ✅ Correct path
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "html:target/HTMLReport/cucumber.html",
        "json:target/JSONReport/cucumber.json",
        "junit:target/JUnitReport/cucumber.xml"
    },
    dryRun = false,
   // tags = "@Smoke",
    monochrome = true
    
)
public class TestRunner {
}
