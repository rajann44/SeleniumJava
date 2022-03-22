package config;

import uiElements.pages.BasePage;
import utils.WebDriverController;

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
            WebDriverController.browser = prop.getProperty("browser");
            WebDriverController.implicitWaitTime = prop.getProperty("implicitWait");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
