package homework1;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void userCanSearch() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("teddi2x2@gmail.com");
        results.getPassword().setValue("cxm62qdRIEO");
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        profile.getProfileName().shouldHave(Condition.text("Егор Топорков"));
    }
}
