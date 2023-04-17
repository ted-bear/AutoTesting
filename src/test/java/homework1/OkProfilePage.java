package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class OkProfilePage extends LoadableComponent<OkProfilePage> {

    private final String LOCATOR_FOR_POST_NAME = ".group-link.o";
    private final String LOCATOR_FOR_GET_NAME = ".//div[contains(@data-l, 'fP,1,fD')]//div[contains(@class, 'vid-card')]";
    private final String LOCATOR_FOR_GET_DATE = ".feed_date";
    private final String LOCATOR_FOR_PROFILE_NAME = ".//div[@class='nav-side_i-w']";
    private static final By MEDIA_BLOCK = By.id("hook_Block_Navigation");


    public SelenideElement getPostName() {
        return $(LOCATOR_FOR_POST_NAME);
    }

    public SelenideElement getPost() {
        return $x(LOCATOR_FOR_GET_NAME);
    }

    public SelenideElement getPostDate() {
        return $(LOCATOR_FOR_GET_DATE);
    }

    public SelenideElement getProfileName() {
        return $x(LOCATOR_FOR_PROFILE_NAME);
    }

    public void exitProfile() {
        SelenideElement elem = $x(".//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
        elem.shouldBe(Condition.visible).click();
        SelenideElement exit = $x(".//div[@class='toolbar_accounts-user-delete-button']");
        exit.shouldBe(Condition.visible).click();
        SelenideElement okButton = $x("//input[@class='button-pro form-actions_yes']");
        okButton.shouldBe(Condition.visible).click();
    }

    @Override
    protected void load() {
        $(MEDIA_BLOCK).shouldBe(Condition.visible.because("не отобразилась колонка меню"));
    }

    @Override
    protected void isLoaded() throws Error {
        $(MEDIA_BLOCK).shouldBe(Condition.visible);

    }
}
