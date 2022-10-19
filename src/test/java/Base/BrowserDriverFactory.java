package Base;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.logging.Level;


public class BrowserDriverFactory {

    private WebDriver driver;
    private String browserName;
    private Logger log;

    public BrowserDriverFactory(String browser , Logger logger){
        browserName = browser.toLowerCase(Locale.ROOT);
        log = logger;
    }

    public WebDriver createDriver(){
        log.info("Create driver: " + browserName);

        switch (browserName){
            case "chrome" :
                log.info( browserName + ", starting Now.");
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox" :
                log.info( browserName + ", starting Now.");
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                log.info("Do not know how to start: " + browserName + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;

        }
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        return driver;
    }



}
