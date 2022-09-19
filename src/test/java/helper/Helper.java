package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Helper {
    private WebDriver driver;
    private static Helper _driverHandler;


    private Helper() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        String os = System.getProperty("os.name");
        if(os.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        } else if(os.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static Helper GetInstanceDriverHandler(){
        if (null == _driverHandler)
            _driverHandler = new Helper();
        return _driverHandler;
    }

    // Get the driver
    public WebDriver getDriver() {
        return driver;
    }

    // Close the driver
    public void TearDown() {
        driver.close();
        driver.quit();
    }

}