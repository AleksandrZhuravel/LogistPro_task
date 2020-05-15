
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTester {

    @BeforeEach
    public void openPage() {
        open("https://bamboo.dev.sozvezdie-tour.ru/cat/");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //Общее тестирование тура "Псков – Печоры – Пушкинские Горы, 2 дня"(tour0, эталонный) тесты 01-03
    @Test
    @DisplayName(value = "01. Tour0 information must be visible")
    void tour0InformationMustBeVisible() {
        val catalogPage = new CatalogPage();
        catalogPage.tour0InfoChecker();
    }

    @Test
    @DisplayName(value = "02. Click on any element of the map of tour0 should go to his page")
    void сlickOnAnyElementOfMapTour0ShouldGoToHisPage() {
        val catalogPage = new CatalogPage();
        catalogPage.tour0LinkChecker();
    }

    @Test
    @DisplayName(value = "03. Tour0 data on his map and his page must match")
    void tour0DataOnHisMapAndHisPageMustMatch() {
        val catalogPage = new CatalogPage();
        catalogPage.tour0PageInfoChecker();
    }

    //Тестирование наполнения корзины с последующим удалением заказа из неё
    @Test
    @DisplayName(value = "04. Order from tour0 should be put in the basket and deleted")
    void orderFromTour0ShouldBePutInBasketAndDeleted() {
        val catalogPage = new CatalogPage();
        catalogPage.tour0Clicker();
        String tourNameTextStr = catalogPage.tourNameTextReturner();
        String tourUrlStr = catalogPage.tourUrlReturner();
        catalogPage.tourOrderChecker();
        catalogPage.basketPageOpener();
        assertEquals(tourNameTextStr, catalogPage.basketTourNameTextReturner());
        assertEquals(tourUrlStr, catalogPage.basketTourNameHrefReturner());
        catalogPage.basketCancelChecker();
    }

    //Тестирование оформления заказа(позитивный сценарий)
    @Test
    @DisplayName(value = "05. Order from tour0 should be put in the basket and paid with user registration")
    void orderFromTour0ShouldBePutInBasketAndPaidWithRegistration() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.userRegister(DataHelper.RegInfo.getValidInfo());
        checkoutPage.cardFill(DataHelper.CardInfo.getValidInfo());
        checkoutPage.formButtonClicker();
        checkoutPage.alertMessageChecker();
    }

    //Тестирование оформления заказа(негативные сценарии) тесты 06-12
    @Test
    @DisplayName(value = "06. With empty form fields, invalid-feedback should appear")
    void withEmptyFormFieldsInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.enterClicker();
        checkoutPage.emptyFieldsChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "07. With fields filled in Russian language, invalid-feedback should appear")
    void withFieldsFilledRussianInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.userRegister(DataHelper.RegInfo.getRusLangInfo());
        checkoutPage.cardFill(DataHelper.CardInfo.getRusLangInfo());
        checkoutPage.enterClicker();
        checkoutPage.rusLangFieldsChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "08. With fields filled in Slavic language, invalid-feedback should appear")
    void withFieldsFilledSlavicInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.userRegister(DataHelper.RegInfo.getSlavLangInfo());
        checkoutPage.cardFill(DataHelper.CardInfo.getSlavLangInfo());
        checkoutPage.enterClicker();
        checkoutPage.rusLangFieldsChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "09. With fields filled in special characters, invalid-feedback should appear")
    void withFieldsFilledSpecCharInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.userRegister(DataHelper.RegInfo.getSpecCharInfo());
        checkoutPage.cardFill(DataHelper.CardInfo.getSpecCharInfo());
        checkoutPage.enterClicker();
        checkoutPage.rusLangFieldsChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "10. With fields filled in less symbols, invalid-feedback should appear")
    void withFieldsFilledLessSymbInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.cardFill(DataHelper.CardInfo.getLessSymbol());
        checkoutPage.enterClicker();
        checkoutPage.lessSymbolCardChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "11. With fields filled in more symbols, invalid-feedback should appear")
    void withFieldsFilledMoreSymbInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.cardFill(DataHelper.CardInfo.getMoreSymbol());
        checkoutPage.enterClicker();
        checkoutPage.lessSymbolCardChecker();
        catalogPage.basketExiter();
    }

    @Test
    @DisplayName(value = "12. With validity card field filled in last year, invalid-feedback should appear")
    void withValidityCardFieldFilledLastYearInvalidFeedbackShouldAppear() {
        val catalogPage = new CatalogPage();
        val checkoutPage = new CheckoutPage();
        catalogPage.tour0Clicker();
        catalogPage.tourOrderChecker();
        checkoutPage.cardFill(DataHelper.CardInfo.getExpiredCardInfo());
        checkoutPage.enterClicker();
        checkoutPage.validityCardChecker();
        catalogPage.basketExiter();
    }

    //Общее тестирование тура "Курортный отдых в Старой Руссе"(tour1) тесты 13-15

    @Test
    @DisplayName(value = "13. Tour1 information must be visible")
    void tour1InformationMustBeVisible() {
        val catalogPage = new CatalogPage();
        catalogPage.tour1InfoChecker();
    }

    @Test
    @DisplayName(value = "14. Click on any element of the map of tour1 should go to his page")
    void сlickOnAnyElementOfMapTour1ShouldGoToHisPage() {
        val catalogPage = new CatalogPage();
        catalogPage.tour1LinkChecker();
    }

    @Test
    @DisplayName(value = "15. Tour1 data on his map and his page must match")
    void tour1DataOnHisMapAndHisPageMustMatch() {
        val catalogPage = new CatalogPage();
        catalogPage.tour1PageInfoChecker();
    }

    //Общее тестирование тура "Премиум Фьорды + Копенгаген (авиа), 7 дней"(tour50) тесты 16-18

    @Test
    @DisplayName(value = "16. Tour50 information must be visible")
    void tour50InformationMustBeVisible() {
        val catalogPage = new CatalogPage();
        catalogPage.tour50InfoChecker();
    }

    @Test
    @DisplayName(value = "17. Click on any element of the map of tour50 should go to his page")
    void сlickOnAnyElementOfMapTour50ShouldGoToHisPage() {
        val catalogPage = new CatalogPage();
        catalogPage.tour50LinkChecker();
    }

    @Test
    @DisplayName(value = "18. Tour50 data on his map and his page must match")
    void tour50DataOnHisMapAndHisPageMustMatch() {
        val catalogPage = new CatalogPage();
        catalogPage.tour50PageInfoChecker();
    }

    //Общее тестирование тура "Незабываемые фьорды"(tour77) тесты 19-21

    @Test
    @DisplayName(value = "19. Tour77 information must be visible")
    void tour77InformationMustBeVisible() {
        val catalogPage = new CatalogPage();
        catalogPage.tour77InfoChecker();
    }

    @Test
    @DisplayName(value = "20. Click on any element of the map of tour77 should go to his page")
    void сlickOnAnyElementOfMapTour77ShouldGoToHisPage() {
        val catalogPage = new CatalogPage();
        catalogPage.tour77LinkChecker();
    }

    @Test
    @DisplayName(value = "21. Tour77 data on his map and his page must match")
    void tour77DataOnHisMapAndHisPageMustMatch() {
        val catalogPage = new CatalogPage();
        catalogPage.tour77PageInfoChecker();
    }

    //Общее тестирование тура "Белоруссия. Минск, 2 дня"(tour99) тесты 22-24

    @Test
    @DisplayName(value = "22. Tour99 information must be visible")
    void tour99InformationMustBeVisible() {
        val catalogPage = new CatalogPage();
        catalogPage.tour99InfoChecker();
    }

    @Test
    @DisplayName(value = "23. Click on any element of the map of tour99 should go to his page")
    void сlickOnAnyElementOfMapTour99ShouldGoToHisPage() {
        val catalogPage = new CatalogPage();
        catalogPage.tour99LinkChecker();
    }

    @Test
    @DisplayName(value = "24. Tour99 data on his map and his page must match")
    void tour99DataOnHisMapAndHisPageMustMatch() {
        val catalogPage = new CatalogPage();
        catalogPage.tour99PageInfoChecker();
    }
}