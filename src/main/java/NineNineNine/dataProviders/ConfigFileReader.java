package NineNineNine.dataProviders;

import NineNineNine.enums.DriverType;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        String PROPERTY_FILE_PATH = "src" + File.separator + "resources" +
                File.separator + "data.properties";
        try {
            properties.load(new FileReader(PROPERTY_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("data.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the data.properties file for the Key:url");
    }

    public static DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else throw new RuntimeException("Browser Name Key value in data.properties is not matched : " + browserName);
    }


}
