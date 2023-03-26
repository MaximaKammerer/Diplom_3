import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void openPage () {

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        loginPage = page(LoginPage.class);
        registrationPage = page(RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @Test
    @DisplayName("Позитивная проверка регистрации пользователя")
    public void registrationUser () {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.registration(NAME, EMAIL, PASSWORD);
        registrationPage.checkRegistration();

    }

    @Test
    @DisplayName("Негативная проверка регистрации пользователя с не корреткным паролем")
    public void registrationUserWithIncorrectPassword () {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.registration(NAME, EMAIL, NOTCORRECTPASSWORD);
        registrationPage.checkPasswordError();

    }
}
