package pageObjects;

import managers.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatFrame {
    private final WebDriver driver;
    private WaitManager wait;
    private String chatFrameName = "topbar-chat";


    @FindBy(css = "#simpalsid-chat-outbox-btn")
    private WebElement sentMessage;

    public ChatFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitManager(driver);
    }

    public ChatFrame toChatFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(chatFrameName);
        return this;
    }

    public WebElement getSentMessage(){
        return sentMessage;
    }

}
