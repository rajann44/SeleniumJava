package uiElements.pages;

import config.PropertiesFile;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import utils.WebDriverController;

public class BasePage {

    public static String explicitWaitTime;
    protected WebDriver driver = WebDriverController.getDriver();
    protected Actions action = new Actions(WebDriverController.getDriver());
    public JavascriptExecutor js = (JavascriptExecutor)driver;
    protected WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(explicitWaitTime));

    @AfterSuite
    public void cleanup(){
        driver.quit();
    }

    public BasePage () {
        PageFactory.initElements(driver, this);
        PropertiesFile.readPropertiesFile();
    }

    /**
     * Refreshes browser
     */
    public void refreshBrowser()
    {
        driver.navigate().refresh();
    }

    /**
     * Navigates to the passed url
     */
    public void navigateToTheURL(String url) {
        driver.get(url);
    }

    /**
     * Close browser
     */
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Wait for element to be Visible
     */
    public WebElement waitForElementToBeVisible(WebElement element)
    {
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This Method is used to drag and drop element
     * @param element
     * @param toElement
     * @throws InterruptedException
     */
    public void dragAndDrop(WebElement element, WebElement toElement){
        action.dragAndDrop(element,toElement).build().perform();
    }

    /**
     * This method will Zoom in or Zoom out the browser as per passed %age
     * @param browserSize pass the value of browser size
     */
    public void browserZoomInOut(int browserSize){
        driver.switchTo().window(driver.getWindowHandle());
        String zoomJS = "document.body.style.zoom='"+browserSize+"%'";
        js.executeScript(zoomJS);
    }

    /**
     * Checks whether a web element is clickable or not
     * @param element
     * @return
     */
    public boolean isElementClickable(WebElement element)
    {
        try{
            WebDriverWait newWait = new WebDriverWait(driver, 5);
            newWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e){ return false; }
    }

    /**
     * This method will pauses the execution for specified number of seconds
     * @param noOfSeconds
     */
    public void sleepFor(int noOfSeconds) {
        int time = noOfSeconds * 1000;
        try{
            Thread.sleep(time);
        }catch (Exception exception){
            System.out.println("Exception while executing sleep.");
        }
    }

}
