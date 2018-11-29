package NineNineNine.managers;

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private DriverType driverType;

    public WebDriverManager(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        driverType = ConfigFileReader.getBrowser();
    }

    public WebDriver getDriver(){
        if (driver == null) driver = createDriver();
        return driver;
//        return createDriver();
    }

    private WebDriver createDriver(){
        switch (driverType) {
            case CHROME: driver = new ChromeDriver();
            break;
            case FIREFOX: driver = new FirefoxDriver();
            break;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
