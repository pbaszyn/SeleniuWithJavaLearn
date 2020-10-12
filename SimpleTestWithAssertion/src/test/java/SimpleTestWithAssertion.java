import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class SimpleTestWithAssertion {
    private WebDriver driver;

    @Test
    public void getTest(){

        driver.get("http://google.pl");
    }

    @Test
    public void TitleAssertionTest() {

        driver.navigate().to("http://wikipedia.pl");
        driver.navigate().to("http://nasa.gov");
        driver.navigate().back();

        String wikiPageTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(wikiPageTitle, driver.getTitle(), "The title of the page is not " + wikiPageTitle);

        driver.navigate().forward();

        String nasaPageTitle = "NASA";
        Assertions.assertEquals(nasaPageTitle, driver.getTitle(), "The title of the page is not " + nasaPageTitle);

    }

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void cleanAfterTest(){
        driver.close();
        driver.quit();
    }
}
