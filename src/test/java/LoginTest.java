import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
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

    @Before
    public void openPage () {

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        loginPage = page(LoginPage.class);
        registrationPage = page(RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @After
    public void tearDown() {

        getWebDriver().quit();

    }

    @Test
    @DisplayName("Авторизация через кнопку Входа")
    public void authorizationThroughButtonLogin () {

        mainPage.clickButtonLogin();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку Личный кабинет")
    public void authorizationThroughButtonPersonalAccount () {

        mainPage.clickButtonPersonalArea();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку на форме авторизации")
    public void authorizationThroughButtonOnAuthorizationForm() {

        mainPage.clickButtonPersonalArea();
        loginPage.clickRegistrationLink();
        registrationPage.clickRegistrationLink();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @Test
    @DisplayName("Авторизация через кнопку Восстановление пароля")
    public void authorizationThroughButtonPasswordRecovery() {

        mainPage.clickButtonPersonalArea();
        loginPage.clickPasswordRecoveryLink();
        loginPage.clickComeIn();
        loginPage.authorization(EMAIL, PASSWORD);
        loginPage.checkAuthorization();

    }
}
