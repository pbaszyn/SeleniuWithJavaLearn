import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieHomeWorkTest {

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
}
