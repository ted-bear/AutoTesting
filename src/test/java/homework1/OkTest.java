package homework1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OkTest {

    private static OkProfilePage profile;
    private static final String EMAIL = "****";
    private static final String PASSWORD = "****";

    @Before
    public void setUp() {
        open("http://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.setEmail(EMAIL);
        results.setPassword(PASSWORD);
        results.clickButtonToLogIn();
        profile = new OkProfilePage();
    }

    @After
    public void exitProfile() {
        profile.exitProfile();
    }

    @Test
    public void userCanSearch() {
        String profileName = profile.getProfileName().getText();
        assertEquals("Егор Топорков", profileName);
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
        OkGroupsPage groupsPage = OkGroupsPage.getGroupMenu();
        GroupPage groupPage = groupsPage.getGroup();
        assertTrue("Количество тем в группе меньше 300", groupPage.getNumOfThemes() > 300);
    }
}
