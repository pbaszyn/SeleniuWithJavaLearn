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
    public void TitleAssertionTestWithSomeNavigation() {

        driver.navigate().to("http://wikipedia.pl");
        driver.navigate().to("http://nasa.gov");
        driver.navigate().back();

        String wikiPageTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(wikiPageTitle, driver.getTitle(), "The title of the page is not " + wikiPageTitle);

        driver.navigate().forward();

        String nasaPageTitle = "NASA";
        Assertions.assertEquals(nasaPageTitle, driver.getTitle(), "The title of the page is not " + nasaPageTitle);

    }

    @Test
    void shouldReturnSameURL4adressWithoutWWW() {
        //given
        String onetURL = "https://www.onet.pl/";

        //when
        driver.navigate().to("https://onet.pl");

        //then
        Assertions.assertEquals(onetURL, driver.getCurrentUrl(), "Current URL is not: " + onetURL);
    }

    @Test
    void shouldReturnCorrectPageTitle() {
        //given
        String wpTitle = "Wirtualna Polska - Wszystko co ważne - www.wp.pl";

        //when
        driver.navigate().to("https://www.wp.pl");

        //then
        Assertions.assertEquals(wpTitle, driver.getTitle(), "Current title is not: " + wpTitle);
    }

    @Test
    void shouldFindPictureULRinPageSource() {
        //given
        String picURL = "/static/images/footer/wikimedia-button.png";

        //when
        driver.navigate().to("https://pl.wikipedia.org/");

        //then
        Assertions.assertTrue(driver.getPageSource().contains(picURL), "Picture not found in page source - pic URL: " +picURL);
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
