package testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assignment0703 extends testCase{

    /* Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
    @Test
    public void test01(){

        driver01.get("https://practicetestautomation.com/practice-test-login/");
        driver01.findElement(By.id("username")).sendKeys("student");
        driver01.findElement(By.id("password")).sendKeys("incorrectPassword");
        driver01.findElement(By.id("submit")).click();

        By errorMessage = By.id("error");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver01.findElement(errorMessage).isDisplayed());
        softAssert.assertEquals(driver01.findElement(errorMessage).getText(), "Your password is invalid!");

        softAssert.assertAll();

}
}
