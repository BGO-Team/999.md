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
//        PageObjectManager.getPage("HomePage", webDriverManager.getDriver());
//        topBar.changeLanguage();
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.getPage();
        homePage.toCategory(1);
//        CategoryPage categoryPage = new CategoryPage(webDriverManager.getDriver());
//        System.out.println(categoryPage.getCategoryName());
//        categoryPage.toSubCategory(1);
    }
}
