import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class InvalidLoginAuthCheck {

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
                .typeIncorrectLogin("TestingTestToTest");

        Assertions.assertTrue(driver.findElement(By.xpath(AuthorizationLoginPage.incorrectAccountErrorXpath)).isDisplayed());
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
