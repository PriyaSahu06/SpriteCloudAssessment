

package UI_Test_Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SampleApp {

    private WebDriver driver;

    public SampleApp(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    //Link to accept cookies
    @FindBy(how=How.NAME,using = "UserName")

    private WebElement userName;

    //search box
    @FindBy(how=How.NAME,using = "Password")
    private WebElement password;

    //Suggestion for search box
    @FindBy(how=How.ID,using = "login")
    private WebElement login;

    //div with suggestion

    @FindBy(how=How.ID,using="loginstatus")
    private WebElement label;



    public void setUserName(String userName){
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        this.login.click();
    }
    public String getLabelText() {
        return this.label.getText();
    }



}