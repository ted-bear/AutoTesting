package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class OkProfilePage extends LoadableComponent<OkProfilePage> {

    private final String locForPostName = ".group-link.o";
    private final String locForGetPost = ".//div[contains(@data-l, 'fP,1,fD')]//div[contains(@class, 'vid-card')]";
    private final String locForGetPostDate = ".feed_date";
    private final String locForProfileName = ".//div[@class='nav-side_i-w']";
    private static final By MEDIA_BLOCK = By.id("hook_Block_Navigation");


    public SelenideElement getPostName() {
        return $(locForPostName);
    }

    public SelenideElement getPost() {
        return $x(locForGetPost);
    }

    public SelenideElement getPostDate() {
        return $(locForGetPostDate);
    }

    public SelenideElement getProfileName() {
        return $x(locForProfileName);
    }

    public void exitProfile() {
        SelenideElement elem = $x(".//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
        elem.click();
        SelenideElement exit = $x(".//div[@class='toolbar_accounts-user-delete-button']");
        exit.click();
        SelenideElement okButton = $x("//input[@class='button-pro form-actions_yes']");
        okButton.click();
    }

    @Override
    protected void load() {
        $(MEDIA_BLOCK).shouldBe(Condition.visible.because("не отобразилась колонка меню"));
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("Menu column didn't load", $(MEDIA_BLOCK).exists());
    }
}
