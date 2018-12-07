package utils;

import org.openqa.selenium.WebElement;
import pageObjects.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static void getPage(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Method method = Class.forName("pageObjects." + page).getMethod("toPage");
        method.invoke(Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
    }

    public static Page getClass(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Page) Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver);
    }

    public void clickElement(Object pageName, String elementName, Object value) throws ClassNotFoundException{
        WebElement webElement = null;
        Class referenceClass = Class.forName("pageObjects." + pageName.toString());

        Field[] fields = referenceClass.getDeclaredFields();
        for (Field field : fields)
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(elementName))
                    try {
                        webElement = ( WebElement ) field.get(value);
                        webElement.click();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
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
