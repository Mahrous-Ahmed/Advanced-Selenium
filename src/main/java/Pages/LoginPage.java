package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By submitLocator = By.id("submit");

    private By errorLocator = By.id("error");

    private String url = "https://practicetestautomation.com/practice-test-login/";

    public LoginPage(WebDriver webDriver, Logger log) {
        super(webDriver, log);
    }


    public LoginPage open() {
        driver.get(url);
        return this;
    }


    public void executeLogin(String username , String password){
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(usernameLocator , username);
        type(passwordLocator , password);
        click(submitLocator);
    }

    public loggedInSuccessfullyPage positiveTest(String username , String password){
        executeLogin(username , password);
        return new loggedInSuccessfullyPage(driver,log);
    }


    public void negativeTest(String username , String password){
        executeLogin(username , password);
        log.info("Error appears: "+getErrorText());
    }


    public String  getErrorText(){
        return getText(errorLocator);
    }








}
