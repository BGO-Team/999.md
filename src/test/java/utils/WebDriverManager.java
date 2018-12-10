package utils;

import dataProviders.TestDataFileReader;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private DriverType driverType;
    private EventFiringWebDriver eventDriver;
    private LoggerUtil loggerUtil;

    public WebDriverManager() {
        new TestDataFileReader();
        driverType = TestDataFileReader.getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public LoggerUtil getLoggerUtil() {
        return loggerUtil;
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        eventDriver = new EventFiringWebDriver(driver);
        loggerUtil = new LoggerUtil();
        eventDriver.register(loggerUtil);
        return eventDriver;
    }

    public void switchWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle
        }
    }

    public void closeDriver() {
        eventDriver.quit();
    }
}
