package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class MyNews {

    private final WebDriver driver;


    @FindBy(css = "#js-cabinet-items-list > tr:nth-child(1) > td.cabinet__user-ads__title > h3 > a")
    private WebElement lastNewsAddedTitle;

    @FindBy(xpath = "//*[@id=\"js-ads-container\"]/ul/li/div[2]/a")
    private List<WebElement> products;


    public MyNews(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String newsAdded() {
        return lastNewsAddedTitle.getText();
    }

    public void findMyNews() {

        lastNewsAddedTitle.click();
    }


    public static String timeTitle(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return "_" + localDateTime.getMonth() + "_" + localDateTime.getDayOfMonth() + "_"
                + localDateTime.getHour() + "_" + localDateTime.getMinute() + "_" + localDateTime.getSecond();

    }

    public void toProduct(int number){
        if (number < 1 || number > products.size())
            throw new IllegalArgumentException("Does not exist such product");
        products.get(number - 1).click();
    }

    public void toProduct(String product){
        if (product.equals("Random")) {
            Random random = new Random();
            int randomProduct = random.nextInt(products.size()) + 1;
            toProduct(randomProduct);
        }
        else {
            boolean existProduct = true;
            for (WebElement element : products)
                if (element.getText().equals(product)) {
                    existProduct = false;
                    element.click();
                    break;
                }
            if (existProduct)
                throw new IllegalArgumentException("This product does not exist");
        }
    }

}
