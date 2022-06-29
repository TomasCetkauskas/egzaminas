import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogOutTest extends BaseTest {
    LoginPage LoginPage = new LoginPage(driver);

    @Test
    void user() {
        LoginPage.fillUsername(userName);
        LoginPage.fillPassword(validPassword);
        LoginPage.clickSubmit();
        //WaitUnits.waitForElement(driver, LoginPage.successAlert);
        LoginPage.clickLogout();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:8080/prisijungti?logout", URL);
    }
}
