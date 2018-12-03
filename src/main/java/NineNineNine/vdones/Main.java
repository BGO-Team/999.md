package NineNineNine.vdones;

    //TODO: Access Category -> Sub-category -> Product (DONE)
    //TODO: Add to favorite (DONE)
    //TODO: Change language (DONE)
    //TODO: Cucumber Scenarios
    //TODO: Add Product

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.*;

import java.util.Set;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) {
        WebDriverManager webDriverManager = new WebDriverManager();
        Page homePage = new HomePage(webDriverManager.getDriver());
        ((HomePage) homePage).toPage();
        homePage.topBar().changeLanguage();
//        homePage.topBar().toLoginFrame();
//        LoginFrame loginFrame = new LoginFrame(webDriverManager.getDriver());
//        loginFrame.loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());


//        Set<String> logTypes = getWebDriver().manage().logs().getAvailableLogTypes();
//        Set<String> logTypes = webDriverManager.getDriver().manage().logs().getAvailableLogTypes();
//        for (String s : logTypes)
//            System.out.println(s);

    }
}
