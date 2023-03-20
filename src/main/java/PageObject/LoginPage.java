package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // локатор поля Email
    @FindBy(how = How.XPATH,using = "//*[text()='Email']/following-sibling::*")
    private SelenideElement emailFild;

    // локатор поля пароль
    @FindBy(how = How.XPATH,using = "//*[text()='Пароль']/following-sibling::*")
    private SelenideElement passwordFild;

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement comeIn;

    // локатор ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationLink;

    // локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement restorePassword;

    // локатор кнопки оформить заказ
    @FindBy(how = How.XPATH,using = "//*[text() = 'Оформить заказ']")
    private SelenideElement checkoutButton;

    public void authorization (String email, String password) {

        emailFild.setValue(email);
        passwordFild.setValue(password);
        comeIn.click();

    }

    public void clickRegistrationLink() {

        registrationLink.click();

    }

    public void clickComeIn() {

        comeIn.click();

    }

    public void clickPasswordRecoveryLink() {

        restorePassword.click();

    }

    // проверка успешной авторизации
    public LoginPage checkAuthorization () {

        checkoutButton.shouldBe(Condition.visible);
        return this;

    }

    //Проверка успешного выхода
    public LoginPage checkExit() {

        comeIn.shouldBe(Condition.visible);
        return this;

    }
}
