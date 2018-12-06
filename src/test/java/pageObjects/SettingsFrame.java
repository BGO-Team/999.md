package pageObjects;

import managers.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Year;
import java.util.List;

public class SettingsFrame {
    private final WebDriver driver;
    private WaitManager wait;

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

    @FindBy(css = "button.simpalsid-modal-content-form-submit-btn")
    private WebElement saveButton;

    @FindBy(id = "simpalsid-settings-tab-success")
    private WebElement successMessage;

    public SettingsFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitManager(driver);
    }

    public void setNameDetails(String firstName, String lastName) {
        setNameField(firstName);
        setLastNameField(lastName);
    }

    public void setBirthDay(int day, int mounth, int year) {
        selectBirthDate(day);
        selectBirthMonth(mounth);
        selectBirthYear(year);

    }

    public void changeFrame() {
        driver.switchTo().defaultContent();
        wait.waitFor().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-settings"));
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

    public void save() {
        saveButton.click();
    }

    public WebElement getSaveButton(){
        return saveButton;
    }
}
