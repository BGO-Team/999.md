package NineNineNine.vdones;

    //TODO: Access Category -> Sub-category -> Product (DONE)
    //TODO: Add to favorite (DONE)
    //TODO: Change language (DONE)
    //TODO: Cucumber Scenarios
    //TODO: Add Product

import NineNineNine.cucumber.ScenarioContext;
import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.PageObjectManager;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.*;

import java.lang.reflect.InvocationTargetException;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        WebDriverManager webDriverManager = new WebDriverManager();
//        PageObjectManager pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//        HomePage homePage = pageObjectManager.getHomePage();
//        homePage.toHomePage();
////        homePage.toTopBar().toLoginFrame().loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
//        TopBar topBar = new TopBar(webDriverManager.getDriver());
//        topBar.toLoginFrame();
//        LoginFrame loginFrame = new LoginFrame(webDriverManager.getDriver());
//        loginFrame.loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
//        System.out.println(topBar.toTopBar().getUserName());
        Object homePage = PageObjectManager.getPage("HomePage", webDriverManager.getDriver());
//        homePage.getPage(webDriverManager.getDriver());
        TopBar topBar = new TopBar(webDriverManager.getDriver());
        topBar.changeLanguage();
    }
}
