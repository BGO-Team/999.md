package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Page {

    public final WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void getPage(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("pageObjects." + page);
        Method method = clazz.getMethod("toPage");
        method.invoke(clazz.getConstructor(WebDriver.class).newInstance(driver));
        // TODO: return clazz
    }

    public static void toPage(String page, WebDriver driver) {
        Method method;
        try {
            method = Class.forName("pageObjects." + page).getMethod("toPage");
            method.invoke(Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException |
                InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Object getPageObject(String page, WebDriver driver) {
        try {
            return Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clickElement(Object pageName, String elementName, WebDriver driver) {
        WebElement webElement;

        Class clazz = null;
        try {
            clazz = Class.forName("pageObjects." + pageName.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(elementName))
                    try {
                        webElement = ( WebElement ) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
                        webElement.click();
                    } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                            InvocationTargetException e) {
                        e.printStackTrace();
                    }
            }
    }

    public static void goToFrame(Object frameName, WebDriver driver) {
        try {
            driver.switchTo().defaultContent();
            Class clazz = Class.forName("pageObjects." + frameName.toString());
            String codeFrameName = Character.toLowerCase(frameName.toString().charAt(0)) + (frameName.toString().length() > 1 ? frameName.toString().substring(1) : "") + "Name";

            Field field = clazz.getDeclaredField((codeFrameName));
            field.setAccessible(true);
            driver.switchTo().frame(( String ) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver)));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public TopBar topBar() {
        return new TopBar(driver);
    }

    public Header header() {
        return new Header(driver);
    }

    public SettingsFrame settings() {
        return new SettingsFrame(driver);
    }
}
