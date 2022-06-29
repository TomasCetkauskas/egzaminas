import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Test
    void newUserCanRegisterWithValidData() {
        driver.get("http://localhost:8080/registruoti");
        String userName = "vartotojas" + RandomStringUtils.random(6, true, true);
        registrationPage.fillUsername(userName);
        registrationPage.fillPassword(validPassword);
        registrationPage.fillPasswordConfirm(validPassword);
        registrationPage.clickSubmit();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/skaiciuotuvas",
                "Registracija pavyko!");

    }

    @Test
    void newUserCanNotRegisterWithInvalidData() {
        driver.get("http://localhost:8080/registruoti");
        String userName = "vartotojas" + RandomStringUtils.random(6, true, true);
        registrationPage.fillUsername(userName);
        registrationPage.fillPassword(validPassword);
        registrationPage.fillPasswordConfirm(invalidPassword);
        registrationPage.clickSubmit();
        WebElement passwordConfirmError = driver.findElement(By.id("passwordConfirm.errors"));
        Assertions.assertTrue(passwordConfirmError.isDisplayed(), "Registered with invalid password!");

    }
}
