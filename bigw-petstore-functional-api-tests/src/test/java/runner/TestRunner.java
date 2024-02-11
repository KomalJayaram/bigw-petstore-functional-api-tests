package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/feature/pet.feature",
        glue = "src/test/java/steps/addPetAPITests.java",
        plugin  = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        },
        monochrome = true
)
public class TestRunner {
}
