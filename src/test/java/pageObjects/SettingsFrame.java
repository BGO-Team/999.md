package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Year;
import java.util.List;

public class SettingsFrame {
    private static SettingsFrame instance;
    private String selectedDateOfBirth;
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[name=\"first_name\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"last_name\"]")
    private WebElement lastNameField;

    @FindBy(css = "select[name=\"birthdate_day\"] > option")
    private List<WebElement> datesOfBirth;

    @FindBy(css = "select[name=\"birthdate_day\"] > option[selected]")
    private WebElement dateOfBirthField;

    @FindBy(css = "select[name=\"birthdate_month\"] > option")
    private List<WebElement> mounthsOfBirth;

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
        wait = new WebDriverWait(driver, 50);

    }

    public void setNameDetails(String firstName, String lastName) {
        setNameField(firstName);
        setLastNameField(lastName);
    }

    public void setBirthDay(int day, int mounth, int year) {
        selectBirthDate(day);
        selectBirthMounth(mounth);
        selectBirthYear(year);

    }

    public void changeFrame() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe[id=\"topbar-settings\"]"))));
        driver.switchTo().frame("topbar-settings");
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
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
        wait.until(ExpectedConditions.visibilityOf(successMessage));
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

    private void selectBirthMounth(int mounth) {
        if (mounth < 13 && mounth > 0) {
            WebElement mounthOfBirth = mounthsOfBirth.get(mounth - 1);
            mounthOfBirth.click();
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


    public String getSelectedDateOfBirth() {

        return selectedDateOfBirth;
    }

    public WebElement getDateOfBirthField() {
        return dateOfBirthField;
    }


}
