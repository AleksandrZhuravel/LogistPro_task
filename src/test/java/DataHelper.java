import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    DataHelper() {
    }

    // Java-класс DataHelper создан для генерации тестовых данных

    //внутренний Java-класс TourPageUrl создан для получения текущего URL и передачи URL туров
    @Value
    public static class TourPageUrl {
        private String tourPageUrl;

        //метода получения текущего URL
        public static TourPageUrl getCurrentPageUrl() {
            String currentUrl = WebDriverRunner.url();
            return new TourPageUrl(currentUrl);
        }

        //метода передачи URL тура(tour0)
        public static TourPageUrl getBasketUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/cart/");
        }

        //метода передачи URL тура(tour0)
        public static TourPageUrl getTour0PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/0");
        }

        //метода передачи URL тура(tour1)
        public static TourPageUrl getTour1PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/1");
        }

        //метода передачи URL тура(tour50)
        public static TourPageUrl getTour50PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/50");
        }

        //метода передачи URL тура(tour77)
        public static TourPageUrl getTour77PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/77");
        }

        //метода передачи URL тура(tour99)
        public static TourPageUrl getTour99PageUrl() {
            return new TourPageUrl("https://bamboo.dev.sozvezdie-tour.ru/tour/99");
        }

    }

    /*внутренний Java-класс TourPageUrl создан для генерации и передачи данных для заполнения полей ввода регистрации
    Пользователя */
    @Value
    public static class RegInfo {
        private String userName;
        private String userEmail;
        private String userPass;

        //метод генерации тестовых данных(позитив)
        public static RegInfo getValidInfo() {
            Faker faker = new Faker();
            return new RegInfo(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password());
        }

        //метод передачи тестовых данных на русском языке(негатив)
        public static RegInfo getRusLangInfo() {
            return new RegInfo("Иван", "почта@gmail.com", "Цц");
        }

        //метод передачи тестовых данных на другом славянском языке(негатив)
        public static RegInfo getSlavLangInfo() {
            return new RegInfo("ў", "ў@gmail.com", "ўў");
        }

        //метод передачи тестовых данных из спецсимволов(негатив)
        public static RegInfo getSpecCharInfo() {
            return new RegInfo("@@", "@@", "@@");
        }

    }

    //внутренний Java-класс CardInfo создан для генерации и передачи данных для заполнения полей ввода банковской карты
    @Value
    public static class CardInfo {
        private String cardNumber;
        private String cardName;
        private String cardExpiry;
        private String cardCvc;

        //метод генерации тестовых данных(позитив)
        public static CardInfo getValidInfo() {
            Faker faker = new Faker();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            return new CardInfo(faker.finance().creditCard().replaceAll("[^0-9]", ""), faker.name().fullName(), LocalDate.now().plusYears(1).format(formatter), Integer.toString(faker.number().numberBetween(100, 999)));
        }

        //метод передачи тестовых данных на русском языке(негатив)
        public static CardInfo getRusLangInfo() {
            return new CardInfo("ццццццццццццццц", "Иван Иванов", "цц/цц", "ццц");
        }

        //метод передачи тестовых данных на другом славянском языке(негатив)
        public static CardInfo getSlavLangInfo() {
            return new CardInfo("ўўўўўўўўўўўўўўўў", "ў", "ўў/ўў", "ўўў");
        }

        //метод передачи тестовых данных из спецсимволов(негатив)
        public static CardInfo getSpecCharInfo() {
            return new CardInfo("@@@@@@@@@@@@@@@@", "@@", "@@/@@", "@@@");
        }

        //метод передачи тестовых данных, количестовом меньше допустимого(негатив)
        public static CardInfo getLessSymbol() {
            return new CardInfo("11111111111111", "11", "11/1", "11");
        }

        //метод передачи тестовых данных, количестовом больше допустимого(негатив)
        public static CardInfo getMoreSymbol() {
            return new CardInfo("11111111111111111", "11", "11/11111", "1111");
        }

        //метод генерации даты срока действия карты более ранней, чем текущая(негатив)
        public static CardInfo getExpiredCardInfo() {
            Faker faker = new Faker();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            return new CardInfo(faker.finance().creditCard().replaceAll("[^0-9]", ""), faker.name().fullName(), LocalDate.now().minusYears(1).format(formatter), Integer.toString(faker.number().numberBetween(100, 999)));
        }
    }
}
