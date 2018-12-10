package pageObjects;

import enums.Context;
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

    public static void clickElement(Object pageName, String elementName, WebDriver driver) {
        try {
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
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void goToFrame(Object frameName, WebDriver driver) throws
            ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        driver.switchTo().defaultContent();
        Class clazz = Class.forName("pageObjects." + frameName.toString());
        String codeFrameName = Character.toLowerCase(frameName.toString().charAt(0)) + (frameName.toString().length() > 1 ? frameName.toString().substring(1) : "") + "Name";

        Field field = clazz.getDeclaredField((codeFrameName));
        field.setAccessible(true);
        driver.switchTo().frame(( String ) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver)));
    }

    public static Object getPage(Object pageName, WebDriver driver) {
        try {
            Class clazz = Class.forName("pageObjects." + pageName.toString());
            Object object = clazz.getConstructor(WebDriver.class).newInstance(driver);
            return object;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "Error";
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
}
