Статус проведенных тестов:
[![Build status](https://ci.appveyor.com/api/projects/status/1hoaj1pqi7wyit1r?svg=true)](https://ci.appveyor.com/project/AleksandrZhuravel/aqa-diploma)








### Тестовое задание на позицию инженера-тестировщика ООО ЛогистПро
#### Проведение автоматизации тестирования приложения, демонстрирующего работу витрины интернет-магазина.
**Тестируемая функциональность:** Просматривать каталог с полным списком предложений и краткой информацией по каждому;
                                  Просматривать детальную информацию по предложению, переходом из карточки каталога;
                                  Наполнять "корзину" пользователя;
                                  Оформлять "покупку" из интерфейса корзины;
                                  Автоматически регистрировать пользователя после первой покупки.

Позитивное и негативное функциональное тестирование

**Количество автоматизированных тестов:** 24

#### Описание процедуры запуска авто-тестов:

##### 1. Общие действия для запуска приложения:

1) Запустить IntelliJ IDEA;
2) Открыть терминал IntelliJ IDEA(в дальнейшем - Терминал);
3) Ввести в Терминал команду "gradlew clean test allureReport";
4) Проверить отчёт о проведении авто-тестов в файле "index.html" по адресу "build/reports/allure-report/"(либо ввести в Терминал команду "gradlew allureServe").

##### 2. Перечень используемых инструментов с обоснованием выбора:
   * IntelliJ IDEA -  интегрированная среда разработки программного обеспечения.Выбрана в связи с установившейся практикой.
   * Java 8 - язык написания авто-тестов. Выбран в связи с установившейся практикой.
   * GitHub - система для хостинга проекта тестирования и его совместной разработки. Выбрана в связи с установившейся практикой.
   * JUnit - платформа для написания автотестов и их запуска. Выбрана в связи с установившейся практикой. 
   * Gradle - система управления зависимостями. Выбрана в связи с установившейся практикой.
       * Lombok - плагин для добавления дополнительных аннотаций. Выбран для сокращения временных затрат при написании авто-тестов.
	   * JavaFaker - библиотека для генерации тестовых данных. Выбран для сокращения временных затрат при заполнении полей ввода сервиса.
   * Selenide - фреймворк для автоматизированного тестирования веб-приложений.  Выбран для сокращения временных затрат при написании авто-тестов.
   * Allure - фреймворк для составления отчетности при проведении автоматизированного тестирования. Выбран для мониторинга результатов тестирования, 
     с целью сокращения временных затрат при развертывании системы мониторинга.
  