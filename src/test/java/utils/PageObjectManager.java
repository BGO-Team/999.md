package utils;

import pageObjects.*;
import org.openqa.selenium.WebDriver;

import pageObjects.ChatFrame;
import pageObjects.SettingsFrame;

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
    private AddNewsPage addNewsPage;
    private MyNews myNews;
    private SettingsFrame settingsFrame;
    private ProductListPage productListPage;
    private ChatFrame chatFrame;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
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
        return (topBar == null) ? topBar = new TopBar(driver) : topBar;
    }

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

    public SettingsFrame getSettingsFramePage() {
        return (settingsFrame == null) ? settingsFrame = new SettingsFrame(driver) : settingsFrame;
    }

    public  ProductListPage getProductListPage(){
        return (productListPage == null) ? productListPage = new ProductListPage(driver) : productListPage;
    }

    public AddNewsPage getAddNewsPage() {
        return (addNewsPage == null) ? addNewsPage = new AddNewsPage(driver) : addNewsPage;
    }

    public MyNews getMyNews() {
        return (myNews == null) ? myNews = new MyNews(driver) : myNews;
    }

    public ChatFrame getChatFrame() {
        return (chatFrame == null) ? chatFrame = new ChatFrame(driver) : chatFrame;
    }
}
