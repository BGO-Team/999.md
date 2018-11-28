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
import NineNineNine.pageObjects.Header;
import NineNineNine.pageObjects.HomePage;
import NineNineNine.pageObjects.LoginFrame;
import NineNineNine.pageObjects.TopBar;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) {

        WebDriverManager webDriverManager = new WebDriverManager();
        PageObjectManager pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        HomePage homePage = pageObjectManager.getHomePage();
        homePage.toHomePage();
//        homePage.toTopBar().toLoginFrame().loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
        TopBar topBar = new TopBar(webDriverManager.getDriver());
        topBar.toLoginFrame();
        LoginFrame loginFrame = new LoginFrame(webDriverManager.getDriver());
        loginFrame.loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
        System.out.println(topBar.toTopBar().getUserName());
    }
}
