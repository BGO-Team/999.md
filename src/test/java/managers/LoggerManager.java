package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerManager extends AbstractWebDriverEventListener {
    private static final Logger LOGGER = Logger.getLogger(LoggerManager.class.getName());
    private static int logCounter = 0;
    private FileHandler fileHandler;

    LoggerManager() {
        try {
            fileHandler = new FileHandler("logs/testLog" + (++logCounter) +".log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        fileHandler.close();
    }

//    @Override
//    public void afterNavigateTo(String s, WebDriver webDriver) {
//        LOGGER.info("WebDriver navigated to [" + s + "]");
//        try {
//            ScreenshotManager.takeScreenshot(webDriver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.info("WebDriver click on element - "
                + elementDescription(webElement));
    }

//    @Override
//    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
//        LOGGER.info("Clicked successful");
//        try {
//            ScreenshotManager.takeScreenshot(webDriver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.info("WebDriver will change value for element - " + elementDescription(webElement) +
                " on [" + Arrays.toString(charSequences) + "]");
    }

//    @Override
//    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
//        LOGGER.info("WebDriver changed value for element - " + elementDescription(webElement));
//        try {
//            ScreenshotManager.takeScreenshot(webDriver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private String elementDescription(WebElement element) {
        String description = "[tag:" + element.getTagName();
        if (element.getAttribute("id") != null) {
            description += " id: " + element.getAttribute("id");
        }
        else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }
        description += " ('" + element.getText() + "')]";
        return description;
    }
}
