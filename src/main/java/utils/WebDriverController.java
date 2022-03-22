package utils;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverController {

    protected static WebDriver driver;
    public static String browser, implicitWaitTime;
    static ChromeOptions options = new ChromeOptions();

    public static WebDriver getDriver(){
        if(driver==null){
            PropertiesFile.readPropertiesFile();
        if(browser.equals("chrome")){
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = WebDriverManager.chromedriver().capabilities(options).create();
        }
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitWaitTime), TimeUnit.SECONDS);
        }
        return driver;

    }

    public static void closeBrowser(){
        driver.quit();
    }

}
