import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.back;
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
/*
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
    }*/

    @Test
    @DisplayName(value = "04. Order from tour0 should be put in the basket")
    void orderFromTour0ShouldBePutInBasket() {
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

}