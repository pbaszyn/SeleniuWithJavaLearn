import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitleSourceURLTest {

    private WebDriver WebPageDriver;

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

    @Test
    public void shouldReturnCorrectPageTitleAndURLBeforeAndAfterPageLanguageChange()
    {

        //given
        String TestPageURL = "http://wikipedia.pl/";
        String PolishPageTitle = "Wikipedia, wolna encyklopedia";
        String PolishPageURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        String PolishPageSourceLanguage = "<html class=\"client-js ve-available\" lang=\"pl\" dir=\"ltr\">";

        String SpanishPageTitle = "Wikipedia, la enciclopedia libre";
        String SpanishPageURL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        String SpanishPageSourceLanguage = "<html class=\"client-js ve-not-available\" lang=\"es\" dir=\"ltr\">";

        //when
        WebPageDriver.navigate().to(TestPageURL);

        //then
        Assertions.assertEquals(PolishPageTitle, WebPageDriver.getTitle(), "Page title doesn't match to:" + PolishPageTitle);
        Assertions.assertEquals(PolishPageURL, WebPageDriver.getCurrentUrl(), "Page URL doesn't match to:" + PolishPageURL);
        Assertions.assertTrue(WebPageDriver.getPageSource().contains(PolishPageSourceLanguage), "Page Source doesn't contain correct language info: " +PolishPageSourceLanguage);

    }


}
