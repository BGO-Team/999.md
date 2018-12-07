package pageObjects;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
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
}
