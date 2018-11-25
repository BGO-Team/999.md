package NineNineNine.vdones;

import NineNineNine.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    //TODO: Access Category -> Sub-category -> Product
    //TODO: Add to favorite
    //TODO: Change language (DONE)

public class Main {

    //vvdtest1@mail.ru
    //testpassword

    private static final String login = "vvdtest1@mail.ru";
    private static final String password = "testpassword";

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://999.md");


        HomePage homePage = new HomePage(driver);

        homePage.toTopBar().toLoginFrame().loginAs(login, password);
        homePage.toTopBar().changeLanguage();
        homePage.toTopBar().changeLanguage();

    }
}
