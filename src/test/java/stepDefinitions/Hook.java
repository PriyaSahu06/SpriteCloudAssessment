package stepDefinitions;

import helper.Helper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hook{

    private static WebDriver driver;
    public Scenario scenario;

    public WebDriver getDriver(){
        return Helper.GetInstanceDriverHandler().getDriver();
    }

    @Before
    public void InitiliazeTest(Scenario scenario){
        System.out.println("Running Scenario: " + scenario.getName());

        this.scenario = scenario;
        driver = Helper.GetInstanceDriverHandler().getDriver();
    }

    @AfterAll
    public static void AfterTests() {
        Helper.GetInstanceDriverHandler().TearDown();
    }


}