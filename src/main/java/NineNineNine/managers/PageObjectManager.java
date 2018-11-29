package NineNineNine.managers;

import NineNineNine.pageObjects.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.util.HashMap;

public class PageObjectManager {
    private WebDriver driver;
    private CategoryPage categoryPage;
    private FavoritesPage favoritesPage;
    private Header header;
    private HomePage homePage;
    private LoginFrame loginFrame;
    private ProductPage productPage;
    private SubCategoryPage subCategoryPage;
    private TopBar topBar;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public static void getPage(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("NineNineNine.pageObjects." + page);
        Method method = clazz.getMethod("getPage");
        method.invoke(clazz.getConstructor(WebDriver.class).newInstance(driver));
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginFrame getLoginFrame() {
        return (loginFrame == null) ? loginFrame = new LoginFrame(driver) : loginFrame;
    }

    public Header getHeader() {
        return (header == null) ? header = new Header(driver) : header;
    }

    public TopBar getTopBar() {
        return (topBar == null) ? topBar = new TopBar(driver) : topBar;    }

    public CategoryPage getCategoryPage() {
        return (categoryPage == null) ? categoryPage = new CategoryPage(driver) : categoryPage;
    }

    public SubCategoryPage getSubCategoryPage() {
        return (subCategoryPage == null) ? subCategoryPage = new SubCategoryPage(driver) : subCategoryPage;
    }

    public ProductPage getProductPage() {
        return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
    }

    public FavoritesPage getFavoritesPage() {
        return (favoritesPage == null) ? favoritesPage = new FavoritesPage(driver) : favoritesPage;
    }
}
