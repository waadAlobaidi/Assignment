package junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public abstract class testCase {
    protected WebDriver driver4;
    protected Wait<WebDriver> wait;
    public static Logger logger;

    @BeforeAll
    public static void beforeAll(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(testCase.class.getName());
    }


    @BeforeEach
    public void BeforeEach(){
        logger.info("Opening Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver4 = new ChromeDriver(chromeOptions);
        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver4, Duration.ofSeconds(10));

    }


    @AfterEach
    public void afterEach(){
        logger.info("Quitting Browser");
        driver4.quit();
    }
}
