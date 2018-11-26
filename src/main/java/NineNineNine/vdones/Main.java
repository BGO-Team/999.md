package NineNineNine.vdones;

    //TODO: Access Category -> Sub-category -> Product
    //TODO: Add to favorite
    //TODO: Change language (DONE)

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.PageObjectManager;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.HomePage;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) {

        WebDriverManager webDriverManager = new WebDriverManager();
        PageObjectManager pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        HomePage homePage = pageObjectManager.getHomePage();
        homePage.toHomePage();
        homePage.toTopBar().toLoginFrame().loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
        homePage.toTopBar().changeLanguage();
        homePage.toTopBar().changeLanguage();
    }
}
