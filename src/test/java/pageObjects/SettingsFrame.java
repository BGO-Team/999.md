package pageObjects;

import utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Year;
import java.util.List;

public class SettingsFrame {
    private final WebDriver driver;
    private WaitUtil wait;

    @FindBy(id = "simpalsid-settings-tab")
    public WebElement settingsTab;

    @FindBy(css = "input[name=\"first_name\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"last_name\"]")
    private WebElement lastNameField;

    @FindBy(css = "select[name=\"birthdate_day\"] > option")
    private List<WebElement> datesOfBirth;

    @FindBy(css = "select[name=\"birthdate_day\"] > option[selected]")
    private WebElement dateOfBirthField;

    @FindBy(css = "select[name=\"birthdate_month\"] > option")
    private List<WebElement> monthsOfBirth;

    @FindBy(css = "select[name=\"birthdate_year\"] > option")
    private List<WebElement> yearsOfBirth;

    @FindBy(css = "select[name=\"sex\"] > option")
    private List<WebElement> genderOptions;

    @FindBy(css = "#pjax-container > aside > ul > li:nth-child(2) > a")
    private WebElement emailSettings;

    @FindBy(css = "#simpalsid-settings-tab > form > div:nth-child(4) > input")
    private WebElement emailField;

    @FindBy(css = "button.simpalsid-modal-content-form-submit-btn")
    private WebElement saveButton;

    @FindBy(id = "simpalsid-settings-tab-success")
    private WebElement successMessage;

    @FindBy(css = ".simpalsid-chat-content-box-message:nth-child(1) >div:nth-child(3)")
    private WebElement incomingMessage;

    @FindBy(css = ".simpalsid-chat-content-box-message:nth-child(1) >div:nth-child(3)")
    private WebElement sentMessage;

    public SettingsFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }

    public void setNameDetails(String firstName, String lastName) {
        setNameField(firstName);
        setLastNameField(lastName);
    }

    public void setBirthDay(int day, int month, int year) {
        selectBirthDate(day);
        selectBirthMonth(month);
        selectBirthYear(year);
    }

    public void changeFrame() {
        driver.switchTo().defaultContent();
        wait.waitFor().until(ExpectedConditions.visibilityOf(driver.findElement(By.id("topbar-settings"))));
        driver.switchTo().frame("topbar-settings");
        wait.toBeVisible(firstNameField);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "male":
                genderOptions.get(1).click();
                break;
            case "female":
                genderOptions.get(2).click();
                break;
            default:
                genderOptions.get(0).click();
                break;
        }
    }

    public String getSuccessMessage() {
        wait.toBeVisible(successMessage);
        return successMessage.getText();
    }

    private void setNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    private void setLastNameField(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    private void selectBirthDate(int date) {
        if (date < 32 && date > 0) {
            WebElement dateOfBirth = datesOfBirth.get(date - 1);
            dateOfBirth.click();
        }
    }

    private void selectBirthMonth(int month) {
        if (month < 13 && month > 0) {
            WebElement monthOfBirth = monthsOfBirth.get(month - 1);
            monthOfBirth.click();
        }
    }

    private void selectBirthYear(int year) {
        if (year > 1901 && year <= Year.now().getValue()) {
            WebElement yearOfBirth = yearsOfBirth.get(Year.now().getValue() - year);
            yearOfBirth.click();
        }
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getDateOfBirthField() {
        return dateOfBirthField;
    }

    public String firstnameVerify() {
        return firstNameField.getAttribute("value");

    }

    public String lastnameVerify() {
        return lastNameField.getAttribute("value");
    }

    public String emailVerify() {
        return emailField.getAttribute("value");
    }

    public void emailSettings() {
        emailSettings.click();
    }

    public String getIncomingMessage() {
        return incomingMessage.getText();
    }

    public String getSentMessage() {
        return sentMessage.getText();
    }
}
