package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class OkGroupsPage extends LoadableComponent<OkGroupsPage> {
    private static final Logger LOGGER = Logger.getLogger("Страница групп");
    private static final By MEDIA_BLOCK = By.xpath(".//*[@class='portlet ']");
    private final String xpathForGroup = ".//*[@class='portlet ']//*[@class='photo_img']";

    public static OkGroupsPage getGroupMenu() {
        ColumnMenuItemWrapper wrapper = new ColumnMenuItemWrapper($x(".//*[@class='navigation']"));
        return wrapper.clickOnItemMenu();
    }


    public GroupPage getGroup() {
        $x(xpathForGroup).shouldBe(Condition.visible).click();

        return new GroupPage();
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
