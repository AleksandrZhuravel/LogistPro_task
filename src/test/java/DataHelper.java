import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    DataHelper() {
    }

    @Value
    public static class TourPageUrl {
        private String tourPageUrl;

        public static TourPageUrl getCurrentPageUrl() {
            String currentUrl = WebDriverRunner.url();
            return new TourPageUrl(currentUrl);
        }

        public static TourPageUrl getBasketUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/cart/");
        }

        public static TourPageUrl getTour0PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/0");
        }


    }
}
