package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

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

    @Test
    public void postNameHasSomething() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("some value");
        results.getPassword().setValue("some value");
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        String postName = profile.getPostName().getText();

        assertThat(postName, equalToIgnoringCase("образовательный центр vk в политехе"));

    }

    @Test
    public void postAddedBeforeToday() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("some value");
        results.getPassword().setValue("some value");
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        String str = profile.getPostDate().getText().split(" ")[0];
        int postName = Integer.parseInt(str);

        assertThat(postName, lessThanOrEqualTo(23));
    }

    @Test
    public void hasVideo() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("some value");
        results.getPassword().setValue("some value");
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        assertThat(profile.getPost(), CustomMatcher.postHasVideo());
    }
}
