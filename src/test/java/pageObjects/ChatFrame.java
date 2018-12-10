package pageObjects;

import utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatFrame extends Page{
    private WaitUtil wait;
    private String chatFrameName = "topbar-chat";


    @FindBy(css = "#simpalsid-chat-outbox-btn")
    private WebElement sentMessage;

    public ChatFrame(WebDriver driver) {
        super(driver);
        wait = WaitUtil.getInstance(driver);
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
