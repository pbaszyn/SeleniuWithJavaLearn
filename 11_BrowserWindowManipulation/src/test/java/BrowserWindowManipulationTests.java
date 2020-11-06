import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class BrowserWindowManipulationTests {

    private WebDriver WebPageDriver;
    private String WikiPageURL = "https://pl.wikipedia.org/";

    @Test
    public void shouldReturnCorrectBrowserWindowPositionAndSize() {
        //given
        Dimension BrowserWindowDimensions = new Dimension(845, 480);
        Point BrowserWindowPosition = new Point(445, 30);

        //when
        WebPageDriver.manage().window().setPosition(BrowserWindowPosition);
        WebPageDriver.manage().window().setSize(BrowserWindowDimensions);
        waitOneSecond();

        //then
        Assertions.assertEquals(BrowserWindowDimensions, WebPageDriver.manage().window().getSize());
        Assertions.assertEquals(BrowserWindowPosition, WebPageDriver.manage().window().getPosition());
    }

    @BeforeEach
    public void WebPageDriverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebPageDriver = new ChromeDriver();
        WebPageDriver.navigate().to(WikiPageURL);
    }

    @AfterEach
    public void cleanAfterTest(){
        WebPageDriver.close();
        WebPageDriver.quit();
    }

    private void waitOneSecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
