import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static String logInButtonXpath = "//a[contains(@data-statlog, 'notifications.mail.logout.enter')]";
    public final static String loggedUserCheckXpath = "//a[contains(@class, 'home-link usermenu-link__control home-link_black_yes')]";
    private final static String profileActionsListXpath = "//a[contains(@data-statlog, 'notifications.mail.login.usermenu.toggle')]";
    private final static String buttonExitFromAccountXpath = "//a[@data-statlog='mail.login.usermenu.exit']";

    //Спорный момент. Можно использовать типы Button, TextField, но это еще 1 обьект в памяти, но оба варианты хороши по своему
    @FindBy(xpath = logInButtonXpath)
    WebElement logInButton;

    @FindBy(xpath = profileActionsListXpath)
    WebElement profileActionsList;

    @FindBy(xpath = buttonExitFromAccountXpath)
    WebElement buttonExitFromAccount;

    public AuthorizationLoginPage clickOnTheLogInButtonLogin() {
        logInButton.click();
        return new AuthorizationLoginPage(driver);
    }

    public AuthorizationPasswordPage clickOnTheLogInButtonPassword() {
        logInButton.click();
        return new AuthorizationPasswordPage(driver);
    }

    public MainPage exitFromAccount() {
        profileActionsList.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonExitFromAccountXpath)));
        buttonExitFromAccount.click();
        return new MainPage(driver);
    }


}
