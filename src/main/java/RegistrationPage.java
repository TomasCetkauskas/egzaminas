import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameRegisterInput;

    @FindBy (id = "password")
    private WebElement passwordRegisterInput;

    @FindBy (id = "passwordConfirm")
    private WebElement passwordConfirmInput;

    @FindBy (css = "#userForm > button")
    private WebElement submitButton;

    public RegistrationPage( WebDriver driver) { super(driver); }

    public void fillUsername(String username) { usernameRegisterInput.sendKeys(username); }
    public void fillPassword(String password) { passwordRegisterInput.sendKeys(password); }
    public void fillPasswordConfirm(String passwordConfirm) { passwordConfirmInput.sendKeys(passwordConfirm); }
    public void clickSubmit() { submitButton.click();}
}
