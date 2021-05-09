package config;

import uiElements.pages.BasePage;
import utils.WebDriverManager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static void readPropertiesFile(){
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
            prop.load(inputStream);
            BasePage.explicitWaitTime = prop.getProperty("explicitWait");
            WebDriverManager.browser = prop.getProperty("browser");
            WebDriverManager.implicitWaitTime = prop.getProperty("implicitWait");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
