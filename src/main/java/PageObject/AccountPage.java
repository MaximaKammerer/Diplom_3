package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    // локатор поля логотип stellar burger
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBurger;

    // локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH,using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement buttonPersonalArea;

    // локатор кнопки контруктор
    @FindBy(how = How.XPATH,using = "//*[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    // локатор кнопки офромить заказ
    @FindBy(how = How.XPATH,using = "//*[text()='Оформить заказ']")
    private SelenideElement buttonCheckout;

    // локатор кнопки сохранить
    @FindBy(how = How.XPATH,using = "//*[text()='Сохранить']")
    private SelenideElement buttonSave;

    // локатор кнопки выйти
    @FindBy(how = How.XPATH,using = "//button[text()='Выход']")
    private SelenideElement buttonExit;

    // локатор кнопки Булки
    @FindBy(how = How.XPATH,using = "//span[text()='Булки']")
    private SelenideElement buttonBun;

    // локатор кнопки Соусы
    @FindBy(how = How.XPATH,using = "//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/child::*[text()='Соусы']")
    private SelenideElement buttonSauces;

    // локатор кнопки Начинки
    @FindBy(how = How.XPATH,using = "//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/child::*[text()='Начинки']")
    private SelenideElement buttonToppings;

    // Локатор выделенного раздела
    @FindBy(how = How.XPATH, using = "//div[@Class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement checkSection;

    //метод нажатия на кнопку "Личный кабинет"
    public void clickButtonPersonalArea () {

        buttonPersonalArea.click();

    }

    //Прверка перехода в личный кабинет
    public AccountPage checkPersonalArea () {

        buttonSave.shouldBe(Condition.visible);
        return this;

    }

    //метод нажатия на кнопку "Констурктор"
    public void clickButtonConstructor () {

        buttonConstructor.click();

    }

    //Прверка перехода по конопке конструктор
    public AccountPage checkConstructor () {

        buttonCheckout.shouldBe(Condition.visible);
        return this;

    }

    //метод нажатия на логотип
    public void clickLogoBurger () {

        logoBurger.click();

    }

    //метод нажатия на кнопку булки
    public void clickButtonBun () {

        buttonBun.click();

    }

    //метод нажатия на кнопку соусы
    public void clickButtonSauces () {

        buttonSauces.click();

    }

    //метод нажатия на кнопку начинки
    public void clickButtonToppings () {

        buttonToppings.click();

    }

    //Прверка перехода к выбранному разделу
    public AccountPage checkSection(String text) {

        checkSection.shouldHave(Condition.text(text));
        return this;

    }

    //метод нажатия на кнопку выход
    public void clickButtonExit () {

        buttonExit.click();

    }
}
