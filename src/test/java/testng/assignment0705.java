package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.
public class assignment0705 extends testCase {
    @Test
    @Parameters({"browser"})
    public void toDoApp(@Optional("chrome")String browser) {
        bot.navigate("http://crossbrowsertesting.github.io/");
        By toDoLink = By.xpath("//a[@href='todo-app.html']");
        bot.click(toDoLink);

        By toDo4 = By.name("todo-4");
        By toDo5 = By.name("todo-5");
//Checking Box to do-4 and Checking Box to do-5
        driver01.findElement(toDo4).click();
        driver01.findElement(toDo5).click();

//List should be have length 2.
        By toDoList = By.cssSelector(".done-true");
        int toDoListSize = driver01.findElements(toDoList).size();
        Assert.assertEquals(toDoListSize, 2);
// add a new item
        By todoInput = By.id("todotext");
        driver01.findElement(todoInput).sendKeys("running" + Keys.ENTER);
//Assert that the to do we added is present in the list
        Assert.assertTrue(driver01.findElement(By.xpath("(//span[@class='done-false'])[4]")).isDisplayed());

        By archiveLink = By.xpath("//a[@ng-click='todoList.archive()']");
        bot.click(archiveLink);

//        // Assert that the list has a length of 4 after archiving old todos
        By toDoLiatAfterArchiving = By.cssSelector(".done-false");
        int archivedListSize = driver01.findElements(toDoLiatAfterArchiving).size();
        Assert.assertEquals(archivedListSize, 4, "List size is 4 after archiving old todos");


    }
}