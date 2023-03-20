package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH,using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalArea;

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement ToComeIn;

    public void clickButtonPersonalArea () {

        personalArea.click();

    }

    public void clickButtonLogin() {

        ToComeIn.click();

    }
}
