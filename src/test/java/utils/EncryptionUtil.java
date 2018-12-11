package utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptionUtil {
    static PooledPBEStringEncryptor encryptor = null;
    static {
        encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword("qwerty123");
        encryptor.setAlgorithm("PBEWITHMD5ANDDES");
    }

    public static String encrypt(String input) {
        return encryptor.encrypt(input);
    }

    public static String decrypt(String encryptedMessage) {
        return encryptor.decrypt(encryptedMessage);
    }
}
