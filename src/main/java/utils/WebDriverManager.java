package utils;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    protected static WebDriver driver;
    public static String browser, implicitWaitTime;

    public static WebDriver getDriver(){
        PropertiesFile.readPropertiesFile();
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webDriverFile/chromedriver");
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/webDriverFile/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWaitTime), TimeUnit.SECONDS);

        return driver;
    }

    public static void closeBrowser(){
        driver.quit();
    }

}
