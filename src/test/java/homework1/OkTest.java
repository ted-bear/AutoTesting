package homework1;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertTrue;

public class OkTest {

    private static OkProfilePage profile;

    @Before
    public void setUp() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue("teddi2x2@gmail.com");
        results.getPassword().setValue("cxm62qdRIEO");
        results.getButtonToLogIn().click();
        profile = new OkProfilePage();
    }

    @After
    public void exitProfile() {
        profile.exitProfile();
    }

    @Test
    public void userCanSearch() {
        profile.getProfileName().shouldHave(Condition.text("Егор Топорков"));
    }

    @Test
    public void postNameHasSomething() {
        String postName = profile.getPostName().getText();

        assertThat(postName, equalToIgnoringCase("образовательный центр vk в политехе"));

    }

    @Test
    public void postAddedBeforeToday() {
        String str = profile.getPostDate().getText().split(" ")[0];
        int postName = Integer.parseInt(str);
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_MONTH);

        assertThat(postName, lessThanOrEqualTo(today));
    }

    @Test
    public void hasVideo() {
        assertThat(profile.getPost(), CustomMatcher.postHasVideo());
    }

    @Test
    public void themesMoreThanNum() {
        ColumnMenuItemWrapper wrapper = new ColumnMenuItemWrapper($x(".//*[@class='navigation']"));
        OkGroupsPage groupsPage = wrapper.clickOnItemMenu();
        GroupPage groupPage = groupsPage.getGroup();
        assertTrue("Количество тем в группе меньше 300", groupPage.getNumOfThemes() > 300);
    }
}
