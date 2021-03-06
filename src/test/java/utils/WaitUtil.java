package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        wait = new WebDriverWait(driver, 30, 2000);
    }

    public WebDriverWait waitFor() {
        return wait;
    }

    public void toBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void toBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
