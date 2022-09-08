import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class PasswordSafetyCheck {

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
                .typeCorrectLogin("alexand3r.alt.testing")
                .passwordSafetyCheck("lalalandik142536");

        Assertions.assertTrue(driver.findElement(By.xpath(MainPage.loggedUserCheckXpath)).isDisplayed());
        // Проверяем на переход на страницу, ведь если бы пароль скопировался -> выпала бы ошибка
        // Если включаете локально -> нужно очистить буфер обмена для этого теста
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
