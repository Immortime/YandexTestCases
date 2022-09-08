import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPage extends BasePageObject {

    public UserListPage(WebDriver driver) {
        super(driver);
    }

    private final static String buttonContextMenuXpath = "//button[@class='ContextMenuButton']";
    private final static String buttonDeleteFromTheListXpath = "//button[@class='ContextMenu-button']";

    @FindBy(xpath = buttonContextMenuXpath)
    WebElement buttonContextMenu;

    @FindBy(xpath = buttonDeleteFromTheListXpath)
    WebElement buttonDeleteFromTheList;

    public AuthorizationLoginPage deleteUserFromTheList() {
        buttonContextMenu.click();
        buttonDeleteFromTheList.click();
        return new AuthorizationLoginPage(driver);
    }
}
