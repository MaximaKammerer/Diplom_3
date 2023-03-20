import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BasicSettings {

    @BeforeEach
    public void init() {

        //Раскоменнтировать нужную строку в зависимоти от того, какой браузер необходим.
        //Configuration.browser = "Yandex";
        Configuration.browser="chrome";
        //Configuration.browser="edge";

    }
}
