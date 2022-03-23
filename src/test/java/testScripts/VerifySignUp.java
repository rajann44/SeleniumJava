package testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElements.pages.SignupPage;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class VerifySignUp {

    SignupPage signupPage = new SignupPage();

    @Test(priority = 1)
    public void navigation_01(){
        signupPage.navigateToTheURL("https://google.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void navigation_02(){
        signupPage.navigateToTheURL("https://bing.com/");
        Assert.assertTrue(true);
        signupPage.refreshBrowser();
    }

    @Test(priority = 3)
    public void navigation_03(){
        signupPage.navigateToTheURL("https://www.sony.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void navigation_04(){
        signupPage.navigateToTheURL("http://yahoo.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void navigation_05(){
        signupPage.navigateToTheURL("https://www.aol.com/");
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void navigation_06(){
        signupPage.navigateToTheURL("https://duckduckgo.com/");
        Assert.assertTrue(true);
    }

}
