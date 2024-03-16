package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class assignment02Set4 extends testCase{
    /*
       Go to URL: http://demo.guru99.com/test/drag_drop.html
       Drag and drop the BANK button to the Account section in DEBIT SIDE
       Drag and drop the SALES button to the Account section in CREDIT SIDE
       Drag and drop the 5000 button to the Amount section in DEBIT SIDE
       Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
       Verify the visibility of Perfect text.
       */
    @Test
    public void mouseOprations(){

//        Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver4.get("http://demo.guru99.com/test/drag_drop.html");

//        Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankBtn= driver4.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement accountSec = driver4.findElement(By.id("shoppingCart1"));
        Actions act = new Actions(driver4);
        act.dragAndDrop(bankBtn , accountSec).perform();

//        Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesBtn = driver4.findElement(By.id("credit1"));
        WebElement accountSecCredit = driver4.findElement(By.id("shoppingCart3"));
        act.dragAndDrop(salesBtn, accountSecCredit).perform();

//        Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement fiveBtn = driver4.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
        WebElement amountSecCrdit = driver4.findElement(By.id("shoppingCart4"));
        act.dragAndDrop(fiveBtn,amountSecCrdit).perform();

//        Verify the visibility of Perfect text.
        WebElement perfectText = driver4.findElement(By.xpath("//a[text()='Perfect!']"));
        Assertions.assertTrue(perfectText.isDisplayed());


    }
}
