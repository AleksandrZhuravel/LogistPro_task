import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

public CheckoutPage() {}

/* Java-класс CheckoutPage создан для оформления методов по тестированию формы регистрации Пользователя и заполения
    формы данных банковской карты */

/* Selenide-элементы для доступа к полям ввода формы регистрации Пользователя и заполения данных банковской карты,
 а так же к кнопке "Оплатить" */
    private SelenideElement pageBody = $("[id=page-content]");
    private SelenideElement basketBlock = pageBody.$(byClassName("col"));
    private SelenideElement formBlock = pageBody.$(byCssSelector("form"));
    private SelenideElement formGroup = pageBody.$(byClassName("form-group"));
    private SelenideElement userName = pageBody.$("[id = name]");
    private SelenideElement userEmail = pageBody.$("[id = email");
    private SelenideElement userPass = pageBody.$("[id = password]");
    private SelenideElement cardNumber = pageBody.$("[id = cardNumber]");
    private SelenideElement cardName = pageBody.$("[id = cardName]");
    private SelenideElement cardExpiry = pageBody.$("[id = cardExpiry]");
    private SelenideElement cardCvc = pageBody.$("[id = cardCvc]");
    private SelenideElement formButton = pageBody.$(byCssSelector("button"));
    private SelenideElement alertMessage = pageBody.$(byClassName("alert-info"));

    /* Selenide-элементы для доступа к кнопке профиля Пользователя в хедере страницы */
    private SelenideElement pageHeader= $(By.className("navbar-expand-sm"));
    private SelenideElement profileOpenButton = $(By.className("dropdown"));
    private SelenideElement profileExitButton = $(By.className("dropdown-menu"));

    /* Selenide-элементы для доступа к сообщениям под полями ввода формы регистрации Пользователя и заполения
    данных банковской карты */
    private SelenideElement userNameMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[1]/div/div"));
    private SelenideElement userEmailMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[2]/div/div"));
    private SelenideElement userPassMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[3]/div/div"));
    private SelenideElement cardNumberMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[5]/div/div"));
    private SelenideElement cardNameMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[6]/div/div"));
    private SelenideElement cardExpiryMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[7]/div/div"));
    private SelenideElement cardCvcMessage = $(byXpath("/html/body/div[1]/div[1]/div[2]/form/div[8]/div/div"));

    // Метод для заполнения полей ввода формы регистрации Пользователя
    public void userRegister(DataHelper.RegInfo info) {
        basketBlock.scrollIntoView(true);
        userName.setValue(info.getUserName());
        userEmail.setValue(info.getUserEmail());
        userPass.setValue(info.getUserPass());
    }
    // Метод для заполнения полей ввода банковской карты
    public void cardFill(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        cardName.setValue(info.getCardName());
        cardExpiry.setValue(info.getCardExpiry());
        cardCvc.setValue(info.getCardCvc());
    }

    // Метод для нажатия на кнопку "Оплатить"
    public void formButtonClicker(){
        formButton.scrollIntoView(false);
        formButton.click();
    }

    // Метод для тестирования появления сообщения о том, что корзина пуста
    public void alertMessageChecker() {
        alertMessage.shouldBe(Condition.visible);
        alertMessage.shouldHave(text("Корзина пуста - попрбуйте добавить в нее поездки из каталога."));
    }

    // Метод для тестирования появления сообщений об ошибке, при оставлении полей ввода регистрации пустыми
    public void emptyFieldsChecker() {
        userNameMessage.shouldBe(visible);
        userNameMessage.shouldHave(text("Поле должно быть заполнено."));
        userEmailMessage.shouldBe(visible);
        userEmailMessage.shouldHave(text("Поле должно быть заполнено."));
        userPassMessage.shouldBe(visible);
        userPassMessage.shouldHave(text("Поле должно быть заполнено."));
        cardNumberMessage.shouldBe(visible);
        cardNumberMessage.shouldHave(text("Поле должно быть заполнено."));
        cardNameMessage.shouldBe(visible);
        cardNameMessage.shouldHave(text("Поле должно быть заполнено."));
        cardExpiryMessage.shouldBe(visible);
        cardExpiryMessage.shouldHave(text("Поле должно быть заполнено."));
        cardCvcMessage.shouldBe(visible);
        cardCvcMessage.shouldHave(text("Поле должно быть заполнено."));
    }

    // Метод для тестирования появления сообщений об ошибке, при заполнении полей ввода регистрации данными на русском языке
    public void rusLangFieldsChecker() {
        userEmailMessage.shouldBe(visible);
        userEmailMessage.shouldHave(text("Значение не соответствует формату."));
        cardNumberMessage.shouldBe(visible);
        cardNumberMessage.shouldHave(text("Значение не соответствует формату."));
        cardNameMessage.shouldBe(visible);
        cardNameMessage.shouldHave(text("Значение не соответствует формату."));
        cardExpiryMessage.shouldBe(visible);
        cardExpiryMessage.shouldHave(text("Значение не соответствует формату."));
        cardCvcMessage.shouldBe(visible);
        cardCvcMessage.shouldHave(text("Значение не соответствует формату."));
    }

    // Метод для тестирования появления сообщений об ошибке, при заполнении полей ввода регистрации спецсимволами
    public void lessSymbolCardChecker() {
        cardNumberMessage.shouldBe(visible);
        cardNumberMessage.shouldHave(text("Значение не соответствует формату."));
        cardExpiryMessage.shouldBe(visible);
        cardExpiryMessage.shouldHave(text("Значение не соответствует формату."));
        cardCvcMessage.shouldBe(visible);
        cardCvcMessage.shouldHave(text("Значение не соответствует формату."));
    }

    // Метод для тестирования появления сообщений об ошибке, при попытке оплаты картой с истекшим сроком действия
    public void validityCardChecker() {
        cardExpiryMessage.shouldBe(visible);
        cardExpiryMessage.shouldHave(text("Значение не соответствует формату."));
    }

    // Метод для нажатия на клавишу "Enter"
    public void enterClicker() {
        cardCvc.click();
        cardCvc.sendKeys(Keys.ENTER);
    }
}


