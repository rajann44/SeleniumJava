package uiElements.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uiElements.pages.BasePage;

public class GenericPageLocator extends BasePage {

    //Work Email Locator on signup page
    @FindBy(how= How.XPATH, using = "//input[@id='email']")
    public WebElement workEmail;

    //Work Email Locator on signup page
    @FindBy(how= How.XPATH, using = "//input[@id='email']")
    public WebElement workEmail;

}
