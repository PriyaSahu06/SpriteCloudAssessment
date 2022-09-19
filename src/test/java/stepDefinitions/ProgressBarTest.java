package stepDefinitions;

import UI_Test_Automation.pages.Home;
import UI_Test_Automation.pages.ProgressBar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProgressBarTest {

    private ProgressBar progressBar;
    private Home home;
    private WebDriver driver;

    //using dependency injection for Hook
    public ProgressBarTest(Hook hook) {
        this.driver = hook.getDriver();
        progressBar = new ProgressBar(driver);
        home = new Home(driver);
    }


    @When("^I navigate to ProgressBar")
    public void iNavigateToProgressBar() throws Throwable {
        home.clickApp("ProgressBar");
    }

    @When("^I click on start$")
    public void iCLickStart() throws Throwable {
        progressBar.clickStart();
    }

    @When("^I check on progressBar and click stop$")
    public void iCheckProgressBarAndStop() throws Throwable {

        synchronized (driver) {
                try {
                    while (!progressBar.checkProgress().equalsIgnoreCase("75%")) {
                        driver.wait(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        progressBar.clickStop();
    }


    @Then("^I validate result label$")
    public void iValidateResultLabel() throws Throwable {
        Assert.assertTrue(progressBar.getLabelText().contains("Result: 0"),"Could not click at 75%");

    }

}