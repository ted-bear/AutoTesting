package homework1;

import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {
    private static final Logger LOGGER = Logger.getLogger("Страница входа");
    public static final SelenideElement EMAIL_FIELD = $("#field_email");
    public static final SelenideElement PASSWORD_FIELD = $("#field_password");
    public static final SelenideElement LOG_IN_BUTTON = $(".button-pro.__wide");

    public void setEmail(String email) {
        EMAIL_FIELD.setValue(email);
    }

    public void setPassword(String password) {
        PASSWORD_FIELD.setValue(password);
    }

    public void clickButtonToLogIn() {
        LOG_IN_BUTTON.click();
    }
}
