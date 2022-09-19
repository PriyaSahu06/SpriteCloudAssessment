package stepDefinitions;

import UI_Test_Automation.pages.Home;
import UI_Test_Automation.pages.Visibility;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VisibilityTest {

    private Visibility visibility;
    private Home home;
    private WebDriver driver;

    //using dependency injection for Hook
    public VisibilityTest(Hook hook) {
        this.driver = hook.getDriver();
        visibility = new Visibility(driver);
        home = new Home(driver);
    }


    @When("^I navigate to Visibility page$")
    public void iNavigateToVisibility() throws Throwable {
        home.clickApp("Visibility");
    }

    @When("^I validate visibility of other buttons:(.*)$")
    public void iValidateVisibility(String input) throws Throwable {
        switch(input) {
            case "visible":
                Assert.assertTrue(visibility.getVisibilityOfWebElement(),"Element not visible");
                break;
            case "invisible":
                Assert.assertFalse(visibility.getVisibilityOfWebElement());
        }
    }

    @When("^I click on hide$")
    public void iClickHide() throws Throwable {
        visibility.clickHide();

    }

}