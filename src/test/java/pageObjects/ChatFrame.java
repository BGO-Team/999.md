package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatFrame extends Page {
    private String chatFrameName = "topbar-chat";


    @FindBy(css = "#simpalsid-chat-outbox-btn")
    private WebElement sentMessage;

    public ChatFrame(WebDriver driver) {
        super(driver);
    }

    public ChatFrame toChatFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(chatFrameName);
        return this;
    }

    public WebElement getSentMessage() {
        return sentMessage;
    }

}
