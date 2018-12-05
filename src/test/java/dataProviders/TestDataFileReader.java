package dataProviders;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestDataFileReader {
    private static Properties properties;

    public TestDataFileReader() {
        properties = new Properties();
        String PROPERTY_FILE_PATH = "src" + File.separator + "test" + File.separator + "testResources" +
                File.separator + "test.properties";
        try {
            properties.load(new FileReader(PROPERTY_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("data.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getUserLogin(String user) {
        String login = properties.getProperty("testUser" + user +".login");
        if(login != null) return login;
        else throw new RuntimeException("Application login not specified in the data.properties file for the Key:login");
    }

    public static String getUserPassword(String user) {
        String password = properties.getProperty("testUser" + user +".password");
        if(password != null) return password;
        else throw new RuntimeException("Application password not specified in the data.properties file for the Key:password");
    }
}
