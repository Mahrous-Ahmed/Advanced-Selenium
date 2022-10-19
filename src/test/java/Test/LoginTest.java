package Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.loggedInSuccessfullyPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void logInTest(){
        LoginPage loginPage = new LoginPage(driver,log).open();
        loggedInSuccessfullyPage successfullyPage =  loginPage.positiveTest("student","Password123");
        Assert.assertEquals(successfullyPage.getUrl() , successfullyPage.getCurrentUrl());

    }


    @Test(priority = 2)
    @Parameters({"username", "password" , "expectedMessage"})
    public void negativeLogInTest(String username , String password , String expectedMessage ){
        LoginPage loginPage = new LoginPage(driver,log).open();
        loginPage.negativeTest(username,password);
        Assert.assertEquals(loginPage.getErrorText() , expectedMessage);


    }
}
