package homework1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class ColumnMenuItemWrapper {
    private static final Logger LOGGER = Logger.getLogger("Column menu");
    private static final By ITEM_PICTURE = By.xpath(".//*[@class=\"tico null\" and contains(text(),'Группы')]");
    private final SelenideElement item;

    public ColumnMenuItemWrapper(SelenideElement item) {
        this.item = item;
    }

    public OkGroupsPage clickOnItemMenu() {
        item.hover().$(ITEM_PICTURE)
                .shouldBe(Condition.visible.because("Невидима иконка групп")).click();
        return new OkGroupsPage();
    }
}
