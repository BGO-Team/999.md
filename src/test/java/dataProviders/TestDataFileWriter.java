package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.EncryptionUtil.encrypt;

public class TestDataFileWriter {
    public static void WritePropertiesFile(String key, String data) throws IOException {
        FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        Properties configProperty = new Properties();

        File file = new File("src/test/testResources/test.properties");
        fileIn = new FileInputStream(file);
        configProperty.load(fileIn);
        configProperty.setProperty(key, encrypt(data));
        fileOut = new FileOutputStream(file);
        configProperty.store(fileOut,"");

    }
}
