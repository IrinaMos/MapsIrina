import Constants.Constants;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class GooglePage extends Constants {
    protected WebDriver driver;
    //-------SignUP function---------------------------------------------------
    public static void clickSearch(WebDriver driver) {
        driver.findElement(Constants.INPUT).click();
        driver.findElement(Constants.INPUT).sendKeys("Irina");
        driver.findElement(Constants.ICON).click();
    }
}
