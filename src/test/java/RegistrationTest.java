import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest extends BasicSettings {

    private final String NAME = "Ganzalis2352";
    private final String EMAIL = NAME + "@yandex.ru";
    private final String PASSWORD = "123456";
    private final String NOTCORRECTPASSWORD = "123";
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @BeforeEach
    public void openPage () {

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        loginPage = page(LoginPage.class);
        registrationPage = page(RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @Test
    @DisplayName("Позитивная проверка регистрации пользователя")
    public void RegistrationUser () {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.registration(NAME, EMAIL, PASSWORD);
        registrationPage.checkRegistration();

    }

    @Test
    @DisplayName("Негативная проверка регистрации пользователя с не корреткным паролем")
    public void RegistrationUserWithIncorrectPassword () {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.registration(NAME, EMAIL, NOTCORRECTPASSWORD);
        registrationPage.checkPasswordError();

    }
}
