import org.openqa.selenium.By;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AutoTest {

    @Test
    public void justStartTyping() {
        $("https://google.com");

    }
    @Test
    public void userCanLoginByUsername() {
        open("/login");
        $(By.name("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
    }
}
