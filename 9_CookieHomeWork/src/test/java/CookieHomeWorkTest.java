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
    public void shouldReturnCorrectNumberOfCookiesAfterPageLoad() {
        //given
        int ExpectedCookiesNumber = 4;

        //when
        waitOneSecond();
        Set<Cookie> TestPageCookies = WebPageDriver.manage().getCookies();

        //then
        Assertions.assertEquals(ExpectedCookiesNumber, TestPageCookies.size());
    }

    @Test
    void shouldReturnTrueIfTestCookieWasAddedToTestPage() {
        //given
        String TestCookieName = "test_cookie";
        Cookie TestCookie = new Cookie(TestCookieName, "test_value");

        //when
        WebPageDriver.manage().addCookie(TestCookie);

        //then
        Assertions.assertNotNull(WebPageDriver.manage().getCookieNamed(TestCookieName));
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
