package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(@Optional("Chrome") String browserName , ITestContext ctx){
        log = LogManager.getLogger(ctx.getCurrentXmlTest().getSuite().getName());
        driver = new BrowserDriverFactory(browserName, log).createDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        log.info("Close driver");
        driver.quit();
    }


}
