package mailru.nastasiachernega.tests.interractions;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.interractions.SortablePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class TestsSortable extends WebDriverProvider {

    SortablePage sortablePage = new SortablePage();

    @Epic("demoqa.com")
    @Feature("Sortable")
    @Story("Сортировка контейнеров: перенос снизу вверх")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Sortable", url = "https://demoqa.com/sortable")
    @DisplayName("Сортировка контейнеров: перенос снизу вверх")
    @CsvSource(value = {
            "One, Six",
            "Three, Five"
    })
    @ParameterizedTest
    void testMoveDownUp(String boxFrom, String boxTo) {

        step("Открываем раздел Sortable", () -> {
            sortablePage.openPage();
        });

        step("Проверяем первоначальный порядок контейнеров ", () -> {
            sortablePage.checkInitialOrder();
        });

        step("Сдвигаем контейнер " + boxFrom
                + " на позицию контейнера " + boxTo, () -> {
            sortablePage.dragAndDrop(boxFrom, boxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(boxFrom, boxTo);
        });

    }

    @Epic("demoqa.com")
    @Feature("Sortable")
    @Story("Сортировка контейнеров: перенос сверху вниз")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Sortable", url = "https://demoqa.com/sortable")
    @DisplayName("Сортировка контейнеров: перенос сверху вниз")
    @CsvSource(value = {
            "Four, One",
            "Six, Three"
    })
    @ParameterizedTest
    void testMoveUpDown(String boxFrom, String boxTo) {

        step("Открываем раздел Sortable", () -> {
            sortablePage.openPage();
        });

        step("Проверяем первоначальный порядок контейнеров ", () -> {
            sortablePage.checkInitialOrder();
        });

        step("Сдвигаем контейнер " + boxFrom
                + " на позицию контейнера " + boxTo, () -> {
            sortablePage.dragAndDrop(boxFrom, boxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(boxFrom, boxTo);
        });

    }

    @Epic("demoqa.com")
    @Feature("Sortable")
    @Story("Сортировка контейнеров: перенос снизу вверх, затем сверху вниз")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Sortable", url = "https://demoqa.com/sortable")
    @DisplayName("Сортировка контейнеров: перенос снизу вверх, затем сверху вниз")
    @CsvSource(value = {
            "Three, Six, Four, One",
            "Two, Four, Two, Three"
    })
    @ParameterizedTest
    void testMoveDownUpAndUpDown(String firstBoxFrom, String firstBoxTo,
                                 String secondBoxFrom, String secondBoxTo) {

        step("Открываем раздел Sortable", () -> {
            sortablePage.openPage();
        });

        step("Проверяем первоначальный порядок контейнеров ", () -> {
            sortablePage.checkInitialOrder();
        });

        step("Сдвигаем контейнер " + firstBoxFrom
                + " на позицию контейнера " + firstBoxTo, () -> {
            sortablePage.dragAndDrop(firstBoxFrom, firstBoxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(firstBoxFrom, firstBoxTo);
        });

        step("Сдвигаем контейнер " + secondBoxFrom
                + " на позицию контейнера " + secondBoxTo, () -> {
            sortablePage.dragAndDrop(secondBoxFrom, secondBoxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(secondBoxFrom, secondBoxTo);
        });

    }

    @Epic("demoqa.com")
    @Feature("Sortable")
    @Story("Сортировка контейнеров: перенос сверху вниз, затем снизу вверх")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Sortable", url = "https://demoqa.com/sortable")
    @DisplayName("Сортировка контейнеров: перенос сверху вниз, затем снизу вверх")
    @CsvSource(value = {
            "Six, Two, One, Four",
            "Four, Three, Four, Six"
    })
    @ParameterizedTest
    void testMovedUpDownAndDownUp(String firstBoxFrom, String firstBoxTo,
                                  String secondBoxFrom, String secondBoxTo) {

        step("Открываем раздел Sortable", () -> {
            sortablePage.openPage();
        });

        step("Проверяем первоначальный порядок контейнеров ", () -> {
            sortablePage.checkInitialOrder();
        });

        step("Сдвигаем контейнер " + firstBoxFrom
                + " на позицию контейнера " + firstBoxTo, () -> {
            sortablePage.dragAndDrop(firstBoxFrom, firstBoxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(firstBoxFrom, firstBoxTo);
        });

        step("Сдвигаем контейнер " + secondBoxFrom
                + " на позицию контейнера " + secondBoxTo, () -> {
            sortablePage.dragAndDrop(secondBoxFrom, secondBoxTo);
        });

        step("Проверяем новый порядок контейнеров:", () -> {
            sortablePage.checkNewOrder(secondBoxFrom, secondBoxTo);
        });

    }

}
