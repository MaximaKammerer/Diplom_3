package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    // локатор поля Имя
    @FindBy(how = How.XPATH,using = "//*[text()='Имя']/following-sibling::*")
    private SelenideElement nameFild;

    // локатор поля Email
    @FindBy(how = How.XPATH,using = "//*[text()='Email']/following-sibling::*")
    private SelenideElement emailFild;

    // локатор поля пароль
    @FindBy(how = How.XPATH,using = "//*[text()='Пароль']/following-sibling::*")
    private SelenideElement passwordFild;

    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = "//*[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//*[text()='Вход']")
    private SelenideElement comeIn;

    // локатор надписи "не корректный пароль"
    @FindBy(how = How.XPATH,using = "//*[text()='Некорректный пароль']")
    private SelenideElement incorrectPassword;

    // локатор ссылки "Войти"
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement linkComeIn;

    public void registration (String name, String email, String password) {

        nameFild.setValue(name);
        emailFild.setValue(email);
        passwordFild.setValue(password);
        registerButton.click();

    }

    public void clickRegistrationLink() {

        linkComeIn.click();

    }

    public RegistrationPage checkPasswordError () {

        incorrectPassword.shouldBe(Condition.visible);
        return this;

    }

    public RegistrationPage checkRegistration () {

        comeIn.shouldBe(Condition.visible);
        return this;

    }
}
