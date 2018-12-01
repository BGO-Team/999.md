package NineNineNine.vdones;

    //TODO: Access Category -> Sub-category -> Product (DONE)
    //TODO: Add to favorite (DONE)
    //TODO: Change language (DONE)
    //TODO: Cucumber Scenarios
    //TODO: Add Product

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.*;

public class Main {
    //bgoautomationtest@gmail.com

    //Git: ProBook6570b

    public static void main(String[] args) {

        WebDriverManager webDriverManager = new WebDriverManager();
//        PageObjectManager pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//        PageObjectManager.toHome("HomePage", webDriverManager.getDriver());
//        topBar.changeLanguage();

//        Page productPage = new ProductPage(webDriverManager.getDriver());
//        System.out.println(((ProductPage) productPage).getProductName());

        Page homePage = new HomePage(webDriverManager.getDriver());
        ((HomePage) homePage).toPage();
        homePage.topBar().toLoginFrame();
        LoginFrame loginFrame = new LoginFrame(webDriverManager.getDriver());
        loginFrame.loginAs(ConfigFileReader.getUserLogin(), ConfigFileReader.getUserPassword());
//        homePage.toCategory("Работа");
//        CategoryPage categoryPage = new CategoryPage(webDriverManager.getDriver());
//        categoryPage.toSubCategory(1);
//        SubCategoryPage subCategoryPage = new SubCategoryPage(webDriverManager.getDriver());
//        subCategoryPage.toProduct(2);
//        System.out.println(webDriverManager.getDriver().getCurrentUrl());
//        webDriverManager.closeDriver();
//        String s = "https://999.md/ru/category/transport";
//        String s = "https://999.md/ru/";
//        System.out.println(s.substring(15, 17));

    }
}
