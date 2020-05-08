import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.val;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogPage {
    public CatalogPage() {
    }

    private SelenideElement deck = $(By.className("card-deck"));
    private SelenideElement tour0 = deck.$("[href='/tour/0']");
    private SelenideElement tour0Image = tour0.$(By.className("card-img-top"));
    private SelenideElement tour0DescriptionBody = tour0.$(By.className("card-body"));
    private SelenideElement tour0Name = tour0DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour0ShortDescription = tour0DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour0Flush = tour0.$(By.className("list-group-flush"));
    private SelenideElement tour0NearestDate = tour0Flush.$(withText("Ближайший:"));
    private SelenideElement tour0MinimumPrice = tour0Flush.$(byText("Минимальная цена:"));

    private SelenideElement tourPage = $("[id=page-content]");
    private SelenideElement tourPageImage = tourPage.$(By.className("photo-card"));
    private SelenideElement tourPageName = tourPage.$(By.cssSelector("h1"));
    private SelenideElement tourDescription = tourPage.$(By.className("col"));
    private SelenideElement tourPriceTable = tourPage.$(By.className("price-table"));
    private SelenideElement tourPageButton = tourPriceTable.$(By.cssSelector("button"));
    private SelenideElement tourPageBasketSymbol = tourPriceTable.$(withText("В корзине"));
    private SelenideElement tourPageHeader= $(By.className("navbar-expand-sm"));
    private SelenideElement tourPageBasketButton = tourPageHeader.$(withText("Корзина"));

    private SelenideElement pageBody = $("[id=page-content]");
    private SelenideElement basketBlock = pageBody.$(byClassName("col"));
    private SelenideElement basketTourName = basketBlock.$(By.cssSelector("a"));
    private SelenideElement basketCanselButton = basketBlock.$(byTitle("Удалить из корзины"));
    private SelenideElement basketAllertMessage = basketBlock.$(withText("Корзина пуста - попрбуйте добавить в нее поездки из каталога."));



public void tour0Clicker() {
    tour0.click();
}
    public void tour0InfoChecker() {
        tour0Name.shouldBe(visible);
        tour0Name.shouldBe(visible);
        tour0ShortDescription.shouldBe(visible);
    }

    public void tour0LinkChecker() {
        tour0Image.click();
        assertEquals(DataHelper.TourPageUrl.getTour0PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour0ShortDescription.click();
        assertEquals(DataHelper.TourPageUrl.getTour0PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour0NearestDate.click();
        assertEquals(DataHelper.TourPageUrl.getTour0PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour0MinimumPrice.click();
        assertEquals(DataHelper.TourPageUrl.getTour0PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());

    }

    public void tour0PageInfoChecker() {
        String tour0ImageStr = tour0Image.getAttribute("src");
        String tour0NameStr = tour0Name.text();
        String tour0ShortDescriptionStr = tour0ShortDescription.text();
        tour0Clicker();
        assertEquals(tour0ImageStr, tourPageImage.getAttribute("src"));
        assertEquals(tour0NameStr, tourPageName.text());
        String tour0DescriptionWithNameStr = tourDescription.text();
        String tour0PageNameStr = tourPageName.text();
        String tour0DescriptionStr = tour0DescriptionWithNameStr.substring(tour0PageNameStr.length()+1);
        assertEquals(tour0ShortDescriptionStr, tour0DescriptionStr);
    }

    public void tourOrderChecker() {
        tourPageButton.click();
        tourPageBasketSymbol.shouldBe(visible);
        tourPageBasketButton.click();
    }

    public String tourNameTextReturner() {
        String tourPageTextStr = tourPageName.text();
        return tourPageTextStr;
    }

    public String tourUrlReturner() {
    String tourUrl = WebDriverRunner.url();
    return tourUrl;
    }

    public String basketTourNameTextReturner() {
        String basketTourNameStr = basketTourName.text();
        return basketTourNameStr;
    }

    public String basketTourNameHrefReturner() {
    String basketTourNameHrefStr = basketTourName.getAttribute("href");
    return basketTourNameHrefStr;
    }

    public void basketPageOpener() {
        assertEquals(DataHelper.TourPageUrl.getBasketUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
    }

    public void basketCancelChecker() {
    basketCanselButton.click();
    basketAllertMessage.shouldBe(visible);
    }

}


