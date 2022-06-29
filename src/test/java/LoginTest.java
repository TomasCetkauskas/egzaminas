import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class LoginTest extends BaseTest {

    LoginPage LoginPage = new LoginPage(driver);

    @Test
    void userCanLoginWithValidData() {
        LoginPage.fillUsername(userName);
        LoginPage.fillPassword(validPassword);
        LoginPage.clickSubmit();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:8080/", URL,
                "Prisijungti pavyko!");
    }

    @Test
    void userCannotLoginWithInvalidData() {
        LoginPage.fillUsername(userName);
        LoginPage.fillPassword(invalidPassword);
        LoginPage.clickSubmit();
        WebElement passwordIncorrectError = driver.findElement(By.cssSelector("body > div > form > div > button"));
        Assertions.assertTrue(passwordIncorrectError.isDisplayed(), "Registered with invalid password!");

    }
}