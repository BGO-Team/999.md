package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitManager {
    private WebDriverWait wait;

    public WaitManager(WebDriver driver) {
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
