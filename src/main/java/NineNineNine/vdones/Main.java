package NineNineNine.vdones;

    //TODO: Access Category -> Sub-category -> Product (DONE)
    //TODO: Add to favorite (DONE)
    //TODO: Change language (DONE)
    //TODO: Cucumber Scenarios
    //TODO: Add Product

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.PageObjectManager;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Set;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        WebDriverManager webDriverManager = new WebDriverManager();
        PageObjectManager pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//        pageObjectManager.getPage("FavoritesPage", webDriverManager.getDriver());
//        FavoritesPage favoritesPage = new FavoritesPage(webDriverManager.getDriver());
//        favoritesPage.toPage();
        Page homePage = new HomePage(webDriverManager.getDriver());
        ((HomePage) homePage).toPage();
//        homePage.topBar().changeLanguage();
        homePage.topBar().toLoginFrame();
        LoginFrame loginFrame = new LoginFrame(webDriverManager.getDriver());
        loginFrame.loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
//        webDriverManager.getDriver().navigate();
//                get("https://999.md/cabinet/favorites");



//        Set<String> logTypes = getWebDriver().manage().logs().getAvailableLogTypes();
//        Set<String> logTypes = webDriverManager.getDriver().manage().logs().getAvailableLogTypes();
//        for (String s : logTypes)
//            System.out.println(s);

    }
}
