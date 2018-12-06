package managers;

import dataProviders.ConfigFileReader;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private DriverType driverType;
    private EventFiringWebDriver eventDriver;
    private LoggerManager loggerManager;

    public WebDriverManager(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        driverType = ConfigFileReader.getBrowser();
    }

    public WebDriver getDriver(){
        if (driver == null) driver = createDriver();
        return driver;
    }

    public LoggerManager getLoggerManager() {
        return loggerManager;
    }

    private WebDriver createDriver(){
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver();
            break;
            case FIREFOX:
                driver = new FirefoxDriver();
            break;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        eventDriver = new EventFiringWebDriver(driver);
        loggerManager = new LoggerManager();
        eventDriver.register(loggerManager);
        return eventDriver;
    }

    public void closeDriver(){
        eventDriver.quit();
    }
}
