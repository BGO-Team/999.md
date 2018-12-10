package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver){

      try {
          File scrFile = (( TakesScreenshot ) driver).getScreenshotAs(OutputType.FILE);

          LocalDateTime localDateTime = LocalDateTime.now();
          String dateTime = localDateTime.getMonth() + "_" + localDateTime.getDayOfMonth() + "_"
                  + localDateTime.getHour() + "_" + localDateTime.getMinute() + "_" + localDateTime.getSecond();
          FileHandler.copy(scrFile, new File(FileManager.getPath() + File.separator + dateTime + ".png"));
      }catch (IOException e){
          e.printStackTrace();
      }
      }
}
