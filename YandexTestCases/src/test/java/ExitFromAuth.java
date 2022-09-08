import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ExitFromAuth {

    WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://yandex.ru/";

    @BeforeAll
    static void startDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
    }

    @Test
    @Tag("Authorization")
    void Test() {
        new MainPage(driver)
                .clickOnTheLogInButtonLogin()
                .exitFromAuth();

        Assertions.assertEquals(driver.getCurrentUrl(), MAIN_PAGE_URL);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
