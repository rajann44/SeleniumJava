package uiElements.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignupPageLocator extends GenericPageLocator {

    //Full Name Locator on signup page
    @FindBy(how= How.XPATH, using = "//input[@title='Search']")
    public WebElement fullNameOnSignupPage;

    //Full Name Locator on signup page
    @FindBy(how= How.XPATH, using = "//input[@title='Search']")
    public WebElement fullNameOnSignupPag2;

}
