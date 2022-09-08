import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class DeleteUserFromTheList {

    WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://yandex.ru/";
    private final static String PAGE_AFTER_DELETE_URL = "https://passport.yandex.ru/auth/list?origin=home_yandexid&retpath=https%3A%2F%2Fyandex.ru&backpath=https%3A%2F%2Fyandex.ru&mode=edit";

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
                .typeCorrectLogin("alexand3r.alt.testing")
                .typeCorrectPassword("lalalandik142536")
                .exitFromAccount()
                .clickOnTheLogInButtonPassword()
                .goToCurrentUser()
                .deleteUserFromTheList();


        Assertions.assertEquals(driver.getCurrentUrl(), PAGE_AFTER_DELETE_URL);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
