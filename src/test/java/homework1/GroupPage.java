package homework1;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class GroupPage extends LoadableComponent<GroupPage> {
    private static final By MEDIA_BLOCK = By.xpath(".//*[@class='main-content-header_data_nav-menu']");

    public int getNumOfThemes() {
        return Integer.parseInt($x(".//a[contains(text(), 'Темы')]//span[@class='navMenuCount']").getText());
    }

    @Override
    protected void load() {
        $(MEDIA_BLOCK).shouldBe(Condition.visible.because("не отобразилась колонка меню"));
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("Groups didn't load", $(MEDIA_BLOCK).exists());
    }
}
