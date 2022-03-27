package testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElements.pages.SignupPage;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class VerifyCreativeWeb {

    SignupPage signupPage = new SignupPage();

    @Test(priority = 1)
    public void navigation_03(){
        signupPage.navigateToTheURL("https://www.sony.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void navigation_05(){
        signupPage.navigateToTheURL("https://www.aol.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void navigation_08_Fail2(){
        signupPage.navigateToTheURL("https://google.com/");
        Assert.assertTrue(false);
    }

}
