package testng;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class assignment0702 extends testCase {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report


    @Test( dataProvider = "getData" )
    @Step("Test login")
    public void testLogin(String username, String password) throws InterruptedException {
        driver01.navigate().to("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver01, Duration.ofSeconds(8));



        wait.until(f -> {
            driver01.findElement(By.name("username")).sendKeys(username);
            return true;
        });

        driver01.findElement(By.name("password")).sendKeys(password);
        driver01.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(f -> {

            WebElement invalidMessage = driver01.findElement(By.cssSelector("div[role='alert']"));
            Assert.assertEquals(invalidMessage.getText(), "Invalid credentials");
            return true;
        });

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"}
        };
    }}

