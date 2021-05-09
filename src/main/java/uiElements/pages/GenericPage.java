package uiElements.pages;

import org.openqa.selenium.support.PageFactory;
import uiElements.locators.GenericPageLocator;

public class GenericPage extends GenericPageLocator {

    public GenericPage(){
        PageFactory.initElements(driver,this);
    }

}
