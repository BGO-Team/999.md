package NineNineNine.managers;

import NineNineNine.pageObjects.Header;
import NineNineNine.pageObjects.HomePage;
import NineNineNine.pageObjects.LoginFrame;
import NineNineNine.pageObjects.TopBar;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginFrame loginFrame;
    private Header header;
    private TopBar topBar;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = HomePage.getInstance(driver) : homePage;
    }

    public LoginFrame getLoginFrame() {
        return (loginFrame == null) ? loginFrame = LoginFrame.getInstance(driver) : loginFrame;
    }

    public Header getHeader() {
        return (header == null) ? header = Header.getInstance(driver) : header;
    }

    public TopBar getTopBar() {
        return (topBar == null) ? topBar = TopBar.getInstance(driver) : topBar;
    }
}
