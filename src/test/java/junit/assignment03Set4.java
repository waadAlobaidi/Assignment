package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class assignment03Set4 extends testCase{
    @Test
    public void keyboardActions01() throws InterruptedException{

        // go to https://www.google.com/
        driver4.get("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object
        Actions act = new Actions(driver4);
        By searchBox = By.id("APjFqb");
        act.moveToElement(driver4.findElement(searchBox)).click().sendKeys("Scroll Methods").sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

    }


}
