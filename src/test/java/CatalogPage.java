import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogPage {
    public CatalogPage() {
    }

// Java-класс CatalogPag создан для оформления методов по тестированию страницы каталога, карт туров и корзины

    // Selenide-элементы для доступа к элементам карты тура "Псков – Печоры – Пушкинские Горы, 2 дня"(tour0, эталонный)
    private SelenideElement deck = $(By.className("card-deck"));
    private SelenideElement tour0 = deck.$("[href='/tour/0']");
    private SelenideElement tour0Image = tour0.$(By.className("card-img-top"));
    private SelenideElement tour0DescriptionBody = tour0.$(By.className("card-body"));
    private SelenideElement tour0Name = tour0DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour0ShortDescription = tour0DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour0Flush = tour0.$(By.className("list-group-flush"));
    private SelenideElement tour0NearestDate = tour0Flush.$(withText("Ближайший:"));
    private SelenideElement tour0MinimumPrice = tour0Flush.$(byText("Минимальная цена:"));

    // Selenide-элементы для доступа к элементам карты тура "Курортный отдых в Старой Руссе"(tour1)
    private SelenideElement tour1 = deck.$("[href='/tour/1']");
    private SelenideElement tour1Image = tour1.$(By.className("card-img-top"));
    private SelenideElement tour1DescriptionBody = tour1.$(By.className("card-body"));
    private SelenideElement tour1Name = tour1DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour1ShortDescription = tour1DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour1Flush = tour1.$(By.className("list-group-flush"));
    private SelenideElement tour1NearestDate = tour1Flush.$(withText("Ближайший:"));
    private SelenideElement tour1MinimumPrice = tour1Flush.$(byText("Минимальная цена:"));

    // Selenide-элементы для доступа к элементам карты тура "Премиум Фьорды + Копенгаген (авиа), 7 дней"(tour50)
    private SelenideElement tour50 = deck.$("[href='/tour/50']");
    private SelenideElement tour50Image = tour50.$(By.className("card-img-top"));
    private SelenideElement tour50DescriptionBody = tour50.$(By.className("card-body"));
    private SelenideElement tour50Name = tour50DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour50ShortDescription = tour50DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour50Flush = tour50.$(By.className("list-group-flush"));
    private SelenideElement tour50NearestDate = tour50Flush.$(withText("Ближайший:"));
    private SelenideElement tour50MinimumPrice = tour50Flush.$(byText("Минимальная цена:"));

    // Selenide-элементы для доступа к элементам карты тура "Незабываемые фьорды"(tour77)
    private SelenideElement tour77 = deck.$("[href='/tour/77']");
    private SelenideElement tour77Image = tour77.$(By.className("card-img-top"));
    private SelenideElement tour77DescriptionBody = tour77.$(By.className("card-body"));
    private SelenideElement tour77Name = tour77DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour77ShortDescription = tour77DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour77Flush = tour77.$(By.className("list-group-flush"));
    private SelenideElement tour77NearestDate = tour77Flush.$(withText("Ближайший:"));
    private SelenideElement tour77MinimumPrice = tour77Flush.$(byText("Минимальная цена:"));

    // Selenide-элементы для доступа к элементам карты тура "Белоруссия. Минск, 2 дня"(tour99)
    private SelenideElement tour99 = deck.$("[href='/tour/99']");
    private SelenideElement tour99Image = tour99.$(By.className("card-img-top"));
    private SelenideElement tour99DescriptionBody = tour99.$(By.className("card-body"));
    private SelenideElement tour99Name = tour99DescriptionBody.$(By.className("card-title"));
    private SelenideElement tour99ShortDescription = tour99DescriptionBody.$(By.className("card-text"));
    private SelenideElement tour99Flush = tour99.$(By.className("list-group-flush"));
    private SelenideElement tour99NearestDate = tour99Flush.$(withText("Ближайший:"));
    private SelenideElement tour99MinimumPrice = tour99Flush.$(byText("Минимальная цена:"));

    // Selenide-элементы для доступа к элементам карты тура в корзине
    private SelenideElement tourPage = $("[id=page-content]");
    private SelenideElement tourPageImage = tourPage.$(By.className("photo-card"));
    private SelenideElement tourPageName = tourPage.$(By.cssSelector("h1"));
    private SelenideElement tourDescription = tourPage.$(By.className("col"));
    private SelenideElement tourPriceTable = tourPage.$(By.className("price-table"));
    private SelenideElement tourPageButton = tourPriceTable.$(By.cssSelector("button"));
    private SelenideElement tourPageBasketSymbol = tourPriceTable.$(withText("В корзине"));
    private SelenideElement tourPageHeader= $(By.className("navbar-expand-sm"));
    private SelenideElement tourPageBasketButton = tourPageHeader.$(withText("Корзина"));

    // Selenide-элементы для доступа к кнопке удаления заказа из корзины
    private SelenideElement pageBody = $("[id=page-content]");
    private SelenideElement basketBlock = pageBody.$(byClassName("col"));
    private SelenideElement basketTourName = basketBlock.$(By.cssSelector("a"));
    private SelenideElement basketCanselButton = basketBlock.$(byTitle("Удалить из корзины"));
    private SelenideElement basketAllertMessage = basketBlock.$(withText("Корзина пуста - попрбуйте добавить в нее поездки из каталога."));


    // Метод для выбора тура(tour0)
    public void tour0Clicker() {
        tour0.click();
    }

    // Метод для тестирования наличия элементов карты тура(tour0)
    public void tour0InfoChecker() {
        tour0Image.shouldBe(visible);
        tour0Name.shouldBe(visible);
        tour0ShortDescription.shouldBe(visible);
    }

    // Метод для тестирования переходы по клику по элементам карты тура(tour0)
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

    // Метод для тестирования соответствия элементов на карте тура(tour0) и на его странице
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


    // Метод для выбора тура(tour1)
    public void tour1Clicker() {
        tour1.click();
    }

    // Метод для тестирования наличия элементов карты тура(tour1)
    public void tour1InfoChecker() {
        tour1Image.shouldBe(visible);
        tour1Name.shouldBe(visible);
        tour1ShortDescription.shouldBe(visible);
    }

    // Метод для тестирования переходы по клику по элементам карты тура(tour1)
    public void tour1LinkChecker() {
        tour1Image.click();
        assertEquals(DataHelper.TourPageUrl.getTour1PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour1ShortDescription.click();
        assertEquals(DataHelper.TourPageUrl.getTour1PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour1NearestDate.click();
        assertEquals(DataHelper.TourPageUrl.getTour1PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour1MinimumPrice.click();
        assertEquals(DataHelper.TourPageUrl.getTour1PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());

    }

    // Метод для тестирования соответствия элементов на карте тура(tour1) и на его странице
    public void tour1PageInfoChecker() {
        String tour1ImageStr = tour1Image.getAttribute("src");
        String tour1NameStr = tour1Name.text();
        String tour1ShortDescriptionStr = tour1ShortDescription.text();
        tour1Clicker();
        assertEquals(tour1ImageStr, tourPageImage.getAttribute("src"));
        assertEquals(tour1NameStr, tourPageName.text());
        String tour1DescriptionWithNameStr = tourDescription.text();
        String tour1PageNameStr = tourPageName.text();
        String tour1DescriptionStr = tour1DescriptionWithNameStr.substring(tour1PageNameStr.length()+1);
        assertEquals(tour1ShortDescriptionStr, tour1DescriptionStr);
    }

    // Метод для выбора тура(tour50)
    public void tour50Clicker() {
        tour50.click();
    }

    // Метод для тестирования наличия элементов карты тура(tour50)
    public void tour50InfoChecker() {
        tour50Image.shouldBe(visible);
        tour50Name.shouldBe(visible);
        tour50ShortDescription.shouldBe(visible);
    }

    // Метод для тестирования переходы по клику по элементам карты тура(tour50)
    public void tour50LinkChecker() {
        tour50Image.click();
        assertEquals(DataHelper.TourPageUrl.getTour50PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour50ShortDescription.click();
        assertEquals(DataHelper.TourPageUrl.getTour50PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour50NearestDate.click();
        assertEquals(DataHelper.TourPageUrl.getTour50PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour50MinimumPrice.click();
        assertEquals(DataHelper.TourPageUrl.getTour50PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());

    }

    // Метод для тестирования соответствия элементов на карте тура(tour50) и на его странице
    public void tour50PageInfoChecker() {
        String tour50ImageStr = tour50Image.getAttribute("src");
        String tour50NameStr = tour50Name.text();
        String tour50ShortDescriptionStr = tour50ShortDescription.text();
        tour50Clicker();
        assertEquals(tour50ImageStr, tourPageImage.getAttribute("src"));
        assertEquals(tour50NameStr, tourPageName.text());
        String tour50DescriptionWithNameStr = tourDescription.text();
        String tour50PageNameStr = tourPageName.text();
        String tour50DescriptionStr = tour50DescriptionWithNameStr.substring(tour50PageNameStr.length()+1);
        assertEquals(tour50ShortDescriptionStr, tour50DescriptionStr);
    }

    // Метод для выбора тура(tour77)
    public void tour77Clicker() {
        tour77.click();
    }

    // Метод для тестирования наличия элементов карты тура(tour77)
    public void tour77InfoChecker() {
        tour77Image.shouldBe(visible);
        tour77Name.shouldBe(visible);
        tour77ShortDescription.shouldBe(visible);
    }

    // Метод для тестирования переходы по клику по элементам карты тура(tour77)
    public void tour77LinkChecker() {
        tour77Image.click();
        assertEquals(DataHelper.TourPageUrl.getTour77PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour77ShortDescription.click();
        assertEquals(DataHelper.TourPageUrl.getTour77PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour77NearestDate.click();
        assertEquals(DataHelper.TourPageUrl.getTour77PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour77MinimumPrice.click();
        assertEquals(DataHelper.TourPageUrl.getTour77PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());

    }

    // Метод для тестирования соответствия элементов на карте тура(tour77) и на его странице
    public void tour77PageInfoChecker() {
        String tour77ImageStr = tour77Image.getAttribute("src");
        String tour77NameStr = tour77Name.text();
        String tour77ShortDescriptionStr = tour77ShortDescription.text();
        tour77Clicker();
        assertEquals(tour77ImageStr, tourPageImage.getAttribute("src"));
        assertEquals(tour77NameStr, tourPageName.text());
        String tour77DescriptionWithNameStr = tourDescription.text();
        String tour77PageNameStr = tourPageName.text();
        String tour77DescriptionStr = tour77DescriptionWithNameStr.substring(tour77PageNameStr.length()+1);
        assertEquals(tour77ShortDescriptionStr, tour77DescriptionStr);
    }

    // Метод для выбора тура(tour99)
    public void tour99Clicker() {
        tour99.click();
    }

    // Метод для тестирования наличия элементов карты тура(tour99)
    public void tour99InfoChecker() {
        tour99Image.shouldBe(visible);
        tour99Name.shouldBe(visible);
        tour99ShortDescription.shouldBe(visible);
    }

    // Метод для тестирования переходы по клику по элементам карты тура(tour99)
    public void tour99LinkChecker() {
        tour99Image.click();
        assertEquals(DataHelper.TourPageUrl.getTour99PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour99ShortDescription.click();
        assertEquals(DataHelper.TourPageUrl.getTour99PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour99NearestDate.click();
        assertEquals(DataHelper.TourPageUrl.getTour99PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
        back();
        tour99MinimumPrice.click();
        assertEquals(DataHelper.TourPageUrl.getTour99PageUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());

    }

    // Метод для тестирования соответствия элементов на карте тура(tour99) и на его странице
    public void tour99PageInfoChecker() {
        String tour99ImageStr = tour99Image.getAttribute("src");
        String tour99NameStr = tour99Name.text();
        String tour99ShortDescriptionStr = tour99ShortDescription.text();
        tour99Clicker();
        assertEquals(tour99ImageStr, tourPageImage.getAttribute("src"));
        assertEquals(tour99NameStr, tourPageName.text());
        String tour99DescriptionWithNameStr = tourDescription.text();
        String tour99PageNameStr = tourPageName.text();
        String tour99DescriptionStr = tour99DescriptionWithNameStr.substring(tour99PageNameStr.length()+1);
        assertEquals(tour99ShortDescriptionStr, tour99DescriptionStr);
    }

     //общие методы

    //метод для выбора заказа и перехода в корзину
    public void tourOrderChecker() {
        tourPageButton.click();
        tourPageBasketSymbol.shouldBe(visible);
        tourPageBasketButton.click();
    }

    //метод для получения названия тура
    public String tourNameTextReturner() {
        String tourPageTextStr = tourPageName.text();
        return tourPageTextStr;
    }

    //метод для получения ссылки на тур
    public String tourUrlReturner() {
    String tourUrl = WebDriverRunner.url();
    return tourUrl;
    }

    //метод для получения названия тура из корзины
    public String basketTourNameTextReturner() {
        String basketTourNameStr = basketTourName.text();
        return basketTourNameStr;
    }

    //метод для получения ссылки на тур из корзины
    public String basketTourNameHrefReturner() {
    String basketTourNameHrefStr = basketTourName.getAttribute("href");
    return basketTourNameHrefStr;
    }

    //метод для сравнения ссылки на тур из корзины и текущего URL
    public void basketPageOpener() {
        assertEquals(DataHelper.TourPageUrl.getBasketUrl(),DataHelper.TourPageUrl.getCurrentPageUrl());
    }

    //метод для тестирования появления сообщения в корзине
    public void basketCancelChecker() {
        basketCanselButton.scrollIntoView(true);
        basketCanselButton.click();
        basketAllertMessage.shouldBe(visible);
    }

    public void basketExiter() {
        basketCanselButton.scrollIntoView(true);
        basketCanselButton.click();
    }

}


