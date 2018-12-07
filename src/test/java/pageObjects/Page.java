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

    public static void clickElement(Object pageName, String elementName, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        WebElement webElement = null;

        Class clazz = Class.forName("pageObjects." + pageName.toString());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields)
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(elementName))
                    try {
                        webElement = ( WebElement ) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
                        webElement.click();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public TopBar topBar(){
        return new TopBar(driver);
    }

    public Header header(){
        return new Header(driver);
    }

//    public SettingsFrame settings(){
//        return new SettingsFrame(driver);
//    }

    public static void getPage(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Method method = Class.forName("pageObjects." + page).getMethod("toPage");
        method.invoke(Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
    }

    public static Page getClass(String page, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Page) Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver);
    }

    public static void clickElement(Object pageName, String elementName, Object value) throws ClassNotFoundException{
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
}
