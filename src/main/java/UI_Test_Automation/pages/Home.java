

package UI_Test_Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    @FindBy(how=How.XPATH,using = "/html/body/section[2]/div/div[4]/div[2]/h3/a")
    private WebElement sampleApp;

    @FindBy(how=How.XPATH,using = "/html/body/section[2]/div/div[3]/div[4]/h3/a")
    private WebElement progressBar;

    @FindBy(how=How.XPATH,using = "/html/body/section[2]/div/div[4]/div[1]/h3/a")
    private WebElement visibility;



    public void clickApp(String clickableButton) {
        switch (clickableButton) {
            case "SampleApp":
                this.sampleApp.click();
                break;
            case "ProgressBar":
                this.progressBar.click();
                break;
            case "Visibility":
                this.visibility.click();
        }
    }



}