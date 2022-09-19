package stepDefinitions;

import UI_Test_Automation.pages.Home;
import UI_Test_Automation.pages.SampleApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private SampleApp sampleApp;
    private Home home;
    private WebDriver driver;

    //using dependency injection for Hook
    public LoginPage(Hook hook) {
        this.driver = hook.getDriver();
        sampleApp = new SampleApp(driver);
        home = new Home(driver);
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.navigate().to("http://www.uitestingplayground.com/home/");
    }

    @When("^I navigate to SampleApp$")
    public void iNavigateToSampleApp() throws Throwable {
        home.clickApp("SampleApp");
    }

    @When("^I enter username (.*) and password (.*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        sampleApp.setUserName(username);
        sampleApp.setPassword(password);
        sampleApp.clickLogin();
    }

    @Then("^I should see success message with username (.*)$")
    public void iSeeWelcomeMessage(String username) throws Throwable {
        Assert.assertEquals(sampleApp.getLabelText(),"Welcome, "+username+"!");

    }

}