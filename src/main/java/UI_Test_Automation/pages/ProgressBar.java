

package UI_Test_Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProgressBar {

    private WebDriver driver;

    public ProgressBar(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }


    @FindBy(how=How.ID,using = "startButton")

    private WebElement startButton;


    @FindBy(how=How.ID,using = "stopButton")
    private WebElement stopButton;


    @FindBy(how=How.ID,using = "progressBar")
    private WebElement progressBar;



    @FindBy(how=How.ID,using="result")
    private WebElement label;



    public void clickStart(){
        this.startButton.click();
    }

    public void clickStop(){
        this.stopButton.click();
    }

    public String checkProgress() {
        return this.progressBar.getText();
    }

    public String getLabelText() {
        return this.label.getText();
    }



}