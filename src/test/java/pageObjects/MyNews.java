package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;

public class MyNews {

    private final WebDriver driver;
    private static String dateTime;


    @FindBy(css = "#js-cabinet-items-list > tr:nth-child(1) > td.cabinet__user-ads__title > h3 > a")
    private WebElement lastNewsAddedTitle;


    public MyNews(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String newsAdded() {
        return lastNewsAddedTitle.getText();
    }

    public void findMyNews() {

        lastNewsAddedTitle.click();
    }


    public static String timeTitle(){
        LocalDateTime localDateTime = LocalDateTime.now();
        dateTime = "_" + localDateTime.getMonth() + "_" + localDateTime.getDayOfMonth() + "_"
                + localDateTime.getHour() + "_" + localDateTime.getMinute();
        System.out.println(dateTime);
        return dateTime;

    }

}
