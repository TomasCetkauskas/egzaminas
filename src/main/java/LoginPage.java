import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameLoginInput;

    @FindBy (name = "password")
    private WebElement passwordLoginInput;

    @FindBy (css = "body > div > form > div > button")
    private WebElement submitButton;

    @FindBy (xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement logoutLink;

    @FindBy(xpath = "/html/body/nav/div/div/a")
    private WebElement successAlert;

    public LoginPage( WebDriver driver) { super(driver); }

    public void fillUsername(String username) { usernameLoginInput.sendKeys(username); }
    public void fillPassword(String password) { passwordLoginInput.sendKeys(password); }
    public void clickSubmit() { submitButton.click(); }
    public void clickLogout() { logoutLink.click(); }
}
