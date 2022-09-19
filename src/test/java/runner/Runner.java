package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},

        glue = {"stepDefinitions"},
        tags = "(@testUI or @testAPI)",
        monochrome = true,
        plugin = {"pretty","json:report/reports.json",
                "testng:report/Cucumber.xml",
                "html:report/reports2.html"}
)

public class Runner extends AbstractTestNGCucumberTests{
}

