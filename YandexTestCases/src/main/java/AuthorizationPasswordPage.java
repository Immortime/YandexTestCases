import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPasswordPage extends BasePageObject {

    //URL меняется, поэтому создаю эту страницу отдельно
    public AuthorizationPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final static String inputPasswordXpath = "//input[@id='passp-field-passwd']";
    private final static String buttonSignInXpath = "//button[@id='passp:sign-in']";
    private final static String buttonTogglePswrdXpath = "//button[@id='password-toggle']";
    public final static String incorrectAccountErrorXpath = "//div[contains(text(), 'Неверный пароль')]";
    private final static String buttonCurrentUserXpath = "//a[@class='CurrentAccount']";

    @FindBy(xpath = inputPasswordXpath)
    WebElement inputPassword;

    @FindBy(xpath = buttonSignInXpath)
    WebElement buttonSignIn;

    @FindBy(xpath = buttonTogglePswrdXpath)
    WebElement buttonTogglePswrd;

    @FindBy(xpath = buttonCurrentUserXpath)
    WebElement buttonCurrentUser;

    public MainPage typeCorrectPassword(String name) {
        inputPassword.sendKeys(name);
        buttonSignIn.click();
        return new MainPage(driver);
    }

    public AuthorizationPasswordPage typeIncorrectPassword(String name) {
        inputPassword.sendKeys(name);
        buttonSignIn.click();
        return new AuthorizationPasswordPage(driver);
    }

    public AuthorizationPasswordPage togglePasswordView(String name) {
        inputPassword.sendKeys(name);
        buttonTogglePswrd.click();
        return new AuthorizationPasswordPage(driver);
    }

    public MainPage passwordSafetyCheck(String name) {
        inputPassword.sendKeys(name);
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.CONTROL + "c");
        inputPassword.click();
        inputPassword.sendKeys(Keys.CONTROL + "v");
        buttonSignIn.click();
        return new MainPage(driver);
    }

    public UserListPage goToCurrentUser() {
        buttonCurrentUser.click();
        return new UserListPage(driver);
    }
}
