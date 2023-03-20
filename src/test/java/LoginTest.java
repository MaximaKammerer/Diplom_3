import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTest extends BasicSettings {

    private final String EMAIL = "Ganzalis23@yandex.ru";
    private final String PASSWORD = "123456";
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

    @AfterEach
    public void tearDown() {

        getWebDriver().quit();

    }

    @Test
    @DisplayName("Авторизация через кнопку Входа")
    public void AuthorizationThroughButtonLogin () {

        mainPage.clickButtonLogin();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку Личный кабинет")
    public void AuthorizationThroughButtonPersonalAccount () {

        mainPage.clickButtonPersonalArea();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку на форме авторизации")
    public void AuthorizationThroughButtonOnAuthorizationForm() {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.clickRegistrationLink();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку Восстановление пароля")
    public void AuthorizationThroughButtonPasswordRecovery() {

        mainPage.clickButtonPersonalArea();
        loginPage.clickPasswordRecoveryLink();
        loginPage.clickComeIn();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }
}
