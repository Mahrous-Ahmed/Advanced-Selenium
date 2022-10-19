package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loggedInSuccessfullyPage extends BasePageObject {

    private String url =  "https://practicetestautomation.com/logged-in-successfully/";

    private By logOutButton = By.xpath("//a[text()='Log out']");

    public loggedInSuccessfullyPage(WebDriver webDriver, Logger log) {
        super(webDriver, log);
    }

    public void logOut(){
        click(logOutButton);
    }

    public String getUrl() {
        return url;
    }
}
