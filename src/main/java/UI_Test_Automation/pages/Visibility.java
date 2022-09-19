

package UI_Test_Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Visibility {

    private WebDriver driver;

    public Visibility(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }


    @FindBy(how=How.ID,using = "hideButton")
    private WebElement hideButton;

    @FindBy(how=How.ID,using = "removedButton")
    private WebElement removeButton;

    @FindBy(how=How.ID,using = "zeroWidthButton")
    private WebElement zeroWidthButton;

    @FindBy(how=How.ID,using = "overlappedButton")
    private WebElement overlappedButton;

    @FindBy(how=How.ID,using = "transparentButton")
    private WebElement opacityButton;

    @FindBy(how=How.ID,using = "invisibleButton")
    private WebElement invisibleButton;

    @FindBy(how=How.ID,using = "notdisplayedButton")
    private WebElement notdisplayedButton;

    @FindBy(how=How.ID,using = "offscreenButton")
    private WebElement offscreenButton;

    public boolean getVisibilityOfWebElement(){
        return this.offscreenButton.isDisplayed() && this.notdisplayedButton.isDisplayed() && this.invisibleButton.isDisplayed() && this.opacityButton.isDisplayed() && this.overlappedButton.isDisplayed() && this.zeroWidthButton.isDisplayed() && this.removeButton.isDisplayed();
    }

    public void clickHide() {
        this.hideButton.click();
    }


}