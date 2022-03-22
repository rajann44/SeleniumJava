package testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElements.pages.SignupPage;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class VerifySignUp {

    SignupPage signupPage = new SignupPage();

    @Test
    public void justBrowser(){

        signupPage.navigateToTheURL("https://google.com/");
        signupPage.refreshBrowser();

    }

}
