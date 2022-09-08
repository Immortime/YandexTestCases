import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationLoginPage extends BasePageObject {

    public AuthorizationLoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String buttonToMailLoginCss = ".Button2_view_clear";
    private final static String inputLoginXpath = "//input[@id='passp-field-login']";
    private final static String buttonSignInXpath = "//button[@id='passp:sign-in']";
    public final static String incorrectAccountErrorXpath = "//div[contains(text(), 'Такого аккаунта нет')]";
    private final static String buttonExitFromAuthXpath = "//a[contains(@class, 'PreviousStepButton')]";
    private final static String inputPhoneXpath = "//input[@id='passp-field-phone']";
    public final static String incorrectLoginErrorXpath = "//div[contains(text(), 'Такой логин')]";

    //В Опере это было нужно, а в гугл работает по другому -> окружение тестирования разные
    @FindBy(css = buttonToMailLoginCss)
    WebElement buttonToMailLogin;

    @FindBy(xpath = inputLoginXpath)
    WebElement inputLogin;

    @FindBy(xpath = buttonSignInXpath)
    WebElement buttonSignIn;

    @FindBy(xpath = buttonExitFromAuthXpath)
    WebElement buttonExitFromAuth;

    public AuthorizationPasswordPage typeCorrectLogin(String name) {
        try {
            inputLogin.sendKeys(name);
            buttonSignIn.click();
            return new AuthorizationPasswordPage(driver);
        }catch(NoSuchElementException ex) {
            buttonToMailLogin.click();
            inputLogin.sendKeys(name);
            buttonSignIn.click();
            return new AuthorizationPasswordPage(driver);
        }
    }

    public AuthorizationLoginPage typeIncorrectLogin(String name) {
        try {
            inputLogin.sendKeys(name);
            buttonSignIn.click();
            return new AuthorizationLoginPage(driver);
        }catch (NoSuchElementException ex) {
            buttonToMailLogin.click();
            inputLogin.sendKeys(name);
            buttonSignIn.click();
            return new AuthorizationLoginPage(driver);
        }
    }

    public MainPage exitFromAuth() {
        buttonExitFromAuth.click();
        return new MainPage(driver);
    }
}
