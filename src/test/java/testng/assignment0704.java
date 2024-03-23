package testng;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assignment0704 extends testCase{
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Mac"},
                {"Ipad"},
                {"Samsung"},

        };
    }

    @Test(dataProvider = "getData")
    public void dataProviderClass(String word)  {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        driver01.findElement(By.xpath("//input[contains(@id,'input-email')]")).sendKeys("clarusway@gmail.com" );
        driver01.findElement(By.xpath("//input[contains(@id,'input-password')]")).sendKeys("123456789");
        driver01.findElement(By.xpath("//input[@value='Login']")).click();

        driver01.findElement(By.xpath("//input[contains(@name,'search')]")).sendKeys(word+ Keys.ENTER);

        WebElement inText = driver01.findElement(By.xpath("//div[contains(@class,'oxd-alert-content--error')]"));
        Assert.assertTrue(inText.isDisplayed());




    }
}
