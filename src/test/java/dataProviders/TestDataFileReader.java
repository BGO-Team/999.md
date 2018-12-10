package dataProviders;

import enums.DriverType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            throw new RuntimeException("test.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the test.properties file for the Key:url");
    }

    public static DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else throw new RuntimeException("Browser Name Key value in test.properties is not matched : " + browserName);
    }

    public static String getUserLogin(String user) {
        String login = properties.getProperty("testUser" + user +".login");
        if(login != null) return login;
        else throw new RuntimeException("Application login not specified in the test.properties file for the Key:login");
    }

    public static String getUserPassword(String user) {
        String password = properties.getProperty("testUser" + user +".password");
        if(password != null) return password;
        else throw new RuntimeException("Application password not specified in the test.properties file for the Key:password");
    }

    public static String getTitleNewsInput() {
        String titleNews1 = properties.getProperty("testNews1.titleNews");
        if (titleNews1 != null) return titleNews1;
        else
            throw new RuntimeException("Application titleNews not specified in the test.properties file for the Key:titleNews");
    }

    public static String getInfoPostInput() {
        String infoNews1 = properties.getProperty("testNews1.infoNews");
        if (infoNews1 != null) return infoNews1;
        else
            throw new RuntimeException("Application infoNews not specified in the test.properties file for the Key:infoNews");
    }

    public static String getFirstName() {
        String firstname = properties.getProperty("testUserSecond.firstname");
        if (firstname != null) return firstname;
        else
            throw new RuntimeException("Application firstname not specified in the test.properties file for the Key:firstname");
    }

    public static String getLastName() {
        String secondname = properties.getProperty("testUserSecond.secondname");
        if (secondname != null) return secondname;
        else
            throw new RuntimeException("Application secondname not specified in the test.properties file for the Key:secondname");
    }

    public static String getEmailAdress() {
        String email = properties.getProperty("testUserSecond.email");
        if (email != null) return email;
        else
            throw new RuntimeException("Application email not specified in the test.properties file for the Key:email");
    }


}
