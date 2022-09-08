import Helper.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class AuthWithSavedUser {

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
        new MainPage(driver) //Для начала авторизовываемся и выходим из аккаунта для того, чтобы информация сохранилась
                .clickOnTheLogInButtonLogin()
                .typeCorrectLogin("alexand3r.alt.testing")
                .typeCorrectPassword("lalalandik142536")
                .exitFromAccount()
                .clickOnTheLogInButtonPassword()//И снова заходим уже к предложенному юзеру
                .typeCorrectPassword("lalalandik142536");

        Assertions.assertTrue(driver.findElement(By.xpath(MainPage.loggedUserCheckXpath)).isDisplayed());
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
