import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AccountPageTest extends BasicSettings {

    private final String EMAL = "Ganzalis23@yandex.ru";
    private final String PASSWORD = "123456";
    private MainPage mainPage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @BeforeEach
    public void openPage () {

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        loginPage = page(LoginPage.class);
        accountPage = page(AccountPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        mainPage.clickButtonLogin();
        loginPage.authorization(EMAL, PASSWORD);
        loginPage.checkAuthorization();

    }

    @AfterEach
    public void tearDown() {

        getWebDriver().quit();

    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goPersonalAccount () {

        accountPage.clickButtonPersonalArea();
        accountPage.checkPersonalArea();

    }

    @Test
    @DisplayName("Переход по нажатию на кнопку Конструктор")
    public void goConstructor () {

        accountPage.clickButtonPersonalArea();
        accountPage.checkPersonalArea();
        accountPage.clickButtonConstructor();
        accountPage.checkConstructor();

    }

    @Test
    @DisplayName("Переход по нажатию на логотип")
    public void goConstructorClickingOnLogo () {

        accountPage.clickButtonPersonalArea();
        accountPage.checkPersonalArea();
        accountPage.clickLogoBurger();
        accountPage.checkConstructor();

    }

    @Test
    @DisplayName("Переход к разделу булки")
    public void goBun () {

        accountPage.clickButtonToppings();
        accountPage.checkSection("Начинки");
        Selenide.sleep(300);
        accountPage.clickButtonBun();
        accountPage.checkSection("Булки");

    }

    @Test
    @DisplayName("переход к разделу соусы")
    public void goSauces () {

        accountPage.clickButtonToppings();
        accountPage.checkSection("Начинки");
        accountPage.clickButtonSauces();
        accountPage.checkSection("Соусы");

    }

    @Test
    @DisplayName("переход к разделу начинки")
    public void goToppings() {

        accountPage.clickButtonToppings();
        accountPage.checkSection("Начинки");

    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void goExit () {

        accountPage.clickButtonPersonalArea();
        accountPage.clickButtonExit();
        loginPage.checkExit();

    }
}
