package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class assignment01Set4 extends testCase {
    @Test
    public void winTest(){
        // Go to URL: https://the-internet.herokuapp.com/windows
        driver4.get("https://the-internet.herokuapp.com/windows");

        // Verify the text: “Opening a new window”
        String newWindow = driver4.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Opening a new window", newWindow);

        // Verify the title of the page is “The Internet”
        Assertions.assertEquals("The Internet", driver4.getTitle());

        // Click on the “Click Here” button
        driver4.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //Verify the new window title is “New Window”
        var orginHandle = driver4.getWindowHandle();
        Set<String> handles = driver4.getWindowHandles();
        handles.remove(orginHandle);
        String newHandel = (String) handles.toArray()[0];
        driver4.switchTo().window(newHandel);

        //Verify the new window title is “New Window”
        String newWindowTitle =  driver4.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("New Window", newWindowTitle);


        // Go back to the previous window and then verify the title: “The Internet”
        driver4.switchTo().window(orginHandle);
        String originWindow = driver4.getTitle();
        Assertions.assertEquals("The Internet", originWindow);

    }
}

