package managers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static com.sun.deploy.cache.Cache.copyFile;

public class ScreenshotManager {
//    public static void takeScreenshot(WebDriver driver) throws IOException {
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String dateTime = localDateTime.getMonth() + "_" + localDateTime.getDayOfMonth() + "_"
//                + localDateTime.getHour() + "_" + localDateTime.getMinute() + "_" + localDateTime.getSecond();
//        copyFile(scrFile, new File("screenshots/" + dateTime + ".png"));
//    }
}
