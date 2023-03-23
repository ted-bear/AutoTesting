package homework1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OkProfilePage {

    public SelenideElement getPostName() {
        return $(".group-link.o");
    }

    public SelenideElement getPost() {
        return $x(".//div[contains(@data-l, 'fP,1,fD')]//div[contains(@class, 'vid-card')]");
    }

    public SelenideElement getPostDate() {
        return $(".feed_date");
    }

    public SelenideElement getProfileName() {
        return $(".tico.ellip");
    }
}
