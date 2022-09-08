import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ButtonViewPasswordCheck {

    WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://yandex.ru/";
    private final static String inputPasswordXpath = "//input[@id='passp-field-passwd']";

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
    void Test() {
        new MainPage(driver)
                .clickOnTheLogInButtonLogin()
                .typeCorrectLogin("alexand3r.alt.testing")
                .togglePasswordView("lalalandik142536");

        Assertions.assertEquals(driver.findElement(By.xpath(inputPasswordXpath))
                .getAttribute("type"), "text");
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
