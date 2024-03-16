package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assignment04Set4 extends testCase{
    @Test
    public void robot01()throws AWTException, InterruptedException{
//        Go to Amazon
        driver4.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

//        Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.mouseWheel(23);
        Thread.sleep(5000);

//        Click on the "Back to top" web element
        driver4.findElement(By.id("navBackToTop")).click();

//        Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        JavascriptExecutor javaScEx = (JavascriptExecutor) driver4;
        WebElement logo = driver4.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
        javaScEx.executeScript("arguments[0].click();", logo);

//        Use Actions to type "ClarusWay" in the search box and perform the search
        Actions searchType = new Actions(driver4);
        By searchBox = By.id("twotabsearchtextbox");
        searchType.moveToElement(driver4.findElement(searchBox)).click().sendKeys("ClarusWay").perform();
        Thread.sleep(4000);




    }
}
