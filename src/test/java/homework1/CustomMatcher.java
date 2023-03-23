package homework1;

import com.codeborne.selenide.SelenideElement;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatcher extends TypeSafeMatcher<SelenideElement> {
    @Override
    protected boolean matchesSafely(SelenideElement post) {
        return post.exists();
    }

    @Factory
    public static Matcher<SelenideElement> postHasVideo() {
        return new CustomMatcher();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has a video");
    }
}
