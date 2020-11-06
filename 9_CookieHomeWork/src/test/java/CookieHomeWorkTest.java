import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookieHomeWorkTest {

    private WebDriver WebPageDriver;
    private String WikiPageURL = "https://pl.wikipedia.org/";

    @Test
    public void shouldReturnCorrectNumberAfterPageLoad() {
        //given
        int ExpectedCookiesNumber = 4;

        //when
        WebPageDriver.navigate().to(WikiPageURL);
        Set<Cookie> TestPageCookies = WebPageDriver.manage().getCookies();
        waitOneSecond();

        //then
        Assertions.assertEquals(ExpectedCookiesNumber, TestPageCookies.size());
    }

    @Test
    void shouldReturnTrueIfTestCookieWasAddedToTestPage() {
        //given

        //when

        //then
    }

    @BeforeEach
    public void WebPageDriverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebPageDriver = new ChromeDriver();
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
