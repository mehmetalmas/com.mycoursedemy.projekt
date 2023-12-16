package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static Properties userList;

    static {
        String dosyaYolu = "configuration.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        String dosyaYolu = "userList.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            userList = new Properties();
            userList.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getUser(String userKey) {
        return userList.getProperty(userKey);
    }

    public static String getPassword(String passwordKey) {
        return userList.getProperty(passwordKey);
    }
}
