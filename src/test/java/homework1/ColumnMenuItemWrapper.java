package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class ColumnMenuItemWrapper {
    private static final Logger LOGGER = Logger.getLogger("Column menu");
    private static final By ITEM_PICTURE = By.xpath(".//*[@class='svg-ic svg-ico_users_3_18 tico_img null']");
    private final SelenideElement item;

    public ColumnMenuItemWrapper(SelenideElement item) {
        this.item = item;
    }

    public OkGroupsPage clickOnItemMenu() {
        item.hover().$(ITEM_PICTURE)
                .shouldBe(Condition.visible).click();
        return new OkGroupsPage();
    }
}
