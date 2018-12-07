package utils;

import pageObjects.*;
import org.openqa.selenium.WebDriver;

import pageObjects.ChatFrame;
import pageObjects.SettingsFrame;

public class PageObjectManager {
    private WebDriver driver;
    private Header header;
    private SubCategoryPage subCategoryPage;
    private TopBar topBar;
    private MyNews myNews;
    private SettingsFrame settingsFrame;
    private ProductListPage productListPage;
    private ChatFrame chatFrame;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader() {
        return (header == null) ? header = new Header(driver) : header;
    }

    public TopBar getTopBar() {
        return (topBar == null) ? topBar = new TopBar(driver) : topBar;
    }


    public SubCategoryPage getSubCategoryPage() {
        return (subCategoryPage == null) ? subCategoryPage = new SubCategoryPage(driver) : subCategoryPage;
    }

    public SettingsFrame getSettingsFramePage() {
        return (settingsFrame == null) ? settingsFrame = new SettingsFrame(driver) : settingsFrame;
    }

    public  ProductListPage getProductListPage(){
        return (productListPage == null) ? productListPage = new ProductListPage(driver) : productListPage;
    }

    public MyNews getMyNews() {
        return (myNews == null) ? myNews = new MyNews(driver) : myNews;
    }

    public ChatFrame getChatFrame() {
        return (chatFrame == null) ? chatFrame = new ChatFrame(driver) : chatFrame;
    }
}
