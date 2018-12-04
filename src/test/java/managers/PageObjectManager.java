package managers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    private SettingsFrame settingsFrame;
    private Object object;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public static void getPage(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("pageObjects." + page);
        Method method = clazz.getMethod("toPage");
        method.invoke(clazz.getConstructor(WebDriver.class).newInstance(driver));
    }

    public void clickButton(String pageName, String buttonName, Object value) throws ClassNotFoundException, InterruptedException {
        WebElement webElement = null;
        Class referenceClass = Class.forName("pageObjects." + pageName);

        Field[] fields = referenceClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(buttonName)) {
                    try {
                        System.out.println(field.getName());
                        webElement = ( WebElement ) field.get(value);
                        webElement.click();
                        Thread.sleep(5000);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }


        public void clickBsssutton(String buttonName, String pageName) throws ClassNotFoundException, IllegalAccessException {
//        boolean switcher = false;
//        List<Class> commands = new ArrayList<>();
//        URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
//
//
//        File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".class");
//            }
//        });
//
//        for (File file : files){
//            String className = file.getName().replaceAll(".class", "");
//            System.out.println(className);
//            Class referenceClass = Class.forName(packageName + "." + className);

        Class referenceClass = Class.forName("pageObjects." + pageName);

            Field[] allObjects = referenceClass.getFields();

            for (Field value : allObjects) {
                if (value.getName().equalsIgnoreCase(buttonName)) {
                    System.out.println(value.getName());
                    WebElement element = ( WebElement ) value.get(buttonName);
                    PageFactory.initElements(driver, referenceClass+".class");
                    element.click();
                    break;
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
}
