package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;


    public BasePageObject(WebDriver webDriver , Logger log){
        driver = webDriver;
        this.log = log;
    }


    /** Get URL of current page from browser */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    /** Get title of current page */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }


    /** Get source of current page */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }



    public WebElement find(By locator){
       return driver.findElement(locator);
    }


    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void waitForElement(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver , 30);
            wait.until(ExpectedConditions.visibilityOf(find(locator)));
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void type(By locator , String text){
        waitForElement(locator);
        find(locator).sendKeys(text);
    }


    public void click(By locator ){
        waitForElement(locator);
        find(locator).click();
    }



    public String getText(By locator ){
        waitForElement(locator);
      return  find(locator).getText();
    }


    public String getAttribute(By locator ){
        waitForElement(locator);
        return  find(locator).getText();
    }








}
