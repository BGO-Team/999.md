package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil extends AbstractWebDriverEventListener {
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());
    private static int logCounter = 0;
    private FileHandler fileHandler;

    LoggerUtil() {
        try {
            ++logCounter;
            FileManager.createDirectory();
            fileHandler = new FileHandler(FileManager.getLogPath());
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getLogCounter() {
        return logCounter;
    }

    public void close(){
        fileHandler.close();
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        LOGGER.info("WebDriver navigated to [" + s + "]");
        try {
            ScreenshotUtil.takeScreenshot(webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.info("WebDriver click on element - "
                + elementDescription(webElement));
        try {
            ScreenshotUtil.takeScreenshot(webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.info("Clicked successful");
        try {
            ScreenshotUtil.takeScreenshot(webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.info("WebDriver will change value for element - " + elementDescription(webElement) +
                " on [" + Arrays.toString(charSequences) + "]");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.info("WebDriver changed value for element - " + elementDescription(webElement));
        try {
            ScreenshotUtil.takeScreenshot(webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
