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
