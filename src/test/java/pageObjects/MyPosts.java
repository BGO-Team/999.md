package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;

public class MyPosts {

    private final WebDriver driver;

    @FindBy(css = "#js-cabinet-items-list > tr:first-child > td.cabinet__user-ads__title > h3 > a")
    private WebElement lastNewsAddedTitle;

    public MyPosts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String timeTitle() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return "_" + localDateTime.getMonth() + "_" + localDateTime.getDayOfMonth() + "_"
                + localDateTime.getHour() + "_" + localDateTime.getMinute() + "_" + localDateTime.getSecond();
    }

    public String newsAdded() {
        return lastNewsAddedTitle.getText();
    }
}
