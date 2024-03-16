package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class assignment07Set4 extends testCase{
    @Test
    public void screenShot01() throws IOException {
        // Go to amazon.com
        driver4.get("https://www.amazon.com/alm/category/?almBrandId=QW1hem9uIEZyZXNo&node=16318751&ref=fs_dsk_sn_freshbreadsbake-ab05e");

        // Take Full Page Screenshot.
        File screenshot = ((TakesScreenshot) driver4).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("amazonScreenSHot.png"));

        // Take any spesific WebElement ScreenShot
        WebElement webElementScreenshot = driver4.findElement(By.id("navbar-main"));
        File spesificScreenShot =new File("spesificScreenShot.png");
        FileHandler.copy(webElementScreenshot.getScreenshotAs(OutputType.FILE), spesificScreenShot);
    }

}
